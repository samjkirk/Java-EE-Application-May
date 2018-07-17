package com.qa.persistence.domain;

import javax.persistence.*;

import com.qa.constants.Constants;

@Entity
public class Transaction {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = Constants.TRANSACTION_ID)
	private long id;
	@Column (length = 40, name = Constants.TRANSACTION_NAME)
	private String transactionName;
	
	public Transaction(String transactionName) {
		this.transactionName = transactionName;
	}
	
	public Transaction() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

}
