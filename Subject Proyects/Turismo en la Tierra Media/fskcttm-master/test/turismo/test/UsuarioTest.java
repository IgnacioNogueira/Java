package turismo.test;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.excepciones.UsuarioExcepcion;
import turismo.sistema.Atraccion;
import turismo.sistema.Paquete;
import turismo.sistema.PaqueteAbsoluto;
import turismo.sistema.Usuario;

public class UsuarioTest {
	private Usuario usuario;
	private final double presupuestoUsuario = 50;
	private final double tiempoUsuario = 6;

	private Atraccion atraccionPaisaje, atraccionPaisaje2, atraccionAventura, atraccionAventura2, atraccionDegustacion,
			atraccionDegustacion2, atraccionCostosa, atraccionLarga;
	private HashMap<String, Atraccion> atraccionesPaisaje, atraccionesAventura, atraccionesDegustacion,
			atraccionesCostosas, atraccionesLargas;
	private final double costoAtr1 = 10;
	private final double costoAtr2 = 6;
	private final double costoAtr3 = 5;
	private final double costoAtrCostosa = 60;
	private final double duracionAtr1 = 3;
	private final double duracionAtr2 = 1.5;
	private final double duracionAtr3 = 1;
	private final double duracionPaqueteAbsoluto = duracionAtr1 + duracionAtr2;
	private final double duracionAtrLarga = 10;
	private final int cupoAtr1 = 4;
	private final int cupoAtr2 = 5;
	private final int cupoAtr3 = 6;

	private Paquete paqueteAbsPaisaje, paqueteAbsDegustacion, paqueteCostosoDegust;
	private final double costoPaquetePaisaje = costoAtr1 + costoAtr2 - 2;

	private final double costoPaqueteDegustacion = costoAtr3 + costoAtr3 - 2;
	private final double duracionPaqueteDegustacion = duracionAtr3 + duracionAtr3;

	private final double costoPaqueteCostosoDegust = costoAtrCostosa - 6;

	@Before
	public void setUp() {
		atraccionesPaisaje = new HashMap<String, Atraccion>();
		atraccionesAventura = new HashMap<String, Atraccion>();
		atraccionesDegustacion = new HashMap<String, Atraccion>();
		atraccionesCostosas = new HashMap<String, Atraccion>();
		atraccionesLargas = new HashMap<String, Atraccion>();

		try {

			usuario = new Usuario("Franco", 2, presupuestoUsuario, tiempoUsuario);

			atraccionPaisaje = new Atraccion("Moria", 0, costoAtr1, duracionAtr1, cupoAtr1);
			atraccionPaisaje2 = new Atraccion("Amoria", 0, costoAtr2, duracionAtr2, cupoAtr2);
			atraccionesPaisaje.put("1", atraccionPaisaje);
			atraccionesPaisaje.put("2", atraccionPaisaje2);

			atraccionAventura = new Atraccion("Fortuna", 1, costoAtr1, duracionAtr1, cupoAtr1);
			atraccionAventura2 = new Atraccion("Hazzard", 1, costoAtr2, duracionAtr2, cupoAtr2);
			atraccionesAventura.put("1", atraccionAventura);
			atraccionesAventura.put("2", atraccionAventura2);

			atraccionDegustacion = new Atraccion("Infortuna", 2, costoAtr3, duracionAtr3, cupoAtr3);
			atraccionDegustacion2 = new Atraccion("Restaurant inf", 2, costoAtr3, duracionAtr3, cupoAtr3);

			atraccionesDegustacion.put("1", atraccionDegustacion);
			atraccionesDegustacion.put("2", atraccionDegustacion2);

			atraccionCostosa = new Atraccion("Minas Tirith", 2, costoAtrCostosa, duracionAtr1, cupoAtr1);

			atraccionesCostosas.put("1", atraccionCostosa);

			atraccionLarga = new Atraccion("Minas Tirith2", 2, costoAtr1, duracionAtrLarga, cupoAtr1);
			atraccionesLargas.put("1", atraccionLarga);

			paqueteAbsPaisaje = new PaqueteAbsoluto(0, costoPaquetePaisaje, atraccionesPaisaje);
			paqueteAbsDegustacion = new PaqueteAbsoluto(2, costoPaqueteDegustacion, atraccionesDegustacion);
			paqueteCostosoDegust = new PaqueteAbsoluto(2, costoPaqueteCostosoDegust, atraccionesCostosas);

		} catch (AtraccionExcepcion | SugerenciaExcepcion | PaqueteExcepcion | UsuarioExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoPermitaPreferenciasInvalidas() throws UsuarioExcepcion {
		new Usuario("Federico", 3, 20, 4);
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoPermitaNombreVacio() throws UsuarioExcepcion {
		new Usuario("", 2, 20, 1);
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoPermitaPresupuestoNegativo() throws UsuarioExcepcion {
		new Usuario("Lucas", 0, -10, 11);
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoPermitaTiempoNegativo() throws UsuarioExcepcion {
		new Usuario("Hernan", 0, 50, -1);
	}

	@Test
	public void queSeObtengaPreferenciaCorrectamente() {
		Assert.assertEquals(true, usuario.getTipo() == 2);
	}

	@Test
	public void queSeObtengaPresupuestoCorrectamente() {
		Assert.assertEquals(true, usuario.getPresupuestoDisp() == presupuestoUsuario);
	}

	@Test
	public void queSeObtengaTiempoDisponibleCorrectamente() {
		Assert.assertEquals(true, usuario.getTiempoDisp() == tiempoUsuario);
	}

	@Test
	public void queSeObtengaNombreCorrectamente() {
		Assert.assertEquals(true, usuario.getNombre() == "Franco");
	}

	@Test
	public void queAgregaUnaSugerenciaCorrectamente() {
		try {
			usuario.agregarSugerencia(paqueteAbsDegustacion);

		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		boolean totalValido = usuario.getPresupuestoDisp() == (presupuestoUsuario - costoPaqueteDegustacion);
		Assert.assertEquals(true, totalValido);

		totalValido = usuario.getTiempoDisp() == (tiempoUsuario - duracionPaqueteDegustacion);
		Assert.assertEquals(true, totalValido);

		Assert.assertEquals(false, usuario.itinerarioVacio());

	}

	@Test
	public void queAgregaSugerenciasCorrectamente() {
		try {
			usuario.agregarSugerencia(paqueteAbsDegustacion);
			usuario.agregarSugerencia(atraccionPaisaje);

		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		double costoPaquetes = costoPaqueteDegustacion + costoAtr1;

		boolean totalValido = usuario.getPresupuestoDisp() == (presupuestoUsuario - costoPaquetes);
		Assert.assertEquals(true, totalValido);

		double duracionPaquetes = duracionPaqueteDegustacion + duracionAtr1;

		totalValido = usuario.getTiempoDisp() == (tiempoUsuario - duracionPaquetes);
		Assert.assertEquals(true, totalValido);

		Assert.assertEquals(false, usuario.itinerarioVacio());

	}

	@Test
	public void queAgregaDifSugerenciasCorrectamente() {
		try {
			usuario.agregarSugerencia(atraccionDegustacion);
			usuario.agregarSugerencia(paqueteAbsPaisaje);
		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		boolean totalValido = usuario.getPresupuestoDisp() == (presupuestoUsuario - costoAtr3 - costoPaquetePaisaje);
		Assert.assertEquals(true, totalValido);

		totalValido = usuario.getTiempoDisp() == (tiempoUsuario - duracionAtr3 - duracionPaqueteAbsoluto);
		Assert.assertEquals(true, totalValido);

		Assert.assertEquals(false, usuario.itinerarioVacio());

	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoAgregueSugerenciaSiNoPuedeCosto() throws UsuarioExcepcion {
		try {
			usuario.agregarSugerencia(atraccionDegustacion);
			usuario.agregarSugerencia(atraccionAventura);

		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		usuario.agregarSugerencia(paqueteCostosoDegust);
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoAgregueSugerenciaSiNoPuedeTiempo() throws UsuarioExcepcion {
		try {
			usuario.agregarSugerencia(atraccionDegustacion);

		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		usuario.agregarSugerencia(atraccionLarga);
	}

	@Test(expected = UsuarioExcepcion.class)
	public void queNoAgregaSugerenciasSiNoPuede() throws UsuarioExcepcion {
		try {
			usuario.agregarSugerencia(atraccionDegustacion);
		} catch (UsuarioExcepcion e) {
			Assert.fail(e.getMessage());
		}

		usuario.agregarSugerencia(paqueteCostosoDegust);
	}
}