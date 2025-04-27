package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Punto;
import edu.unlam.paradigmas.composite.Triangulo;

public class TrianguloTests {

	private Triangulo t1;
	private Punto p1;

	private Triangulo t2;
	private Punto p2;

	private Triangulo t3;
	private Punto p3;

	private Triangulo t4;
	private Punto p4;

	private Triangulo t5;
	private Punto p5;

	private Triangulo t6;
	private Punto p6;

	@Before
	public void setUp() throws Exception {
		t1 = new Triangulo(1, 2, 3, "Ventana 1", "Blanco", p1 = new Punto(1, 1));
		t2 = new Triangulo(4, 5, 6, "Ventana 1", "Blanco", p2 = new Punto(1, 2));
		t3 = new Triangulo(3, 3, 3, "Ventana 1", "Blanco", p3 = new Punto(1, 3));
	}

	@Test
	public void queCalculeElAreaCorrectamente() {
		Assert.assertEquals(0, t1.calcularArea(), 0.2f);
		Assert.assertEquals(9.92, t2.calcularArea(), 0.2f);
		Assert.assertEquals(3.89, t3.calcularArea(), 0.2f);
	}

	@Test(expected = Exception.class)
	public void queNoSeCreeUnTrianguloConLadosNegativo() throws Exception {
		t1 = new Triangulo(-1, 2, 3, "Ventana 1", "Blanco", p4 = new Punto(-1, 1));
		t2 = new Triangulo(4, -5, 6, "Ventana 1", "Blanco", p5 = new Punto(1, -2));
		t3 = new Triangulo(3, 3, -3, "Ventana 1", "Blanco", p6 = new Punto(-1, -3));
		t4 = new Triangulo(-3, -3, -3, "Ventana 1", "Blanco", p6 = new Punto(-1, -3));
	}
}
