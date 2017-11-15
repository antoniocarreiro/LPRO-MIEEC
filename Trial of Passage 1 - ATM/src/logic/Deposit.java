package logic;

public class Deposit extends Transaction {
	
	public Deposit(ATM atm, Session session, Card card, double amount) {
		this.atm = atm;
		this.session = session;
		this.card = card;
		this.amount = amount;
	}
	
}
