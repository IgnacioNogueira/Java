package edu.unlam.paradigmas.composite;

public class Cuadrado extends Figura {
	private double lado;

	public Cuadrado(double lado, String nombre, String color, Punto ubicacion) throws Exception {
		super(nombre, color, ubicacion);
		this.lado = validarAtributosFigura(lado, "Por favor, revise que el lado del cuadrado " + this.nombre
				+ " sea mayor o menor que cero centimetros");
	}

	@Override
	public double calcularArea() {
		return lado * lado;
	}

	@Override
	public String toString() {
		return "Cuadrado: " + this.getNombre();
	}
}
