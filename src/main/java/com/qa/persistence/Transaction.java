package com.qa.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name = "TRANSACTIONID")
	private Long id;
	@Column(length = 50)
	private String name;
	@ManyToOne
	@JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCOUNTID")
	private Account account;
	
	public Transaction(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Transaction() {}
	
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
