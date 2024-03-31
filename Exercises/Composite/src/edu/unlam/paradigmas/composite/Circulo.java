package edu.unlam.paradigmas.composite;

public class Circulo extends Figura {
	private double radio;

	public Circulo(double radio, String nombre, String color, Punto ubicacion) throws Exception {
		super(nombre, color, ubicacion);
		this.radio = validarAtributosFigura(radio,
				"Por favor, revise que el radio del Circulo " + this.nombre + " sea mayor o menor que cero centimetros");
	}
	
	@Override
	public double calcularArea() {
		return Math.PI * (this.radio * this.radio);
	}

	@Override
	public String toString() {
		return "Circulo: " + this.getNombre();
	}
}