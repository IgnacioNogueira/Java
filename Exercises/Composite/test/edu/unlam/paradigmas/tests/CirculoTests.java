package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Circulo;
import edu.unlam.paradigmas.composite.Punto;

public class CirculoTests {

	private Circulo c1;
	private Punto p1;

	private Circulo c2;
	private Punto p2;

	private Circulo c3;
	private Punto p3;

	private Circulo c4;
	private Punto p4;

	private Circulo c5;
	private Punto p5;

	private Circulo c6;
	private Punto p6;

	@Before
	public void setUp() throws Exception {
		c1 = new Circulo(1, "Ventana 1", "Blanco", p1 = new Punto(1, 1));
		c2 = new Circulo(2, "Ventana 2", "Blanco", p2 = new Punto(1, 2));
		c3 = new Circulo(3, "Ventana 3", "Blanco", p3 = new Punto(1, 3));
	}

	@Test
	public void queCalculeElAreaCorrectamente() {
		Assert.assertEquals(3.14, c1.calcularArea(), 0.2f);
		Assert.assertEquals(12.56, c2.calcularArea(), 0.2f);
		Assert.assertEquals(28.27, c3.calcularArea(), 0.2f);
	}

	@Test(expected = Exception.class)
	public void queNoSeCreeUnCirculoConRadioNegativo() throws Exception {
		c4 = new Circulo(-4, "Ventana 4", "Blanco", p4 = new Punto(-55, 8));
		c5 = new Circulo(-1000, "Ventana 4", "Blanco", p5 = new Punto(-55, -8));
		c6 = new Circulo(0, "Ventana 4", "Blanco", p6 = new Punto(55, -8));
	}

}
