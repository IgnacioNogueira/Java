package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Circulo;
import edu.unlam.paradigmas.composite.Cuadrado;
import edu.unlam.paradigmas.composite.Punto;
import edu.unlam.paradigmas.composite.Triangulo;

public class FiguraTest {

	Punto p1 = new Punto(1, 1);
	Circulo cir1;
	Triangulo t1;
	Cuadrado cuad1;

	@Before
	public void setUp() throws Exception {
		cir1 = new Circulo(10, "Ventana 1", "Blanco", p1);
		t1 = new Triangulo(10.33, 20.11, 30.55, "Techo", "Blanco", p1);
		cuad1 = new Cuadrado(10, "Pared 1", "Blanco", p1);
	}

	@Test(expected = Exception.class)
	public void queValideAtributosDeFigura() throws Exception {

		Circulo cir1 = new Circulo(-22, "Ventana 1", "Blanco", p1);
		Triangulo t1 = new Triangulo(10.33, -8, 30.55, "Techo", "Blanco", p1);
		Cuadrado cuad1 = new Cuadrado(-10, "Pared 1", "Blanco", p1);
	}

	@Test
	public void queCalculaLaCantidadDePomosParaPintarFigura() throws Exception {
		Assert.assertEquals(4, cir1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, t1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, cuad1.cantidadPomosParaPintarFigura());
	}

	@Test(expected = Exception.class)
	public void queNoCalculaLaCantidadDePomosSiFiguraEsIncorrecta() throws Exception {

		Circulo cir1 = new Circulo(-22, "Ventana 1", "Blanco", p1);
		Triangulo t1 = new Triangulo(10.33, -8, 30.55, "Techo", "Blanco", p1);
		Cuadrado cuad1 = new Cuadrado(-10, "Pared 1", "Blanco", p1);

		System.out.println("No debería llegar acá");
		Assert.assertEquals(4, cir1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, t1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, cuad1.cantidadPomosParaPintarFigura());
	}

	@Test
	public void queLaFiguraSePinte() throws Exception {
		cir1.pintar("Verde");
		t1.pintar("Rojo");
		cuad1.pintar("Azul");

		Assert.assertEquals("Verde", cir1.getcolor());
		Assert.assertEquals("Rojo", t1.getcolor());
		Assert.assertEquals("Azul", cuad1.getcolor());
	}

}
