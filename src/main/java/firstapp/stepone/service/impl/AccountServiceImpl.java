package firstapp.stepone.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstapp.stepone.Model.Account;
import firstapp.stepone.Model.mapper.AccountMapper;
import firstapp.stepone.dto.AccountDto;
import firstapp.stepone.repository.AccountRepository;
import firstapp.stepone.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountrepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountdto); 
		Account savedacount = accountrepository.save(account);
		return AccountMapper.maptoAccountDto(savedacount);
	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts = accountrepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.maptoAccountDto(account)).collect(Collectors.toList()); 
	}

	@Override
	public AccountDto updateAccount(AccountDto accountdto, Long id) {
		// TODO Auto-generated method stub
		Account acc = accountrepository.findById(id).orElseThrow(()->new RuntimeException("Acount does not exist"));
//		acc.setId(id);
		if(accountdto.getBalance() > 0) {
			acc.setBalance(accountdto.getBalance());			
		}
		
		Optional<String> accountname = Optional.ofNullable(accountdto.getAccountHolderName());
		if(accountname.isPresent()) {
			acc.setAccountHolderName(accountdto.getAccountHolderName());			
		}

		return AccountMapper.maptoAccountDto(accountrepository.save(acc)); 
	}

	@Override
	public AccountDto getAccount(Long id) {
		// TODO Auto-generated method stub
		Account accont = accountrepository.findById(id).orElseThrow(() -> new RuntimeException("Ha Account nahi milat"));
		return AccountMapper.maptoAccountDto(accont);
	}

	@Override
	public AccountDto withdraw(double balance, Long id) {
		// TODO Auto-generated method stub
		Account acc = accountrepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		acc.setBalance(acc.getBalance() - balance);
		accountrepository.save(acc);
		return AccountMapper.maptoAccountDto(acc);
	}

	@Override
	public AccountDto deposite(double balance, Long id) {
		Account acc = accountrepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		System.out.println(acc);
		acc.setBalance(acc.getBalance() + balance);
		accountrepository.save(acc);
		return AccountMapper.maptoAccountDto(acc);
	}

}
