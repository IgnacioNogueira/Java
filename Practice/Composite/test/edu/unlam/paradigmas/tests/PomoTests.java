package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Pomo;

public class PomoTests {

	Pomo p1;
	Pomo p2;
	Pomo p3;

	@Before
	public void setUp() throws Exception {
		p1 = new Pomo("Verde");
		p2 = new Pomo("Rojo");
		p3 = new Pomo("Azul");
	}

	@Test(expected = Exception.class)
	public void queCreePomosConColoresValidados() throws Exception {
		Pomo p4 = new Pomo("Pepito");
		Pomo p5 = new Pomo("Pepote");
		Pomo p6 = new Pomo("Pepon");
	}

	@Test
	public void queSeUtilizeElPomo() throws Exception {
		p1.utilizarPomo(10);
		p1.utilizarPomo(20);
		p1.utilizarPomo(30);
		p2.utilizarPomo(10);
		p2.utilizarPomo(20);
		p2.utilizarPomo(10);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);

		Assert.assertEquals(40, p1.getCapacidadActual(), 0.0);
		Assert.assertEquals(60, p2.getCapacidadActual(), 0.0);
		Assert.assertEquals(10, p3.getCapacidadActual(), 0.0);

	}

	@Test
	public void queSeUtilizeLaCantMaxDelPomoYNoHayaMasPintura() throws Exception {
		p1.utilizarPomo(20);
		p1.utilizarPomo(20);
		p1.utilizarPomo(30);
		p1.utilizarPomo(30);
		p2.utilizarPomo(80);
		p2.utilizarPomo(20);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);
		p3.utilizarPomo(10);
		Assert.assertTrue(p1.estaVacio());
		Assert.assertTrue(p2.estaVacio());
		Assert.assertTrue(p3.estaVacio());

	}

	@Test(expected = Exception.class)
	public void queNoSeUtilizeElPomoSiEstaVacio() throws Exception {
		p1.utilizarPomo(20);
		p1.utilizarPomo(20);
		p1.utilizarPomo(30);
		p1.utilizarPomo(30);
		p1.utilizarPomo(30);
		p2.utilizarPomo(80);
		p2.utilizarPomo(20);
		p2.utilizarPomo(20);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);
		p3.utilizarPomo(30);
		p3.utilizarPomo(10);
		p3.utilizarPomo(10);
	}

	@Test(expected = Exception.class)
	public void queNoSeUtilizeElPomoSiLaCantPinturaSolicitadaExcedeCapacidadActual() throws Exception {
		p1.utilizarPomo(1000);
		p2.utilizarPomo(11000);
		p3.utilizarPomo(Double.MAX_VALUE);
	}

	@Test(expected = RuntimeException.class)
	public void queNoSeUtilizeElPomoSiPorParametroPonenCeroONegativos() throws Exception {
		p1.utilizarPomo(-6644848);
		p2.utilizarPomo(-8888);
		p3.utilizarPomo(Double.MIN_VALUE);
	}
}
