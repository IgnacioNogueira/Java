package turismo.sistema;

import java.util.Locale;
import java.util.Map;

import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public class PaquetePorcentual extends Paquete {

	private double porcentaje;

	public PaquetePorcentual(int tipo, double porcentaje, Map<String, Atraccion> atracciones)
			throws SugerenciaExcepcion, PaqueteExcepcion {
		super(tipo, atracciones);
		this.porcentaje = verificarPorcentaje(porcentaje);
		this.costo = calcularCosto();
	}

	private double verificarPorcentaje(double porcentaje) throws PaqueteExcepcion {
		if (Double.compare(porcentaje, 0) < 0 || Double.compare(porcentaje, 1) > 0) {
			throw new PaqueteExcepcion("El porcentaje a descontar debe estar entre 0(0%) y 1(100%)");
		}

		return porcentaje;
	}

	protected double calcularCosto() {
		return this.costoOriginal * (1 - this.porcentaje);
	}

	public double getPorcentaje() {
		return this.porcentaje;
	}

	protected void imprimir() {
		System.out.println("*PAQUETE*" + "\n\tNombre atracciones: " + this.getAtracciones() + "\n\tTipo: "
				+ Sugerencia.tiposSugerencias.get(this.tipo) + "\n\tDuracion: " + this.getDuracion()
				+ "\n\tCosto original: " + this.costoOriginal + "\n\tCosto con descuento: "
				+ String.format(Locale.US, "%.2f", this.getCosto()));
	}

}