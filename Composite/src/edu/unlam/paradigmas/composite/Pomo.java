package edu.unlam.paradigmas.composite;

import java.util.Arrays;

public class Pomo {

	public final static double CAPACIDAD_TOTAL = 100;
	private double capacidadActual = CAPACIDAD_TOTAL;
	public final static String[] coloresPomos = {"Rojo", "Verde", "Azul", "Celeste", "Negro", "Violeta", "Amarillo", "Blanco", "Naranja", "Rosa", "Gris", "Marrón"};
	private String color;

	public Pomo(String color) throws Exception {
		this.color = validarColoresPomo(color);
	}

	public String getColor() {
		return this.color; //falta validación de color
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
	
	public static String validarColoresPomo(String color) throws Exception { //pq es static?
	    if (!Arrays.asList(coloresPomos).contains(color)) {
	        throw new Exception("Color enviado no existente, por favor revise el Pomo creado");
	    }
	    return color;
	}
}
