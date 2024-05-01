package firstapp.stepone.Model.mapper;

import firstapp.stepone.Model.Account;
import firstapp.stepone.dto.AccountDto;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountdto) {
			Account account = new Account(
					accountdto.getId(),
					accountdto.getAccountHolderName(),
					accountdto.getBalance()
					);
			return account;
	}
	
	public static AccountDto maptoAccountDto(Account account) {
		AccountDto accountdto = new AccountDto(
					account.getId(),
					account.getAccountHolderName(),
					account.getBalance()
				);
		return accountdto;
	}
}
