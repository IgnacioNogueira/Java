package edu.unlam.paradigmas.composite;

public class Triangulo extends Figura {

	private double lado1;
	private double lado2;
	private double base;

	public Triangulo(double lado1, double lado2, double base, String nombre, String color) {
		super(nombre, color);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.base = base;
	}

	@Override
	protected double calcularArea() {
		return base * getAltura() / 2;
	}

	private double getAltura() {
		return Math.sqrt((this.lado1 * this.lado1) - (this.lado2 * this.lado2));
	}

	@Override
	public String toString() {
		return "Triangulo: " + this.getNombre();
	}
}
