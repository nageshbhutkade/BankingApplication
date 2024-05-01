package firstapp.stepone.service;

import java.util.List;

import firstapp.stepone.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountdto);

	List<AccountDto> getAllAccount();
	
	AccountDto updateAccount(AccountDto accountdto, Long id);
	
	AccountDto getAccount(Long id); 
	
	AccountDto withdraw(double amount, Long id);
	
	AccountDto deposite(double amount, Long id);
	
	
}
