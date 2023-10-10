package edu.unlam.paradigmas.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.paradigmas.composite.Circulo;
import edu.unlam.paradigmas.composite.Cuadrado;
import edu.unlam.paradigmas.composite.Punto;
import edu.unlam.paradigmas.composite.Triangulo;

public class FiguraTest {

	private Punto p1 = new Punto(1, 1);
	private Punto p2 = new Punto(22, 1);
	private Punto p3 = new Punto(1, 22);
	private Punto p4 = new Punto(1, 1);

	@Test
	public void queCalculaLaCantidadDePomosParaPintarFigura() throws Exception {

		Circulo cir1 = new Circulo(10, "Ventana 1", "Blanco", p1);
		Triangulo t1 = new Triangulo(10.33, 20.11, 30.55, "Techo", "Blanco", p1);
		Cuadrado cuad1 = new Cuadrado(10, "Pared 1", "Blanco", p1);

		Assert.assertEquals(4, cir1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, t1.cantidadPomosParaPintarFigura());
		Assert.assertEquals(1, cuad1.cantidadPomosParaPintarFigura());
	}

	@Test
	public void queDeVerdaderoSiFigurasSeSolapan() throws Exception {

		Circulo cir1 = new Circulo(10, "Ventana 1", "Blanco", p1);
		Triangulo t1 = new Triangulo(10.33, 20.11, 30.55, "Techo", "Blanco", p1);
		Cuadrado cuad1 = new Cuadrado(10, "Pared 1", "Blanco", p1);
	
		Assert.assertTrue(cir1.figurasSeSolapan(t1));
		Assert.assertTrue(t1.figurasSeSolapan(cir1));
		Assert.assertTrue(cir1.figurasSeSolapan(cuad1));
		Assert.assertTrue(cuad1.figurasSeSolapan(cir1));
		Assert.assertTrue(t1.figurasSeSolapan(cuad1));
		Assert.assertTrue(cuad1.figurasSeSolapan(t1));

	}
	
	@Test
	public void queDeFalsoSiFigurasNoSeSolapan() throws Exception {

		Circulo cir1 = new Circulo(10, "Ventana 1", "Blanco", p1);
		Circulo cir2 = new Circulo(10, "Ventana 1", "Blanco", p2);
		Triangulo t2 = new Triangulo(10.33, 20.11, 30.55, "Techo", "Blanco", p3);
		Cuadrado cuad1 = new Cuadrado(10, "Pared 1", "Blanco", p3);

		Assert.assertFalse(cir2.figurasSeSolapan(t2));
		Assert.assertFalse(t2.figurasSeSolapan(cir2));
		Assert.assertFalse(t2.figurasSeSolapan(cir1));
		Assert.assertFalse(cir1.figurasSeSolapan(t2));
	}

	@Test
	public void queLaFiguraSePinte() throws Exception {
		Circulo cir1 = new Circulo(10, "Ventana 1", "Blanco", p1);
		Triangulo t1 = new Triangulo(10.33, 20.11, 30.55, "Techo", "Blanco", p1);
		Cuadrado cuad1 = new Cuadrado(10, "Pared 1", "Blanco", p1);
		
		cir1.pintar("Verde");
		t1.pintar("Rojo");
		cuad1.pintar("Azul");
		
		Assert.assertEquals("Verde", cir1.getcolor());
		Assert.assertEquals("Rojo", t1.getcolor());
		Assert.assertEquals("Azul", cuad1.getcolor());
	}

}
