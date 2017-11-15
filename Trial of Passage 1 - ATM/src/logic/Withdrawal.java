package logic;

public class Withdrawal extends Transaction {
	
	public Withdrawal(ATM atm, Session session, Card card, int amount) {
		this.atm = atm;
		this.session = session;
		this.card = card;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Withdrawal at ATM " + this.atm.ID + " (" + this.atm.cidade + ", " + this.atm.banco + ") of " + amount + 0;
	}
	
}
