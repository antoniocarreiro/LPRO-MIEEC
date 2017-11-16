package logic;

public class FiguraComposta extends Figura implements Countable {

	protected Figura[] figuras;
	double area;

	public FiguraComposta(Figura[] figuras) {
		super();
		this.figuras = figuras;
	}
	
	public double getArea() {
		for(Figura figura : figuras)
			this.area += figura.getArea();
		
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}



	public Figura[] getFiguras() {
		return figuras;
	}

	public void setFiguras(Figura[] figuras) {
		this.figuras = figuras;
	}
	
	@Override
	public int count() {
		return figuras.length;
	}
	
}
