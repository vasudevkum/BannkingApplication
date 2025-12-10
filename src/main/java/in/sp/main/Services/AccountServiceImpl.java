package in.sp.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Mapper.AccountMapper;
import in.sp.main.dto.AccountDTO;
import in.sp.main.entity.Account;
import in.sp.main.repository.AccountRepository;

@Service
public class AccountServiceImpl  implements AccountService {
	
	@Autowired
	
	private AccountRepository rep;

    @Autowired
    private AccountMapper mapper; 

	@Override
	public AccountDTO createAccount(AccountDTO dto) {
		// TODO Auto-generated method stub
		

        Account account = mapper.toentity(dto);  // ✅ correct usage

        Account saved = rep.save(account);

        return mapper.todto(saved); 
	}

	@Override
	public AccountDTO getAccountByid(int id) {
		// TODO Auto-generated method stub
		
		Account account=rep.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		
		return mapper.todto(account);
	}

	@Override
	public AccountDTO depositAmount(int id, double amount) {
		// TODO Auto-generated method stub
		Account account=rep.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
	double totalBalance=	account.getBalance()+amount;
	account.setBalance(totalBalance);
	Account savedaccount=rep.save(account);
		return mapper.todto(savedaccount);
	}

	@Override
	public AccountDTO WithdrawAMount(int id, double amount) {
		// TODO Auto-generated method stub
		Account account=rep.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("insuffecient balance");


		}
		else
		{
			double totalBalance=account.getBalance()-amount;
			account.setBalance(totalBalance);
			Account savedaccount=rep.save(account);
			return mapper.todto(savedaccount);
		}
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		// TODO Auto-generated method stub
		

	    List<Account> accounts = rep.findAll();

        // 2️⃣ Har entity ko DTO me convert karo
        return accounts.stream()
                       .map(mapper::todto)
                       .toList();  // Java 17 method
    }

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		Account account=rep.findById(id).orElseThrow(()->new RuntimeException("Account does not exit"));
		 rep.delete(account);
		
	}

	@Override
	public AccountDTO updateAccount(int id, AccountDTO dto) {
		// TODO Auto-generated method stub

		 Account account = rep.findById(id)
		          .orElseThrow(() -> new RuntimeException("Account not found"));

		    account.setAccountHolder(dto.getAccountHolder());
		    account.setEmail(dto.getEmail());
		    account.setBalance(dto.getBalance());

		    Account saved = rep.save(account);

		    return mapper.todto(saved);
	}
	}





