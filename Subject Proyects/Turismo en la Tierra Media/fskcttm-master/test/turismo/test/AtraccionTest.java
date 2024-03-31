package turismo.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import turismo.excepciones.AtraccionExcepcion;
import turismo.excepciones.SugerenciaExcepcion;
import turismo.sistema.Atraccion;

public class AtraccionTest {

	private Atraccion atraccion;

	@Before
	public void setUp() {
		try {
			atraccion = new Atraccion("Moria", 0, 10, 2, 6);
		} catch (AtraccionExcepcion | SugerenciaExcepcion e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test(expected = AtraccionExcepcion.class)
	public void queAtraccionNoTengaCupoInvalido() throws AtraccionExcepcion, SugerenciaExcepcion {
		new Atraccion("Atraccion1", 0, 10.0, 3, -1);
	}

	@Test
	public void queVerifiqueCupoDispCorrecto() {
		Assert.assertEquals(6, atraccion.getCupoDisponible());
	}

	@Test
	public void queVerifiqueCupoTotalCorrecto() {
		Assert.assertEquals(6, atraccion.getCupoTotal());
	}

	@Test
	public void queCupoYDisponibilidalInicializenCorrecto() {
		Assert.assertEquals(atraccion.getCupoDisponible(), atraccion.getCupoTotal());
	}

	@Test
	public void queReduzcaMasDeUnCupo() {
		try {
			atraccion.reducirCupo();
			atraccion.reducirCupo();
			atraccion.reducirCupo();
			Assert.assertEquals(3, atraccion.getCupoDisponible());
		} catch (AtraccionExcepcion e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void queReduzcaMaxCupos() {
		try {
			for (int i = 0; i < atraccion.getCupoTotal(); ++i) {
				atraccion.reducirCupo();
			}
			Assert.assertEquals(0, atraccion.getCupoDisponible());
		} catch (AtraccionExcepcion e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test(expected = AtraccionExcepcion.class)
	public void queNoReduzcaMasCupoDelPermitido() throws AtraccionExcepcion {
		for (int i = 0; i < atraccion.getCupoTotal(); ++i) {
			atraccion.reducirCupo();
		}
		atraccion.reducirCupo();
	}

	@Test
	public void queNoReduzcaMinCuposPermitidos() throws AtraccionExcepcion {
		atraccion.reducirCupo();
		Assert.assertEquals(5, atraccion.getCupoDisponible());
	}

	@Test
	public void seOrdenaPorPrecioYTiempo() throws AtraccionExcepcion, SugerenciaExcepcion {
		List<Atraccion> atraccionGeneral = new ArrayList<Atraccion>();
		List<Atraccion> atraccionOrdenado = new ArrayList<Atraccion>();
		Atraccion atraccion1;
		Atraccion atraccion2;
		Atraccion atraccion3;
		Atraccion atraccion4;
		Atraccion atraccion5;

		try {
			atraccion1 = new Atraccion("Moria", 0, 10, 5, 1);
			atraccion2 = new Atraccion("Fortuna", 0, 20, 3, 1);
			atraccion3 = new Atraccion("Giratoria", 0, 5, 3, 1);
			atraccion4 = new Atraccion("Mirador", 0, 5, 5, 1);
			atraccion5 = new Atraccion("Telesferico", 0, 30, 6, 1);

			atraccionGeneral.add(atraccion1);
			atraccionGeneral.add(atraccion2);
			atraccionGeneral.add(atraccion3);
			atraccionGeneral.add(atraccion4);
			atraccionGeneral.add(atraccion5);

			atraccionOrdenado.add(atraccion5);
			atraccionOrdenado.add(atraccion2);
			atraccionOrdenado.add(atraccion1);
			atraccionOrdenado.add(atraccion4);
			atraccionOrdenado.add(atraccion3);
		} catch (AtraccionExcepcion | SugerenciaExcepcion e) {
			Assert.fail(e.getMessage());
		}

		atraccionGeneral.sort(Comparator.reverseOrder());

		Assert.assertEquals(atraccionGeneral, atraccionOrdenado);

	}

}