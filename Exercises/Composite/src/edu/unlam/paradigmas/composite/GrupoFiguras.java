package edu.unlam.paradigmas.composite;

import java.util.ArrayList;

public class GrupoFiguras extends Figura {
	private ArrayList<Figura> listaFiguras;

	public GrupoFiguras(String nombre, ArrayList<Figura> figuras, Punto ubicacion) throws Exception {
		super(nombre, "", ubicacion); // cómo podría validar que no se le pase un color en particular (cada figura
										// tiene su color)
		agregar(figuras);
	}

	private void agregar(ArrayList<Figura> figuras) {
		for (Figura f : figuras) {
			listaFiguras.add(f);
		}
	}

	@Override
	public String toString() {
		return "FC: " + this.getNombre();
	}

	@Override
	public double calcularArea() throws Exception {
		if (listaFiguras.isEmpty()) {
			throw new Exception("No se puede calcular el area de una casa sin figuras");
		}

		double totalArea = 0;

		for (Figura f : listaFiguras) {
			totalArea += f.calcularArea();
		}
		return totalArea;
	}

	public void pintarGrupo(String color) throws Exception {

		if (!listaFiguras.isEmpty()) {
			for (Figura f : listaFiguras) {
				f.pintar(color);
			}
		} else {
			throw new Exception("No se puede pintar el conjunto de figuras que forma " + this.nombre);
		}
	}
}
