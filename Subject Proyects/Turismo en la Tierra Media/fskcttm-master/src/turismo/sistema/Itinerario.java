package turismo.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Itinerario {
	private double costo;
	private double duracion;
	private List<Sugerencia> sugerenciasAceptadas;

	public Itinerario() {
		this.costo = 0;
		this.duracion = 0;
		this.sugerenciasAceptadas = new ArrayList<Sugerencia>();
	}

	public double getCostoItinerario() {
		return this.costo;
	}

	public double getDuracionItinerario() {
		return this.duracion;
	}

	public List<Sugerencia> getItinerario() {
		return this.sugerenciasAceptadas;
	}

	public void agregarSugerencia(Sugerencia sugerencia) {
		this.sugerenciasAceptadas.add(sugerencia);
		this.costo += sugerencia.getCosto();
		this.duracion += sugerencia.getDuracion();
	}

	public void imprimir() {
		System.out.println("Sugerencias aceptadas:");
		System.out.println("");
		for (Sugerencia sugerencia : sugerenciasAceptadas) {
			System.out.println("\t" + sugerencia.getNombre());
		}
		System.out.println("");
		System.out.println("Duracion total: " + String.format(Locale.US, "%.2f", this.duracion));
		System.out.println("Costo total: " + String.format(Locale.US, "%.2f", this.costo) + " monedas");
	}

	public String imprimirEnArchivo() {
		String texto = "Sugerencias aceptadas: " + "\n[ ";
		for (Sugerencia sugerencia : sugerenciasAceptadas) {
			texto += sugerencia.getNombre() + ", ";
		}
		texto = texto.substring(0, texto.length() - 2);
		texto += " ]" + "\nDuracion total: " + String.format(Locale.US, "%.2f", this.duracion) + "\nCosto total: "
				+ String.format(Locale.US, "%.2f", this.costo);

		return texto;
	}
}
