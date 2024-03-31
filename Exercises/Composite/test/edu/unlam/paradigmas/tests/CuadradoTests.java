package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Cuadrado;
import edu.unlam.paradigmas.composite.Punto;

public class CuadradoTests {

	private Cuadrado c1;
	private Punto p1;

	private Cuadrado c2;
	private Punto p2;

	private Cuadrado c3;
	private Punto p3;

	private Cuadrado c4;
	private Punto p4;

	private Cuadrado c5;
	private Punto p5;

	private Cuadrado c6;
	private Punto p6;

	@Before
	public void setUp() throws Exception {
		c1 = new Cuadrado(13.55, "Ventana 1", "Blanco", p1 = new Punto(1, 1));
		c2 = new Cuadrado(23.88, "Ventana 2", "Blanco", p2 = new Punto(-1, -2));
		c3 = new Cuadrado(311.88, "Ventana 3", "Blanco", p3 = new Punto(1, -3));
	}

	@Test
	public void queCalculeElAreaCorrectamente() {
		Assert.assertEquals(183.60, c1.calcularArea(), 0.2f);
		Assert.assertEquals(570.25, c2.calcularArea(), 0.2f);
		Assert.assertEquals(97269.13, c3.calcularArea(), 0.2f);
	}

	@Test(expected = Exception.class)
	public void queNoSeCreeUnCirculoConRadioNegativo() throws Exception {
		c4 = new Cuadrado(-4, "Ventana 4", "Blanco", p4 = new Punto(-55, 8));
		c5 = new Cuadrado(-1000, "Ventana 4", "Blanco", p5 = new Punto(-55, -8));
		c6 = new Cuadrado(0, "Ventana 4", "Blanco", p6 = new Punto(55, -8));
	}

}
