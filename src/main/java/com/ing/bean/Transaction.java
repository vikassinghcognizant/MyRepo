package com.ing.bean;

public class Transaction {
	private String accountId;
	private String counterpartyAccount;
	private String counterpartyName;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}
	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}
	public String getCounterpartyName() {
		return counterpartyName;
	}
	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}
	@Override
	public String toString() {
		return "Transaction [accountId=" + accountId + ", counterpartyAccount=" + counterpartyAccount
				+ ", counterpartyName=" + counterpartyName + "]";
	}
	
	
}