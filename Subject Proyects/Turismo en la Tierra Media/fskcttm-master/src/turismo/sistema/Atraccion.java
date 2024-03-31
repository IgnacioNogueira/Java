package turismo.sistema;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public class Atraccion extends Sugerencia {
	private int cupoTotal;
	private int cupoDisponible;

	public Atraccion(String nombre, int tipo, double costo, double duracion, int cupo)
			throws AtraccionExcepcion, SugerenciaExcepcion {
		super(nombre, tipo, costo, duracion);

		cupoTotal = verificarCupo(cupo, "No se puede crear atracciones sin cupo");
		cupoDisponible = cupoTotal;
	}

	private int verificarCupo(int cupo, String mensajeExcepcion) throws AtraccionExcepcion {
		if (cupo < 0) {
			throw new AtraccionExcepcion(mensajeExcepcion);
		}

		return cupo;
	}

	public void reducirCupo() throws AtraccionExcepcion {
		verificarCupo(cupoDisponible - 1, "No hay cupo disponible.");
		cupoDisponible--;
	}

	public int getCupoDisponible() {
		return cupoDisponible;
	}

	public int getCupoTotal() {
		return cupoTotal;
	}

	protected void imprimir() {
		System.out.println("*ATRACCION*" + "\n\tNombre: " + this.nombre + "\n\t Tipo: "
				+ Sugerencia.tiposSugerencias.get(this.tipo) + "\n\t Costo: " + this.costo + "\n\t Duración: "
				+ this.duracion + " horas");
	}

	public boolean hayCupoDisponible() {
		return cupoDisponible > 0;
	}

}