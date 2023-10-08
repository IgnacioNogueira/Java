package edu.unlam.paradigmas.composite;

public class Pomo {

	public final static double CAPACIDAD_TOTAL = 100;
	private double capacidadActual = CAPACIDAD_TOTAL;
	private String color;

	public Pomo(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void utilizarPomo(double cantPintura) throws Exception {
		if (cantPintura > capacidadActual) {
			throw new Exception("No se puede utilizar la cantidad de pintura solicitada");
		}
		this.capacidadActual -= cantPintura;
	}

	public boolean estaVacio() {
		return this.capacidadActual == 0;
	}
}
