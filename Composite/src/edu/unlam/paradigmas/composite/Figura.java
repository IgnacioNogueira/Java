package edu.unlam.paradigmas.composite;

public abstract class Figura {

	protected String nombre;
	protected String color;

	public Figura(String nombre, String color) {
		this.nombre = color;
		this.color = color;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getcolor() {
		return this.color;
	}

	protected void pintar(Pomo pomo) throws Exception {
		if (pomo.estaVacio()) {
			throw new Exception("No puede pintar la figura " + this.nombre + ", debido a que el pomo " + pomo.getColor()
					+ "no tiene la capacidad suficiente para cubrir el área");
		}

		pomo.utilizarPomo(this.calcularArea());
	}
	
	protected abstract double calcularArea() throws Exception;
}
