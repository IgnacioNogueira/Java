package turismo.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.sistema.Atraccion;
import turismo.sistema.Paquete;
import turismo.sistema.PaqueteAbsoluto;
import turismo.sistema.PaqueteAxB;
import turismo.sistema.PaquetePorcentual;

public class ArchivoPaquete {

	private String nombre;

	public ArchivoPaquete(String nombre) {
		this.nombre = nombre;
	}

	public List<Paquete> leer(Map<String, Atraccion> atracciones) throws FileNotFoundException {
		File archivo = new File(this.nombre + ".in");
		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			List<Paquete> paquetes = new ArrayList<Paquete>();

			int tipoPaquete;
			String nombresAtracc;
			int tipo;

			while (lector.hasNextLine()) {
				Map<String, Atraccion> atracPaquete = new HashMap<>();
				tipoPaquete = lector.nextInt();
				tipo = lector.nextInt();
				nombresAtracc = lector.next();

				switch (tipoPaquete) {
				case Paquete.ABSOLUTO: {
					double costoAbsoluto = lector.nextDouble();
					String[] nombres = nombresAtracc.split(";");
					for (String nombre : nombres) {
						atracPaquete.put(nombre, atracciones.get(nombre));
					}
					try {
						paquetes.add(new PaqueteAbsoluto(tipo, costoAbsoluto, atracPaquete));
					} catch (SugerenciaExcepcion | PaqueteExcepcion e) {
						e.printStackTrace();
					}
					break;
				}
				case Paquete.PORCENTUAL: {
					double porcentaje = lector.nextDouble();
					String[] nombres = nombresAtracc.split(";");
					for (String nombre : nombres) {
						atracPaquete.put(nombre, atracciones.get(nombre));
					}
					try {
						paquetes.add(new PaquetePorcentual(tipo, porcentaje, atracPaquete));
					} catch (SugerenciaExcepcion | PaqueteExcepcion e) {
						e.printStackTrace();
					}
					break;
				}
				case Paquete.AXB: {
					String[] nombres = nombresAtracc.split(";");
					for (String nombre : nombres) {
						atracPaquete.put(nombre, atracciones.get(nombre));
					}

					nombres = lector.next().split(";");
					Map<String, Atraccion> atracGratuitas = new HashMap<>();

					for (String nombre : nombres) {
						atracGratuitas.put(nombre, atracciones.get(nombre));
					}
					atracPaquete.putAll(atracGratuitas);
					try {
						paquetes.add(new PaqueteAxB(tipo, atracPaquete, atracGratuitas));
					} catch (SugerenciaExcepcion | PaqueteExcepcion e) {
						e.printStackTrace();
					}
					break;
				}
				default:
					continue;
				}
			}
			return paquetes;
		}
	}

}