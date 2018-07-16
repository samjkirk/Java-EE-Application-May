package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import constants.*;

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
	
	public Account(String firstName, String lastName, String accountNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
	}
	
	private Account() {}

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
	
	@Override
	public String toString() {
		return "Account Number: " + accountNumber 
		+ "\n" + "First Name: " + firstName 
		+ "\n" + "Last Name: " + lastName;
	}
}