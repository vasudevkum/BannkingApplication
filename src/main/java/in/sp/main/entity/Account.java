package in.sp.main.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String accountHolder;
    private String email;
    private Double balance;
    public Account() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Account(Integer id, String accountHolder, String email, Double balance) {
		super();
		this.id = id;
		this.accountHolder = accountHolder;
		this.email = email;
		this.balance = balance;
	}





	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", AccountHolder=" + accountHolder + ", email=" + email + ", balance=" + balance
				+ "]";
	}
	



}
