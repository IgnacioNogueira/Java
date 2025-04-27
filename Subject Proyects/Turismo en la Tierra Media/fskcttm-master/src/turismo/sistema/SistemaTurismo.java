package turismo.sistema;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.UsuarioExcepcion;

public class SistemaTurismo {
	private List<Usuario> usuarios;
	private List<Atraccion> atracciones;
	private List<Paquete> paquetes;

	public SistemaTurismo(List<Usuario> usuarios, List<Atraccion> atracciones, List<Paquete> paquetes) {
		this.usuarios = usuarios;
		this.atracciones = atracciones;
		this.paquetes = paquetes;
	}

	public void sugerirUsuario() {

		try (Scanner teclado = new Scanner(System.in)) {
			paquetes.sort(Comparator.reverseOrder());
			atracciones.sort(Comparator.reverseOrder());

			int atraccionesSinCupo = 0;

			for (Usuario usuario : usuarios) {

				atraccionesSinCupo = 0;

				this.mensajeBienvenida(usuario);

				Set<String> atraccionesTomadas = new HashSet<>();
				String respuestaUsuario;
				List<Paquete> paqueteNoPreferida = new ArrayList<>();
				List<Atraccion> atraccionNoPreferida = new ArrayList<>();

				boolean esPreferencia;
				boolean puedeAdquirir;
				boolean hayCupo;

				for (Paquete paquete : paquetes) {
					esPreferencia = paquete.getTipo() == usuario.getTipo();
					puedeAdquirir = usuario.puedeAdquirirSugerencia(paquete.getCosto(), paquete.getDuracion());
					hayCupo = paquete.hayCupoDisponible();
					if (esPreferencia && hayCupo && puedeAdquirir) {
						paquete.imprimir();
						respuestaUsuario = obtenerRespuestaUsuario(teclado);
						if (respuestaUsuario.equals("S")) {
							try {
								paquete.reducirCupo();
								usuario.agregarSugerencia(paquete);
							} catch (AtraccionExcepcion | UsuarioExcepcion e) {
								System.out.println(e.getMessage());
							}
							atraccionesTomadas.addAll(paquete.getAtracciones());
							System.out.println("¡Aceptada!");
						}
					} else if (!esPreferencia) {
						paqueteNoPreferida.add(paquete);
					}
				}

				for (Atraccion atraccion : atracciones) {
					esPreferencia = atraccion.getTipo() == usuario.getTipo();
					puedeAdquirir = usuario.puedeAdquirirSugerencia(atraccion.getCosto(), atraccion.getDuracion());
					hayCupo = atraccion.hayCupoDisponible();
					if (hayCupo) {
						if (esPreferencia && puedeAdquirir && !atraccionesTomadas.contains(atraccion.getNombre())) {
							atraccion.imprimir();
							respuestaUsuario = obtenerRespuestaUsuario(teclado);
							if (respuestaUsuario.equals("S")) {
								try {
									atraccion.reducirCupo();
									usuario.agregarSugerencia(atraccion);
								} catch (AtraccionExcepcion | UsuarioExcepcion e) {
									System.out.println(e.getMessage());
								}

								atraccionesTomadas.add(atraccion.getNombre());
								System.out.println("¡Aceptada!");
							}
						} else if (!esPreferencia) {
							atraccionNoPreferida.add(atraccion);
						}
					} else {
						++atraccionesSinCupo;
					}

				}

				for (Paquete paquete : paqueteNoPreferida) {
					puedeAdquirir = usuario.puedeAdquirirSugerencia(paquete.getCosto(), paquete.getDuracion());
					hayCupo = paquete.hayCupoDisponible();
					if (hayCupo && puedeAdquirir) {
						paquete.imprimir();
						respuestaUsuario = obtenerRespuestaUsuario(teclado);
						if (respuestaUsuario.equals("S")) {
							try {
								paquete.reducirCupo();
								usuario.agregarSugerencia(paquete);
							} catch (AtraccionExcepcion | UsuarioExcepcion e) {
								System.out.println(e.getMessage());
							}
							atraccionesTomadas.addAll(paquete.getAtracciones());
							System.out.println("¡Aceptada!");
						}
					}
				}

				for (Atraccion atraccion : atraccionNoPreferida) {
					puedeAdquirir = usuario.puedeAdquirirSugerencia(atraccion.getCosto(), atraccion.getDuracion());
					hayCupo = atraccion.hayCupoDisponible();

					if (hayCupo) {

						if (hayCupo && puedeAdquirir && !atraccionesTomadas.contains(atraccion.getNombre())) {
							atraccion.imprimir();
							respuestaUsuario = obtenerRespuestaUsuario(teclado);
							if (respuestaUsuario.equals("S")) {
								try {
									atraccion.reducirCupo();
									usuario.agregarSugerencia(atraccion);
								} catch (AtraccionExcepcion | UsuarioExcepcion e) {
									System.out.println(e.getMessage());
								}
								atraccionesTomadas.add(atraccion.getNombre());
								System.out.println("¡Aceptada!");
							}
						}

					} else {
						++atraccionesSinCupo;
					}

				}

				if (atracciones.size() == atraccionesSinCupo) {

					System.out.println("\n*******************************************\n");
					System.out.println("\n¡ No tenemos actividades que ofrecer, vuelva pronto !\n");
					System.out.println("\n*******************************************\n");
					this.mensajeFinal();
					return;
				}

				System.out.println("\n¡ Han finalizado sus sugerencias del día !");

				if (!usuario.itinerarioVacio()) {
					System.out.println("¡" + usuario.getNombre() + ", su itinerario es el siguiente: ");
					usuario.mostrarItinerario();
					System.out.println("\nFin de su itinerario. ¡ Hasta la proxima !\n");
				}

			}

		}

		this.mensajeFinal();
	}

	private String obtenerRespuestaUsuario(Scanner teclado) {
		String respuestaUsuario;
		do {
			System.out.println("Acepta sugerencia? Ingrese S o N:");
			respuestaUsuario = teclado.nextLine().toUpperCase();
		} while (!respuestaUsuario.equals("S") && !respuestaUsuario.equals("N"));
		return respuestaUsuario;
	}

	public void generarArchivoSalida() {
		PrintWriter printerWriter = null;

		try (FileWriter archivo = new FileWriter(LocalDate.now() + ".out")) {
			printerWriter = new PrintWriter(archivo);
			int contadorVentas = 0;

			printerWriter.println("++++++++++++++++++++++");
			printerWriter.println("+++ VENTAS DEL DIA +++");
			printerWriter.println("++++++++++++++++++++++");

			for (Usuario usuario : usuarios) {

				if (!usuario.itinerarioVacio()) {
					printerWriter.println(usuario.imprimirItinerarioEnArchivo());
					printerWriter.println("----------------------------------------");
					++contadorVentas;
				}
			}

			if (contadorVentas == 0) {
				printerWriter.println("NO SE REGISTRARON VENTAS EN EL DÍA");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mensajeBienvenida(Usuario usuario) {
		System.out.println("*******************************************************");
		System.out.println("Bienvendido/a " + usuario.getNombre());
		System.out.println("Presupuesto: " + String.format(Locale.US, "%.2f", usuario.getPresupuestoDisp()));
		System.out
				.println("Tiempo disponible: " + String.format(Locale.US, "%.2f", usuario.getTiempoDisp()) + " horas");
		System.out.println("*******************************************************");
	}

	private void mensajeFinal() {
		System.out.println("******************************************************************");
		System.out.println("**              FIN DEL PROCESAMIENTO DE LOS USUARIOS           **");
		System.out.println("**  GRACIAS POR ELEGIRNOS - SISTEMA TURISMO EN LA TIERRA MEDIA  **");
		System.out.println("******************************************************************");
	}
}