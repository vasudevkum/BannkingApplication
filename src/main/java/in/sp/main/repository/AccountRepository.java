package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account,Integer> {
	

}
