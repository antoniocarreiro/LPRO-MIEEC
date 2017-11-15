package logic;

public class ATM {
	
	protected int ID;
	protected String cidade;
	protected String banco;
	
	public ATM(int iD, String cidade, String banco) {
		this.ID = iD;
		this.cidade = cidade;
		this.banco = banco;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
}
