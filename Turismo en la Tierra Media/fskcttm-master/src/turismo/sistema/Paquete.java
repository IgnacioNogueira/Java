package turismo.sistema;

import java.util.Map;
import java.util.Set;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public abstract class Paquete extends Sugerencia {

	protected final Map<String, Atraccion> atracciones;
	protected double costoOriginal;
	public static final int ABSOLUTO = 0;
	public static final int PORCENTUAL = 1;
	public static final int AXB = 2;

	public Paquete(int tipo, Map<String, Atraccion> atracciones) throws SugerenciaExcepcion, PaqueteExcepcion {
		super(tipo);
		this.atracciones = verificarTipoAtracciones(atracciones);
		inicializarValores();
		this.costo = costoOriginal;
	}

	private Map<String, Atraccion> verificarTipoAtracciones(Map<String, Atraccion> atracciones)
			throws PaqueteExcepcion {
		for (Atraccion atraccion : atracciones.values()) {
			if (atraccion.getTipo() != this.tipo) {
				throw new PaqueteExcepcion(
						"Los tipos de las atracciones del paquete deben coincidir con el tipo del paquete");
			}
		}

		return atracciones;
	}

	private void inicializarValores() {
		String nombre = "";
		double costoOriginal = 0;
		double duracion = 0;
		int menorCupo = Integer.MAX_VALUE;

		for (Atraccion atraccion : this.atracciones.values()) {
			nombre += atraccion.getNombre() + ", ";
			duracion += atraccion.getDuracion();
			costoOriginal += atraccion.getCosto();
			int cupoTotal = atraccion.getCupoTotal();
			if (cupoTotal < menorCupo) {
				menorCupo = cupoTotal;
			}
		}

		this.nombre = nombre.substring(0, nombre.length() - 2);
		this.duracion = duracion;
		this.costoOriginal = costoOriginal;
	}

	public Set<String> getAtracciones() {
		return this.atracciones.keySet();
	}

	public void reducirCupo() throws AtraccionExcepcion {
		for (Atraccion atraccion : this.atracciones.values()) {
			atraccion.reducirCupo();
		}
	}

	public int getCupoDisponible() {
		int cupoDisponible = Integer.MAX_VALUE;

		for (Atraccion atraccion : this.atracciones.values()) {
			if (atraccion.getCupoDisponible() < cupoDisponible) {
				cupoDisponible = atraccion.getCupoDisponible();
			}
		}

		return cupoDisponible;
	}

	public int getCupoTotal() {
		int cupoTotal = Integer.MAX_VALUE;

		for (Atraccion atraccion : this.atracciones.values()) {
			if (atraccion.getCupoTotal() < cupoTotal) {
				cupoTotal = atraccion.getCupoTotal();
			}
		}

		return cupoTotal;
	}

	protected abstract double calcularCosto();

	public double getMontoOrigPaquete() {
		return this.costoOriginal;
	}

	public boolean hayCupoDisponible() {
		return getCupoDisponible() > 0;
	}

	protected abstract void imprimir();

}