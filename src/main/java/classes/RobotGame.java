package classes;

public class RobotGame {

	private final int LENGTH = 10;
	private int countShips = 0;
	private boolean[][] gameFieldXY = new boolean[LENGTH][LENGTH];

	public RobotGame() {
	}

	private boolean checkAllPointArea(Integer x, Integer y) {
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if ((i < LENGTH) && (i >= 0) && (j < LENGTH) && (j >= 0) && gameFieldXY[i][j])
					return false;
			}
		}
		return true;
	}

	private boolean checkRightPointArea(Integer x, Integer y) {
		++x;
		for (int j = y-1; j <= y+1; j++) {
			if ((x < LENGTH) && (x >= 0) && (j < LENGTH) && (j >= 0) && gameFieldXY[x][j])
				return false;
		}
		return true;
	}

	private boolean checkBottomPointArea(Integer x, Integer y) {
		++y;
		for (int i = x-1; i <= x+1; i++) {
			if ((i < LENGTH) && (i >= 0) && (y < LENGTH) && (y >= 0) && gameFieldXY[i][y]) {
				return false;
			}
		}
		return true;
	}

	private boolean checkShipArea(Ship ship) {
		int x = ship.getX();
		int y = ship.getY();
		int size = ship.getSize();

		if (!checkAllPointArea(x, y)) return  false;

		if (ship.getDirection() == 0) {
			for (int i = x + 1; i < x+size; i++) {
				if (!checkRightPointArea(i, y))
					return false;
			}
		} else {
			for (int j = y + 1; j < y+size; j++) {
				if (!checkBottomPointArea(x, j))
					return false;
			}
		}
		return true;
	}

	private void drawShip(Ship ship) {
		int x = ship.getX();
		int y = ship.getY();
		int size = ship.getSize();

		if (ship.getDirection() == 0) {
			for (int i = x; i < x + size; i++) {
				gameFieldXY[i][y] = true;
			}
		} else {
			for (int j = y; j < y + size; j++) {
				gameFieldXY[x][j] = true;
			}
		}
		countShips ++;
	}

	private void markFirstShip(int size) {
		Ship ship = new Ship(size, LENGTH);
		drawShip(ship);
	}

	private void markShip(int size) {
		Ship ship;
		do  {
			ship = new Ship(size, LENGTH);
		} while (!checkShipArea(ship));
		drawShip(ship);
	}

	public int getCountShips() {
		return countShips;
	}

	public void drawGame() {
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if (gameFieldXY[j][i]) {
					System.out.print("0 ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
	}

	public void generate() {
		markFirstShip(4);
		markShip(3);
		markShip(3);
		markShip(2);
		markShip(2);
		markShip(2);
		markShip(1);
		markShip(1);
		markShip(1);
		markShip(1);
		drawGame();
	}

}
