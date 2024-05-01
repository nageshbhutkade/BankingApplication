package firstapp.stepone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	Long id;
	String accountHolderName;
	double balance;
	
}
