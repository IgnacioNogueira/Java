package turismo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.PaqueteExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.sistema.Atraccion;
import turismo.sistema.Itinerario;
import turismo.sistema.Paquete;
import turismo.sistema.PaqueteAbsoluto;
import turismo.sistema.Sugerencia;

public class ItinerarioTest {
	private Itinerario itinerario;
	private final double costoAtr1 = 10;
	private final double costoAtr2 = 6;
	private final double costoPaquete = costoAtr1 + costoAtr2 - 2;
	private final double duracionAtr1 = 2;
	private final double duracionAtr2 = 1;
	private final int cupoAtr1 = 4;
	private final int cupoAtr2 = 5;
	private List<Sugerencia> sugAceptadas = new ArrayList<Sugerencia>();
	private Atraccion atraccionErebor;
	private Atraccion atraccionMoria;
	private Atraccion atraccionAmoria;
	private Paquete paqueteAbs;
	private HashMap<String, Atraccion> atraccionesParaPaquete;

	@Before
	public void setUp() {

		atraccionesParaPaquete = new HashMap<String, Atraccion>();
		try {
			atraccionErebor = new Atraccion("Erebor", 0, costoAtr1, duracionAtr1, cupoAtr1);
			atraccionMoria = new Atraccion("Moria", 0, costoAtr1, duracionAtr1, cupoAtr1);
			atraccionAmoria = new Atraccion("Amoria", 0, costoAtr2, duracionAtr2, cupoAtr2);
			atraccionesParaPaquete.put("1", atraccionMoria);
			atraccionesParaPaquete.put("2", atraccionAmoria);
			paqueteAbs = new PaqueteAbsoluto(0, costoPaquete, atraccionesParaPaquete);
		} catch (AtraccionExcepcion | SugerenciaExcepcion | PaqueteExcepcion e) {
			e.printStackTrace();
		}
		itinerario = new Itinerario();

	}

	@Test
	public void agregarAtraccion() {
		itinerario.agregarSugerencia(atraccionErebor);
		sugAceptadas.add(atraccionErebor);
		Assert.assertEquals(sugAceptadas, itinerario.getItinerario());
	}

	@Test
	public void agregarPaquete() {
		itinerario.agregarSugerencia(paqueteAbs);
		sugAceptadas.add(paqueteAbs);
		;
		Assert.assertEquals(sugAceptadas, itinerario.getItinerario());
	}

	@Test
	public void queObtengaCosto() {
		itinerario.agregarSugerencia(atraccionErebor);
		Assert.assertEquals(costoAtr1, itinerario.getCostoItinerario(), 0.1);
	}

	@Test
	public void queObtengaDuracion() {
		itinerario.agregarSugerencia(atraccionErebor);
		Assert.assertEquals(duracionAtr1, itinerario.getDuracionItinerario(), 0.1);
	}

	@Test
	public void queObtengaSugerenciasAceptadas() {
		itinerario.agregarSugerencia(atraccionErebor);
		itinerario.agregarSugerencia(paqueteAbs);
		sugAceptadas.add(atraccionErebor);
		sugAceptadas.add(paqueteAbs);
		Assert.assertEquals(sugAceptadas, itinerario.getItinerario());
	}

	@Test
	public void queDevuelvaStringParaImprimirEnArchivo() {
		itinerario.agregarSugerencia(atraccionErebor);
		String esperado = "Sugerencias aceptadas: \n[ Erebor ]\nDuracion total: 2.00\nCosto total: 10.00";
		Assert.assertEquals(esperado, itinerario.imprimirEnArchivo());
	}
}