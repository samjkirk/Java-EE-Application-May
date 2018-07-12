package com.qa.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name = "ACCOUNTID")
	private Long id;
	@Column (length = 40, name = "First_Name")
	private String firstName;
	@Column (length = 40, name = "Last_Name")
	private String lastName;
	@Column(name = "Acc_Number")
	@Size (min = 6, max = 6)
	private int accountNumber;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
	private List<Transaction> transactions;
	
	public Account(String firstName, String lastName, int accountNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
	}

	private Account() { }
	
	public void setId(Long id) { 
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public String toString() {
		return "Account Number: " + accountNumber 
		+ "\n" + "First Name: " + firstName 
		+ "\n" + "Last Name: " + lastName;
	}
}