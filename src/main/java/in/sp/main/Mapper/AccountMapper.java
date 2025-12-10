package in.sp.main.Mapper;

import org.springframework.stereotype.Component;

import in.sp.main.dto.AccountDTO;
import in.sp.main.entity.Account;

@Component
public class AccountMapper {
	
	public AccountDTO todto(Account a)
	{
		
		AccountDTO dto=new AccountDTO();
		
		dto.setId(a.getId());
		dto.setAccountHolder(a.getAccountHolder());
		dto.setEmail(a.getEmail());
		dto.setBalance(a.getBalance());
		
		
		return dto;
	}
	
	public   Account toentity(AccountDTO dto)
	{
		
		Account a=new Account();
//		a.setId(dto.getId());
		a.setAccountHolder(dto.getAccountHolder());
		a.setEmail(dto.getEmail());
		a.setBalance(dto.getBalance());
		
		return a;
	}
	

}
