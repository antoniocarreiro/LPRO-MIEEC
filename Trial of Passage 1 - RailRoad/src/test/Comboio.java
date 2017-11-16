package test;

import java.util.ArrayList;

public class Comboio {

	protected String nome;
	protected int numLugares;
	protected int numCarruagens;
	protected int numPassageiros;

	protected ArrayList<Carruagem> carruagens = new ArrayList<Carruagem>();
	
	public Comboio(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumLugares() {
		this.numLugares = 0;
		for (Carruagem carruagem : carruagens)
			this.numLugares += carruagem.numLugares;
		
		return this.numLugares;
	}

	public void setNumLugares(int numLugares) {
		this.numLugares = numLugares;
	}

	public int getNumCarruagens() {
		return carruagens.size();
	}

	public void setNumCarruagens(int numCarruagens) {
		this.numCarruagens = numCarruagens;
	}

	public void addCarruagem(Carruagem a1) {
		carruagens.add(a1);
		
	}

	public Carruagem getCarruagemByOrder(int i) {
		return carruagens.get(i);
	}

	public void removeAllCarruagens(int i) {
		ArrayList<Carruagem> temp = new ArrayList<Carruagem>();
		
		for(Carruagem elem: carruagens) {
			if(elem.getNumLugares() != i)
				temp.add(elem);
		}		
		this.carruagens = temp;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	public int getLugaresLivres() {
		return getNumLugares() - getNumPassageiros();
	}

	public void addPassageiros(int passageiros) throws PassengerCapacityExceeded {
		if(getLugaresLivres() < passageiros)
			throw new PassengerCapacityExceeded();
		
		this.numPassageiros += passageiros;
		
	}

	public void removePassageiros(int passageiros) throws PassengerCapacityExceeded {
		if(getNumPassageiros() < passageiros)
			throw new PassengerCapacityExceeded();
		this.numPassageiros -= passageiros;
	}

	public void removePassageiros() {
		this.numPassageiros = 0;
	}

	@Override
	public String toString() {
		String message = getClass().getSimpleName() + " " + this.nome + ", " + this.getNumCarruagens();
		
		if(this.getNumCarruagens() == 1)
			message += " carruagem, ";
		else message += " carruagens, ";
		
		message += this.getNumLugares();
		
		if(this.getNumLugares() == 1)
			message += " lugar, ";
		else message += " lugares, ";
		
		message += this.getNumPassageiros();
		
		if(this.getNumPassageiros() == 1)
			return message + " passageiro";
		else return message + " passageiros";
	}
	
	
}
