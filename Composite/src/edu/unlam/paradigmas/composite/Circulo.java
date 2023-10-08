package edu.unlam.paradigmas.composite;

public class Circulo extends Figura {
	private double radio;

	public Circulo(int radio, String nombre, String color) {
		super(nombre, color);
		this.radio = radio;
	}

	@Override
	protected double calcularArea() {
		return Math.PI * (this.radio * this.radio);
	}

	@Override
	public String toString() {
		return "Circulo: " + this.getNombre();
	}
	
}