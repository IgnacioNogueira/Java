package edu.unlam.paradigmas.composite;

public class Cuadrado extends Figura {
	private double lado;

	public Cuadrado(int lado, String nombre, String color) {
		super(nombre, color);
		this.lado = lado;
	}

	@Override
	protected double calcularArea() {
		return lado * lado;
	}

	@Override
	public String toString() {
		return "Cuadrado: " + this.getNombre();
	}
}
