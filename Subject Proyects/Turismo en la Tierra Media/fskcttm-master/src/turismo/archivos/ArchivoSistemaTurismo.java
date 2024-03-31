package turismo.archivos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import turismo.sistema.Atraccion;
import turismo.sistema.Paquete;
import turismo.sistema.SistemaTurismo;
import turismo.sistema.Usuario;

public class ArchivoSistemaTurismo {

	private String archUsuario;
	private String archAtrac;
	private String archPaquetes;

	public ArchivoSistemaTurismo(String archUsuario, String archAtrac, String archPaquetes) {
		this.archUsuario = archUsuario;
		this.archAtrac = archAtrac;
		this.archPaquetes = archPaquetes;
	}

	public SistemaTurismo leer() {
		ArchivoUsuario archivoUsuario = new ArchivoUsuario(this.archUsuario);
		ArchivoAtraccion archivoAtraccion = new ArchivoAtraccion(this.archAtrac);
		ArchivoPaquete archivoPaquete = new ArchivoPaquete(this.archPaquetes);
		List<Usuario> usuarios;
		List<Atraccion> atracciones;
		List<Paquete> paquetes;
		SistemaTurismo sistema = null;
		try {
			usuarios = archivoUsuario.leer();
			Map<String, Atraccion> atracMapa = archivoAtraccion.leer();
			paquetes = archivoPaquete.leer(atracMapa);
			atracciones = new ArrayList<Atraccion>(atracMapa.values());
			sistema = new SistemaTurismo(usuarios, atracciones, paquetes);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return sistema;
	}

}
