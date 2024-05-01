package firstapp.stepone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import firstapp.stepone.Model.Account;
import firstapp.stepone.dto.AccountDto;
import firstapp.stepone.service.AccountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccount(){
		return ResponseEntity.ok(accountservice.getAllAccount()) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto>  getMethodName(@PathVariable Long id) {
		return ResponseEntity.ok(accountservice.getAccount(id));
	}
	
	
	@PostMapping
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountdto) {
		return new ResponseEntity<>(accountservice.createAccount(accountdto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto entity) {
		return new ResponseEntity<>(accountservice.updateAccount(entity, id), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto>  withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		AccountDto accoudto =  accountservice.withdraw(request.get("amount"), id);
		return ResponseEntity.ok(accoudto);
	}
	
	@PutMapping("/{id}/deposite")
	public ResponseEntity<AccountDto>  deposite(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		AccountDto accoudto =  accountservice.deposite(request.get("amount"), id);
		return ResponseEntity.ok(accoudto);
	}
	
	
}
