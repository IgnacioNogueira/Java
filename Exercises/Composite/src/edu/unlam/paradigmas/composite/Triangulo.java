package edu.unlam.paradigmas.composite;

public class Triangulo extends Figura {

	private double lado1;
	private double lado2;
	private double base;

	public Triangulo(double lado1, double lado2, double base, String nombre, String color, Punto ubicacion)
			throws Exception {
		super(nombre, color, ubicacion);
		this.lado1 = validarAtributosFigura(lado1, "Por favor, revise que el lado1 del triangulo " + this.nombre
				+ " sea mayor o menor que cero centimetros");
		this.lado2 = validarAtributosFigura(lado2, "Por favor, revise que el lado2 del triangulo " + this.nombre
				+ " sea mayor o menor que cero centimetros");
		this.base = validarAtributosFigura(base, "Por favor, revise que la base del triangulo " + this.nombre
				+ " sea mayor o menor que cero centimetros");
	}

	@Override
	public double calcularArea() {
		double s = (lado1 + lado2 + base) / 2; // Semiperímetro
		double area = Math.sqrt(Math.abs(s * (s - lado1) * (s - lado2) * (s - base))); // Fórmula de Herón
		return area;
	}

	@Override
	public String toString() {
		return "Triangulo: " + this.getNombre();
	}
}
