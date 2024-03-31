package edu.unlam.paradigmas.composite;

import java.util.Arrays;

public class Pomo {

	public final static double CAPACIDAD_TOTAL = 100;
	private double capacidadActual = CAPACIDAD_TOTAL;
	public final static String[] coloresPomos = { "Rojo", "Verde", "Azul", "Celeste", "Negro", "Violeta", "Amarillo",
			"Blanco", "Naranja", "Rosa", "Gris", "Marrón" };
	private String color;

	public Pomo(String color) throws Exception {
		this.color = validarColoresPomo(color);
	}

	public double getCapacidadActual() {
		return this.capacidadActual;
	}

	public void utilizarPomo(double cantPintura) throws Exception {

		if (cantPintura <= 0) {
			throw new RuntimeException();
		}

		if (cantPintura > capacidadActual || this.estaVacio()) {
			throw new Exception("No se puede utilizar la cantidad de pintura solicitada");
		}
		this.capacidadActual -= cantPintura;
	}

	public boolean estaVacio() {
		return this.capacidadActual == 0;
	}

	public static String validarColoresPomo(String color) throws Exception { // pq es static?
		if (!Arrays.asList(coloresPomos).contains(color)) {
			throw new Exception("Color enviado no existente, por favor revise el Pomo creado");
		}
		return color;
	}
}
