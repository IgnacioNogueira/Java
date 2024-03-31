package edu.unlam.paradigmas.array;

import java.util.Arrays;

public class Array {

	public static int mcdDosNumeros(int n1, int n2) {

		if (n1 == n2)
			return n1;

		if (n1 == 0 || n2 == 0)
			return 0;

		while (n2 != 0) {
			int temp = n2;
			n2 = n1 % n2;
			n1 = temp;
		}
		return Math.abs(n1);
	}

	public static int[] duplaArrayMCD(int[] array) throws Exception {

		if (array.length == 0 || array.length == 1) {
			throw new Exception("No se puede calcular la dupla MCD, debido a que el tamaño del array");
		}

		int[] pos = new int[2];
		int mcdAct, mcdMax = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; ++i) {
			for (int j = i + 1; j < array.length; ++j) {
				mcdAct = mcdDosNumeros(array[i], array[j]);

				if (mcdMax < mcdAct) {
					mcdMax = mcdAct;
					pos[0] = array[i];
					pos[1] = array[j];
				}
			}
		}

		return pos;
	}

	public static void main(String[] args) {
		int[] array = { 24, 36, 11 };

		try {
			System.out.println("nros: " + Arrays.toString(duplaArrayMCD(array)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
