package turismo.sistema;

import java.util.Map;
import java.util.Set;

import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;

public class PaqueteAxB extends Paquete {

	private Map<String, Atraccion> atraccionesGratuitas;

	public PaqueteAxB(int tipo, Map<String, Atraccion> atracciones, Map<String, Atraccion> atracGratuitas)
			throws SugerenciaExcepcion, PaqueteExcepcion {
		super(tipo, atracciones);
		this.atraccionesGratuitas = verificarAtraccionesGratuitas(atracGratuitas);
		this.costo = calcularCosto();
	}

	private Map<String, Atraccion> verificarAtraccionesGratuitas(Map<String, Atraccion> atraccionesGratuitas)
			throws PaqueteExcepcion {
		if (atraccionesGratuitas.isEmpty()) {
			throw new PaqueteExcepcion("Debe haber al menos una atraccion gratuita en Paquetes AxB");
		}

		for (String atraccion : atraccionesGratuitas.keySet()) {
			if (!atracciones.containsKey(atraccion)) {
				throw new PaqueteExcepcion(
						"Las atracciones gratuitas deben estar dentro del conjunto de atracciones inicial");
			}
		}

		return atraccionesGratuitas;
	}

	protected double calcularCosto() {
		double costoGratuito = 0;
		for (Atraccion atraccion : this.atraccionesGratuitas.values()) {
			costoGratuito += atraccion.getCosto();
		}
		return this.costoOriginal - costoGratuito;
	}

	public void mostrarAtraccionesGratuitas() {
		System.out.println("Atracciones gratuitas:");
		for (Atraccion atraccion : atraccionesGratuitas.values()) {
			System.out.println("-Nombre: " + atraccion.getNombre());
			System.out.println("-Duración: " + atraccion.getDuracion());
			System.out.println("-Costo: " + atraccion.getCosto());
		}
	}

	public Set<String> getAtraccionesGratuitas() {
		return atraccionesGratuitas.keySet();
	}

	protected void imprimir() {
		System.out.println("*PAQUETE*" + "\n\tNombre atracciones totales: " + this.getAtracciones()
				+ "\n\tNombre atracciones gratuitas: " + this.getAtraccionesGratuitas() + "\n\tTipo: "
				+ Sugerencia.tiposSugerencias.get(this.tipo) + "\n\tDuracion: " + this.getDuracion()
				+ "\n\tCosto original: " + this.costoOriginal + "\n\tCosto final: " + this.getCosto());
	}

}