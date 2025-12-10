package in.sp.main.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.sp.main.dto.AccountDTO;
import in.sp.main.entity.Account;

@Service
public interface AccountService {
	
	public AccountDTO createAccount(AccountDTO dto);
	public AccountDTO getAccountByid(int id);
	public AccountDTO depositAmount(int id,double amount);
	public AccountDTO WithdrawAMount(int id,double amount);
	public List<AccountDTO> getAllAccount();
	public void deleteAccount(int id);
	public AccountDTO updateAccount(int id ,AccountDTO dto);;

	
	
	

}
