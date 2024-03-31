package turismo.sistema;

import turismo.archivos.ArchivoSistemaTurismo;

public class App {

	public static void main(String[] args) {
		ArchivoSistemaTurismo archivo = new ArchivoSistemaTurismo("usuarios", "atracciones", "paquetes");
		SistemaTurismo sistema = archivo.leer();

		sistema.sugerirUsuario();

		sistema.generarArchivoSalida();
	}
}
