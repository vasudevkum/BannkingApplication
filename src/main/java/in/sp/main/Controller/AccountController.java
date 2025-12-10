package in.sp.main.Controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Services.AccountService;
import in.sp.main.dto.AccountDTO;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin("http://localhost:3000")

public class AccountController {
	
	@Autowired
	private AccountService service;
	
	
	@PostMapping
	public  ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO dto)
{
	return new ResponseEntity<>(service.createAccount(dto),HttpStatus.CREATED);
			
}
	
	@GetMapping("{id}")
	public ResponseEntity<AccountDTO> getAccountbyid(@PathVariable int id)
	{
		AccountDTO dto= service.getAccountByid(id);
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> depositAmmount(@PathVariable int id ,@RequestBody Map<String,Double> request)
	
	{
		Double amount=request.get("amount");
		AccountDTO dto=service.depositAmount(id, amount);
		
		return ResponseEntity.ok(dto);
		
		
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable int id,@RequestBody Map<String,Double> request)
		
	{
		Double amount=request.get("amount");
		AccountDTO dto=service.WithdrawAMount(id, amount);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccounts() {
	    List<AccountDTO> list = service.getAllAccount();
	    return ResponseEntity.ok(list);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id)
	{
		service.deleteAccount(id);
		return ResponseEntity.ok("Account deleted Succesfully");
	}
	@PutMapping("/{id}")
	public ResponseEntity<AccountDTO> updateAccount(
	        @PathVariable int id,
	        @RequestBody AccountDTO dto) {

	    AccountDTO updated = service.updateAccount(id, dto);
	    return ResponseEntity.ok(updated);
	}

	}
	
	


