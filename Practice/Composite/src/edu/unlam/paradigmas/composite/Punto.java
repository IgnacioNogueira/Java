package edu.unlam.paradigmas.composite;

public class Punto {

	private double cx;
	private double cy;

	public Punto(double cx, double cy) {
		this.cx = cx;
		this.cy = cy;
	}

	public double getCx() {
		return this.cx;
	}

	public double getCy() {
		return this.cx;
	}

	public double distanciaAotroPunto(Punto otro) {
		return Math
				.sqrt(Math.abs((this.cx - otro.cx) * (this.cx - otro.cx) + (this.cy - otro.cy) * (this.cy - otro.cy)));
	}

	public boolean seTocaConOtroPunto(Punto otro) {
		return this.cx == this.cy || this.cy == this.cx;
	}
}
