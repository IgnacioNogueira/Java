package turismo.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.sistema.Atraccion;

public class ArchivoAtraccion {

	private String nombre;

	public ArchivoAtraccion(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Atraccion> leer() throws FileNotFoundException {

		File archivo = new File(this.nombre + ".in");
		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			Map<String, Atraccion> atracciones = new HashMap<>();

			String nombre;
			int tipo;
			double costo;
			double duracion;
			int cupo;

			while (lector.hasNextLine()) {
				nombre = lector.next();
				costo = lector.nextDouble();
				duracion = lector.nextDouble();
				cupo = lector.nextInt();
				tipo = lector.nextInt();
				try {
					atracciones.put(nombre, new Atraccion(nombre, tipo, costo, duracion, cupo));
				} catch (AtraccionExcepcion | SugerenciaExcepcion e) {
					e.printStackTrace();
				}
			}

			return atracciones;
		}
	}

}