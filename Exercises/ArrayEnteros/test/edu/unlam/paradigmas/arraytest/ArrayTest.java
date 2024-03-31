package edu.unlam.paradigmas.arraytest;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.paradigmas.array.Array;

public class ArrayTest {

	@Test
	public void arraysDuplasConDiferentesElementosPositivos() throws Exception {
		int[] array = { 24, 36, 45, 75, 91 };
		int[] array2 = { 24, 15, 36, 49, 50 };
		int[] array3 = { 1, 2, 3, 4, 5 };

		int[] arrayBuscado = { 45, 75 };
		int[] arrayBuscado2 = { 24, 36 };
		int[] arrayBuscado3 = { 2, 4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
	}

	@Test
	public void arraysDuplasConDiferentesElementosNegativos() throws Exception {
		int[] array = { -24, -36, -45, -75, -91 };
		int[] array2 = { -24, -15, -36, -49, -50 };
		int[] array3 = { -1, -2, -3, -4, -5 };

		int[] arrayBuscado = { -45, -75 };
		int[] arrayBuscado2 = { -24, -36 };
		int[] arrayBuscado3 = { -2, -4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
	}

	@Test
	public void arraysDuplasConDiferentesElementosPositivosYNegativos() throws Exception {
		int[] array = { 24, -36, 45, -75, 91 };
		int[] array2 = { -24, 15, -36, 49, -50 };
		int[] array3 = { -1, -2, -3, -4, -5 };
		int[] array4 = { 1, 2, 3, 4, 5 };

		int[] arrayBuscado = { 45, -75 };
		int[] arrayBuscado2 = { -24, -36 };
		int[] arrayBuscado3 = { -2, -4 };
		int[] arrayBuscado4 = { 2, 4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
		Assert.assertArrayEquals(arrayBuscado4, Array.duplaArrayMCD(array4));
	}

	@Test
	public void arraysDuplasConDiferentesElementosPositivosYCeros() throws Exception {
		int[] array = { 24, 36, 45, 0, 75, 91, 0, 0 };
		int[] array2 = { 24, 15, 36, 0, 49, 50, 0, 0 };
		int[] array3 = { 1, 2, 3, 0, 4, 5, 0, 0 };

		int[] arrayBuscado = { 45, 75 };
		int[] arrayBuscado2 = { 24, 36 };
		int[] arrayBuscado3 = { 2, 4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
	}

	@Test
	public void arraysDuplasConDiferentesElementosNegativosYCeros() throws Exception {
		int[] array = { -24, -36, -45, 0, -75, -91, 0, 0 };
		int[] array2 = { -24, -15, -36, 0, -49, -50, 0, 0 };
		int[] array3 = { -1, -2, -3, 0, -4, -5, 0, 0 };

		int[] arrayBuscado = { -45, -75 };
		int[] arrayBuscado2 = { -24, -36 };
		int[] arrayBuscado3 = { -2, -4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
	}

	@Test
	public void arraysDuplasConDiferentesElementosPositivosNegativosYCeros() throws Exception {
		int[] array = { -24, -36, -45, 0, 75, -91, 0, 0 };
		int[] array2 = { -24, -15, -36, 0, -49, -50, 0, 0 };
		int[] array3 = { -1, 2, -3, 0, -4, -5, 0, 0 };

		int[] arrayBuscado = { -45, 75 };
		int[] arrayBuscado2 = { -24, -36 };
		int[] arrayBuscado3 = { 2, -4 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
	}

	@Test
	public void arrayDuplaConLosMismosElementosPositivos() throws Exception {
		int[] array = { 24, 24, 24, 24, 24 };
		int[] array2 = { 15, 15, 15, 15, 15 };
		int[] array3 = { 32, 32, 32, 32, 32 };

		int[] arrayBuscado = { 24, 24 };
		int[] arrayBuscado2 = { 15, 15 };
		int[] arrayBuscado3 = { 32, 32 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));

	}

	@Test
	public void arrayDuplaConLosMismosElementosNegativos() throws Exception {
		int[] array = { -24, -24, -24, -24, -24 };
		int[] array2 = { -15, -15, -15, -15, -15 };
		int[] array3 = { -32, -32, -32, -32, -32 };

		int[] arrayBuscado = { -24, -24 };
		int[] arrayBuscado2 = { -15, -15 };
		int[] arrayBuscado3 = { -32, -32 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));

	}

	@Test
	public void arrayDuplaIgualAUnoUno() throws Exception {
		int[] array1 = { 2, 3, 1, 5, 7, 1, 1, 1 };
		int[] array2 = { -1, -1, -2, -3, -1, -5, -1, -1 };
		int[] array3 = { 0, 0, 0, 0, 0, 1, 0, 1 };
		int[] array4 = { 2, 3, 5, 7, 11, 13, 1, 1 };
		int[] array5 = { 1, 1, 1, 1, 1 };

		int[] arrayBuscado1 = { 2, 3 };
		int[] arrayBuscado2 = { -1, -2 }; // está bien?
		int[] arrayBuscado3 = { 1, 1 };
		int[] arrayBuscado4 = { 2, 3 };
		int[] arrayBuscado5 = { 1, 1 };

		Assert.assertArrayEquals(arrayBuscado1, Array.duplaArrayMCD(array1));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(arrayBuscado3, Array.duplaArrayMCD(array3));
		Assert.assertArrayEquals(arrayBuscado4, Array.duplaArrayMCD(array4));
		Assert.assertArrayEquals(arrayBuscado5, Array.duplaArrayMCD(array5));

	}

	@Test
	public void arrayDuplaSoloDosElementos() throws Exception {
		int[] array = { 24, 36 };
		int[] array2 = { -1, -11 };
		int[] array3 = { 1000, 11000 };
		int[] array4 = { 1, 1 };

		Assert.assertArrayEquals(array, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(array2, Array.duplaArrayMCD(array2));
		Assert.assertArrayEquals(array3, Array.duplaArrayMCD(array3));
		Assert.assertArrayEquals(array4, Array.duplaArrayMCD(array4));

	}

	@Test
	public void arrayDuplaSoloTresElementos() throws Exception {
		int[] array = { 24, 36, 11 };
		int[] arrayBuscado = { 24, 36 };
		int[] array2 = { 24, -36, -11 };
		int[] arrayBuscado2 = { 24, -36 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
		Assert.assertArrayEquals(arrayBuscado2, Array.duplaArrayMCD(array2));
	}

	@Test
	public void arrayDuplaSoloTresElementosCero() throws Exception {
		int[] array = { 0, 0, 0 };
		int[] arrayBuscado = { 0, 0 };

		Assert.assertArrayEquals(arrayBuscado, Array.duplaArrayMCD(array));
	}

	@Test(expected = Exception.class)
	public void arrayVacio() throws Exception {
		int[] array = {};
		Array.duplaArrayMCD(array);
	}

	@Test(expected = Exception.class)
	public void arrayConUnSoloElemento() throws Exception {
		int[] array = { 24 };
		Array.duplaArrayMCD(array);
	}

}
