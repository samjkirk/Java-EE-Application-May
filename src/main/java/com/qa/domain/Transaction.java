package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.qa.constants.Constants;

@Entity
public class Transaction {
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name = Constants.TRANSACTION_ID)
	private Long id;
	@Column(length = 50)
	private String name;
	@ManyToOne
	@JoinColumn(name = Constants.ACCOUNT_ID, referencedColumnName = Constants.ACCOUNT_ID)
	private Account account;
	
	public Transaction(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
