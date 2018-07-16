package domain;

import javax.persistence.*;
import constants.Constants;

@Entity
public class Transaction {
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name = Constants.TRANSACTION_ID)
	private long id;
	
	@Column (length = 40, name = Constants.TRANSACTION_NAME)
	private String transactionName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = Constants.ACCOUNT_ID)
	private Account account; 
	
	public Transaction(long id, String transactionName) {
		this.id = id; 
		this.transactionName = transactionName;
	}
	
	private Transaction() {
		
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
