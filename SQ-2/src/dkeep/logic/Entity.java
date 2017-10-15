package dkeep.logic;

public class Entity {
	
	protected Position position;
	protected DragonsBane game;
	protected char title;
	
	
	public Entity() {
		position = new Position();
	}
	
	public Entity(DragonsBane game, int x, int y, char title) {
		position = new Position(x, y);
		this.title = title;
		this.game = game;
	}
	
	public boolean move(String direction) {
		switch(direction) {
		case "w":
			if(position.getX() > 0) {
				if(game.map.getMaze()[position.getX() - 1][position.getY()] != 'X') {
					position.setX(position.getX()-1);
				}
				return true;
			}
			break;

		case "a":
			if(position.getY() > 0) {
				if(game.map.getMaze()[position.getX()][position.getY() - 1] != 'X') {
					position.setY(position.getY()-1);
				}
				return true;
			}
			break;

		case "s":
			if(position.getX() < 9) {
				if(game.map.getMaze()[position.getX() + 1][position.getY()] != 'X') {
					position.setX(position.getX()+1);
				}
				return true;
			}
			break;

		case "d":
			if(position.getY() < 9) {
				if(game.map.getMaze()[position.getX()][position.getY() + 1] != 'X') {
					position.setY(position.getY()+1);
				}
				return true;
			}
			break;
		}
		return false;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public char getTitle() {
		return title;
	}

	public void setTitle(char title) {
		this.title = title;
	}
	
	public int getX() {
		return position.getX();
	}

	public int getY() {
		return position.getY();
	}
	
}
