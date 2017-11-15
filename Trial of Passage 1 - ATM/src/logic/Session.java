package logic;

import java.util.ArrayList;

public class Session implements Countable {

	protected ATM atm;
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Session(ATM atm) {
		this.atm = atm;
	}

	public ATM getATM() {
		return atm;
	}

	public void setATM(ATM atm) {
		this.atm = atm;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public int count() {
		return transactions.size();
	}
	
	@Override
	public boolean equals(Object obj) {
		Session s = (Session) obj;
		return this.atm.ID == s.atm.ID;
	}
}
