package com.qa.persistence.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.qa.constants.Constants;

@Entity
public class Account {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = Constants.ACCOUNT_ID)
	private long id;
	@Column (name = Constants.FIRST_NAME)
	@Pattern (regexp = "^[a-zA-Z]{2,30}", message = "Name must be between 2 and 30 english characters")
	private String firstName; 
	@Column (name = Constants.LAST_NAME)
	@Pattern (regexp = "^[a-zA-Z]{2,30}", message = "Name must be between 2 and 30 english characters")
	private String lastName;
	@Column(name = Constants.ACCOUNT_NUMBER, length = 6)
	@Size(min = 6, max = 6)
	private String accountNumber;
	@JoinColumn(name = Constants.ACCOUNT_ID)
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<Transaction> transactions;
	
	public Account(String firstName, String lastName, String accountNumber, List<Transaction> transactions) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.transactions = transactions;
	}
	
	public Account() {
		
	}

	public void setId(long id) { 
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	public void removeTransaction(Transaction transaction) {
		transactions.remove(transaction);
	}
	
	@Override
	public String toString() {
		return "Account Number: " + accountNumber 
		+ "\n" + "First Name: " + firstName 
		+ "\n" + "Last Name: " + lastName;
	}
}