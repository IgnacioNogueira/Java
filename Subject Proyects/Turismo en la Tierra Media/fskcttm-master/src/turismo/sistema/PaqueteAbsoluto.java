package turismo.sistema;

import java.util.Map;

import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public class PaqueteAbsoluto extends Paquete {

	private double costoFinal;

	public PaqueteAbsoluto(int tipo, double costoFinal, Map<String, Atraccion> atracciones)
			throws PaqueteExcepcion, SugerenciaExcepcion {
		super(tipo, atracciones);
		this.costoFinal = verificarCostoFinal(costoFinal);
		this.costo = calcularCosto();
	}

	private double verificarCostoFinal(double costoFinal) throws PaqueteExcepcion {
		if (costoFinal < 0) {
			throw new PaqueteExcepcion("No puede generar sugerencias con costo menor que 0.");
		}

		if (costoFinal >= this.getCosto()) {
			throw new PaqueteExcepcion("El costo de la promocion debe ser menor al costo original del paquete.");
		}

		return costoFinal;
	}

	protected double calcularCosto() {
		return this.costoFinal;
	}

	protected void imprimir() {
		System.out.println("*PAQUETE*" + "\n\tNombre atracciones: " + this.getAtracciones() + "\n\tTipo: "
				+ Sugerencia.tiposSugerencias.get(this.tipo) + "\n\tDuracion: " + this.getDuracion()
				+ "\n\tCosto original: " + this.costoOriginal + "\n\tCosto final: " + this.getCosto());
	}

}