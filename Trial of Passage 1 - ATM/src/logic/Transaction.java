package logic;

public class Transaction {

	protected ATM atm;
	protected Session session;
	protected Card card;
	protected double amount;
	
	public Transaction() {}
		
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	
}
