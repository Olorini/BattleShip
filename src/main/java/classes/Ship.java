package classes;

public class Ship {

	private int x;
	private int y;
	private int direction;
	private int size;

	public Ship(int size, int length) {
		direction = (((int)(Math.random()*100%2)) == 0)?0:1;
		if (direction == 0) { //Horizontal direction
			x = (int) (Math.random()*(length - size));
			y = (int) (Math.random()*(length));
		} else {//Vertical direction
			x = (int) (Math.random()*(length));
			y = (int) (Math.random()*(length - size));
		}
		this.size = size;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
