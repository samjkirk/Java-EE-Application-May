package domain;

import java.util.List;
import javax.persistence.*;
import constants.Constants;

@Entity
public class Account {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = Constants.ACCOUNT_ID)
	private long id;
	@Column (length = 40, name = Constants.FIRST_NAME)
	private String firstName;
	@Column (length = 40, name = Constants.LAST_NAME)
	private String lastName;
	@Column(name = Constants.ACCOUNT_NUMBER, length = 6)
	private String accountNumber;
	@OneToMany(mappedBy = Constants.ACCOUNT, cascade= CascadeType.ALL, orphanRemoval=true)
	private List<Transaction> transactions;
	
	public Account(String firstName, String lastName, String accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
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