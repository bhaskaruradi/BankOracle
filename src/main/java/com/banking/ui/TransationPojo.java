package com.banking.ui;

public class TransationPojo {
     private long  amount;
     private  long transactionid;
     private long fromaccount;
     private long toaccount;
     private long amounttransferred;
     
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(long fromaccount) {
		this.fromaccount = fromaccount;
	}
	public long getToaccount() {
		return toaccount;
	}
	public void setToaccount(long toaccount) {
		this.toaccount = toaccount;
	}
	public long getAmounttransferred() {
		return amounttransferred;
	}
	public void setAmounttransferred(long amounttransferred) {
		this.amounttransferred = amounttransferred;
	}
     
     
}
