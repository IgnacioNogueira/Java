package turismo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.sistema.Atraccion;
import turismo.sistema.Paquete;
import turismo.sistema.PaqueteAbsoluto;
import turismo.sistema.PaqueteAxB;
import turismo.sistema.PaquetePorcentual;

public class PaqueteTest {

	private Atraccion atraccionPaisaje1, atraccionPaisaje2, atraccionPaisaje3, atraccionPaisaje4, atraccionPaisaje5;
	private Map<String, Atraccion> atracciones;
	private Map<String, Atraccion> atraccionesGratuitas;
	private Map<String, Atraccion> atraccionesAXB;
	private Map<String, Atraccion> sinAtracciones;
	private Paquete paqueteAbs;
	private Paquete paqueteAXB;
	private Paquete paquetePorc;
	private List<Paquete> paquetes;
	private static final int cupoAtrPaisaje1 = 6;
	private static final int cupoAtrPaisaje2 = 5;
	private static final int cupoAtrPaisaje3 = 4;
	private static final int cupoAtrGratis = 6;
	private static final int cupoMin = Math.min(cupoAtrGratis,
			Math.min(cupoAtrPaisaje3, Math.min(cupoAtrPaisaje1, cupoAtrPaisaje2)));
	private static final double costoAtrPaisaje1 = 10;
	private static final double costoAtrPaisaje2 = 20;
	private static final double costoAtrPaisaje3 = 25;
	private static final double costoAtrGratuita1 = 60;
	private static final double costoAtrGratuita2 = 60;
	private static final double costoTotal = costoAtrPaisaje1 + costoAtrPaisaje2 + costoAtrPaisaje3;
	private static final double costoOriginalAXB = costoTotal + costoAtrGratuita1 + costoAtrGratuita2;
	private static final double porcentajeDescontado = 0.1;
	private static final double precioAbsoluto = costoTotal - 10;
	private static final double totalConDescuento = costoTotal - costoTotal * porcentajeDescontado;

	@Before
	public void setup() {
		atracciones = new HashMap<String, Atraccion>();
		atraccionesGratuitas = new HashMap<String, Atraccion>();
		atraccionesAXB = new HashMap<String, Atraccion>();
		sinAtracciones = new HashMap<String, Atraccion>();
		paquetes = new ArrayList<Paquete>();
		try {
			atraccionPaisaje1 = new Atraccion("Moria", 0, costoAtrPaisaje1, 2, cupoAtrPaisaje1);
			atraccionPaisaje2 = new Atraccion("Fortuna", 0, costoAtrPaisaje2, 3, cupoAtrPaisaje2);
			atraccionPaisaje3 = new Atraccion("Giratoria", 0, costoAtrPaisaje3, 4, cupoAtrPaisaje3);
			atraccionPaisaje4 = new Atraccion("Mirador", 0, costoAtrGratuita1, 5, cupoAtrGratis);
			atraccionPaisaje5 = new Atraccion("Telesferico", 0, costoAtrGratuita2, 6, cupoAtrGratis);
		} catch (AtraccionExcepcion | SugerenciaExcepcion e) {
			e.printStackTrace();
		}

		atracciones.put("1", atraccionPaisaje1);
		atracciones.put("2", atraccionPaisaje2);
		atracciones.put("3", atraccionPaisaje3);

		atraccionesGratuitas.put("4", atraccionPaisaje4);
		atraccionesGratuitas.put("5", atraccionPaisaje5);

		atraccionesAXB.putAll(atracciones);
		atraccionesAXB.putAll(atraccionesGratuitas);
		try {
			paqueteAbs = new PaqueteAbsoluto(0, precioAbsoluto, atracciones);
			paqueteAXB = new PaqueteAxB(0, atraccionesAXB, atraccionesGratuitas);
			paquetePorc = new PaquetePorcentual(0, porcentajeDescontado, atracciones);
		} catch (PaqueteExcepcion | SugerenciaExcepcion e) {
			e.printStackTrace();
		}
		paquetes.add(paqueteAXB);
		paquetes.add(paqueteAbs);
		paquetes.add(paquetePorc);

	}

	@Test
	public void queTieneElementos() {
		Assert.assertEquals(3, atracciones.size());
	}

	@Test
	public void quePorcentajeSeDescuente() {
		boolean totalValido = paquetePorc.getCosto() == totalConDescuento;
		Assert.assertEquals(totalValido, true);
	}

	@Test
	public void quePaqueteAXBDescuenteCosto() {
		boolean totalValido = paqueteAXB.getCosto() == costoTotal;
		Assert.assertEquals(totalValido, true);
	}

	@Test
	public void quePaqueteAbsolutoDescuenteCosto() {
		boolean totalValido = paqueteAbs.getCosto() == precioAbsoluto;
		Assert.assertEquals(totalValido, true);
	}

	@Test
	public void queObtengocostoOriginal() {
		boolean originalAbs = paqueteAbs.getMontoOrigPaquete() == costoTotal;
		boolean originalAXB = paqueteAXB.getMontoOrigPaquete() == costoOriginalAXB;
		boolean originalPorc = paquetePorc.getMontoOrigPaquete() == costoTotal;

		Assert.assertEquals(true, originalAbs);
		Assert.assertEquals(true, originalAXB);
		Assert.assertEquals(true, originalPorc);
	}

	@Test
	public void queObtengaMenorCupo() {
		Assert.assertEquals(cupoMin, paqueteAbs.getCupoDisponible());
		Assert.assertEquals(cupoMin, paqueteAXB.getCupoDisponible());
		Assert.assertEquals(cupoMin, paquetePorc.getCupoDisponible());

	}

	@Test
	public void queReduzcaCuposDeAtracciones() {
		try {
			paqueteAbs.reducirCupo();
		} catch (AtraccionExcepcion e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(cupoAtrPaisaje1 - 1, atraccionPaisaje1.getCupoDisponible());
		Assert.assertEquals(cupoAtrPaisaje2 - 1, atraccionPaisaje2.getCupoDisponible());
		Assert.assertEquals(cupoAtrPaisaje3 - 1, atraccionPaisaje3.getCupoDisponible());
	}

	@Test
	public void queReduzcaMaxCupos() {

		for (Paquete paquete : paquetes) {

			try {

				int cupoDisponible = paquete.getCupoDisponible();
				for (int i = 0; i < cupoDisponible; ++i) {
					paquete.reducirCupo();
				}

				Assert.assertEquals(0, paquete.getCupoDisponible());

			} catch (AtraccionExcepcion e) {
				Assert.fail(e.getMessage());
			}
		}
	}

	@Test
	public void queGenereBienNombre() {
		String nombreEsperado = "Moria, Fortuna, Giratoria";
		Assert.assertEquals(nombreEsperado, paqueteAbs.getNombre());
	}

	@Test(expected = PaqueteExcepcion.class)
	public void queNoCreePaqueteAXBSinAtraccionesGratuitas() throws SugerenciaExcepcion, PaqueteExcepcion {
		new PaqueteAxB(2, atracciones, sinAtracciones);
	}

	@Test(expected = PaqueteExcepcion.class)
	public void quePaqueteAbsolutoNoTengaCostoFinalMayorAlOriginal() throws SugerenciaExcepcion, PaqueteExcepcion {
		new PaqueteAbsoluto(2, costoTotal + 10, atracciones);
	}

	@Test(expected = PaqueteExcepcion.class)
	public void quePaqueteAbsolutoNoAcepteCostoNoPositivo() throws SugerenciaExcepcion, PaqueteExcepcion {
		new PaqueteAbsoluto(2, -10, atracciones);
	}

	@Test
	public void queSeOrdenePorPrecioYTiempo() {
		paquetes.sort(Comparator.reverseOrder());
		List<Paquete> paquetesOrdenados = new ArrayList<Paquete>();
		paquetesOrdenados.add(paqueteAXB);
		paquetesOrdenados.add(paquetePorc);
		paquetesOrdenados.add(paqueteAbs);

		Assert.assertEquals(paquetes, paquetesOrdenados);

	}

	@Test(expected = PaqueteExcepcion.class)
	public void queAtraccionesTotalesContengaALasGratuitas() throws SugerenciaExcepcion, PaqueteExcepcion {
		new PaqueteAxB(1, atracciones, atraccionesGratuitas);
	}

}