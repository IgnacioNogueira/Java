package jueguito0509;

public abstract class Persona extends Unidad {

	protected int monedasOro;

	public Persona(int hp, String nombre, String equipo, Punto ubicacion, int monedasOro) throws Exception {
		super(hp, nombre, equipo, ubicacion);
		this.monedasOro = validarMonedasOro(monedasOro, "Un personaje no puede empezar endeudado :P");
	}

	public double getMonedasOro() {
		return this.monedasOro;
	}

	public int validarMonedasOro(int monedas, String mensaje) throws Exception {
		if (monedas < 0) {
			throw new Exception(mensaje);
		}
		return monedas;
	}
}
