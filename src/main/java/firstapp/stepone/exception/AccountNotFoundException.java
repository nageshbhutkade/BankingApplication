package firstapp.stepone.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AccountNotFoundException() {}
	
	public AccountNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
