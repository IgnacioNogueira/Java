package turismo.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import turismo.excepciones.UsuarioExcepcion;
import turismo.sistema.Usuario;

public class ArchivoUsuario {

	private String nombre;

	public ArchivoUsuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public List<Usuario> leer() throws FileNotFoundException {
		File archivo = new File(this.nombre + ".in");
		try (Scanner lector = new Scanner(archivo, "utf-8").useDelimiter("\n").useLocale(Locale.US)) {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String nombre;
			int tipo;
			double presupuesto;
			double tiempoDisp;

			while (lector.hasNextLine()) {
				nombre = lector.next();
				tipo = lector.nextInt();
				presupuesto = lector.nextDouble();
				tiempoDisp = lector.nextDouble();
				try {
					usuarios.add(new Usuario(nombre, tipo, presupuesto, tiempoDisp));
				} catch (UsuarioExcepcion e) {
					e.printStackTrace();
				}
			}

			return usuarios;
		}
	}
}
