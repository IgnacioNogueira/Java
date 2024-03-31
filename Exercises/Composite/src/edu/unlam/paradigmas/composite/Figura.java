package edu.unlam.paradigmas.composite;

public abstract class Figura {

	protected String nombre;
	protected String color;
	protected Punto ubicacion;

	public Figura(String nombre, String color, Punto ubicacion) throws Exception {
		this.nombre = nombre;
		this.color = color; // no lo valido debido a que puedo mixear colores si quiero con los pomos
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getcolor() {
		return this.color;
	}

	public void pintar(String color) throws Exception { // hay que validar los colores disponibles antes de pintar
		this.color = Pomo.validarColoresPomo(color); // está bien esto?
	}

	public int cantidadPomosParaPintarFigura() throws Exception {
		return (int) ((this.calcularArea() + Pomo.CAPACIDAD_TOTAL - 1) / Pomo.CAPACIDAD_TOTAL);
	}

	/*
	 * public boolean figurasSeSolapan(Figura f2) { //en realidad tendríamos que
	 * calcular los límites return this.ubicacion.distanciaAotroPunto(f2.ubicacion)
	 * == 0 ? true:false; }
	 */

	protected double validarAtributosFigura(double atributo, String mensaje) throws Exception {
		if (atributo <= 0) {
			throw new Exception(mensaje);
		}

		return atributo;
	}

	public abstract double calcularArea() throws Exception;
}
