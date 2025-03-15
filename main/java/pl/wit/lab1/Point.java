package pl.wit.lab1;



/**
 * Klasa reprezentująca punkt na płaszczyźnie.
 * 
 * Klasa Point przechowuje współrzędne punktu na płaszczyźnie  (x, y).
 * Umożliwia operacje na tych punktach, takie jak:
 * - przesuwanie punktu wzdłuż osi X i Y (metody moveX i moveY),
 * - dodawanie i odejmowanie punktów (metody add i subtract),
 * - metoda zwracająca referencję do nowego obiektu po
wykonaniu operacji dodania punktów
 * 
 * Klasa zapewnia podstawowe metody dostępu do współrzędnych (getX, getY).
 * 
 * @author Maciej Wojdyna
 */
public class Point {
	private float x,y;
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveX(float step) {
		this.x += step;
	}
	
	public void moveY(float step) {
		this.y += step;
	}
	
	public void add(Point p) {
		if (p == null)
			return;

		moveX(p.getX());
		moveY(p.getY());

	}
	
	public void substract(Point p) {
		if (p == null)
			return;
		
		moveX(-p.getX());
		moveY(-p.getY());
	}
	
	public Point createAndAdd(Point p) {
		if (p == null)
			return null;
		Point pt = new Point(this.x, this.y);
		pt.add(p);
		return pt;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
}
