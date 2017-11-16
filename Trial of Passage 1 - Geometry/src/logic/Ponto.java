package logic;

public class Ponto implements Comparable<Ponto> {

	protected int x;
	protected int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		Ponto ponto = (Ponto) obj;
		return this.x == ponto.x && this.y == ponto.y;
	}
	
	@Override
	public int compareTo(Ponto that) {
		if (this.x == that.x){
			if (this.y > that.y){
				return 1;
			}else{
				return 0;
			}
		}
		else if (this.x > that.x){
			return 1;
		}
		else if (this.x < that.x){
			return 0;
		}
		return -1;
	}
	
}
