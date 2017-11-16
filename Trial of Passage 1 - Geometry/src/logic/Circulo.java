package logic;

public class Circulo extends Figura {

	protected Ponto centro;
	protected int raio;
	
	public Circulo(Ponto centro, int raio) {
		if(raio < 0)
			throw new IllegalArgumentException();
		this.raio = raio;
		this.centro = centro;
	}

	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	
	@Override
	public double getArea() {
		return Math.PI * this.raio * this.raio;
	}
	
}
