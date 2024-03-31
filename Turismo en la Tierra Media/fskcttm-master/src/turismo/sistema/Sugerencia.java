package turismo.sistema;

import java.util.HashMap;
import java.util.Map;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public abstract class Sugerencia implements Comparable<Sugerencia> {
	protected String nombre;
	protected int tipo;
	protected double costo;
	protected double duracion;
	public final static Map<Integer, String> tiposSugerencias = new HashMap<Integer, String>() {
		private static final long serialVersionUID = -2860186704571723436L;

		{
			put(0, "Paisaje");
			put(1, "Aventura");
			put(2, "Degustación");
		}
	};

	public Sugerencia(String nombre, int tipo, double costo, double duracion) throws SugerenciaExcepcion {
		this.nombre = verificarNombre(nombre);
		this.tipo = verificarTipo(tipo);
		this.costo = verificarCosto(costo);
		this.duracion = verificarDuracion(duracion);
	}

	protected Sugerencia(int tipo) throws SugerenciaExcepcion {
		this.tipo = verificarTipo(tipo);
	}

	private double verificarCosto(double costo) throws SugerenciaExcepcion {
		if (costo < 0) {
			throw new SugerenciaExcepcion("No puede generar sugerencias con costo menor que 0.");
		}

		return costo;
	}

	private double verificarDuracion(double duracion) throws SugerenciaExcepcion {
		if (duracion <= 0) {
			throw new SugerenciaExcepcion("No puede generar sugerencias con duracion menor o igual a 0");
		}

		return duracion;
	}

	private int verificarTipo(int tipo) throws SugerenciaExcepcion {
		if (!tiposSugerencias.containsKey(tipo)) {
			throw new SugerenciaExcepcion("Tipo de sugerencia invalida.");
		}

		return tipo;
	}

	private String verificarNombre(String nombre) throws SugerenciaExcepcion {
		if (nombre.equals("")) {
			throw new SugerenciaExcepcion("No se ingreso nombre.");
		}

		return nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getTipo() {
		return this.tipo;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public abstract void reducirCupo() throws AtraccionExcepcion;

	public abstract int getCupoDisponible();

	public abstract int getCupoTotal();

	public abstract boolean hayCupoDisponible();

	public int compareTo(Sugerencia otra) {
		if (this.costo != otra.costo) {
			return Double.compare(this.costo, otra.costo);
		}

		return Double.compare(this.duracion, otra.duracion);
	}

	protected abstract void imprimir();
}