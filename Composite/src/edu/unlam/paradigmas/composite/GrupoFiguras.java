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

	// Esto no está pedido en el enunciado, pero como para abrir más el panoráma y
	// las posibilidades
	// quiero pintar todas las figuras de un solo color

	// 1 - Pueden estar una encima de la otra (X e Y iguales)
	// 2 - Tendría que conectar con X (Podría cooncidir con X O Y)
	// 3 - Si no coincide con ninguna, error <!>

	private boolean grupoDeFigurasSeSolapan() {
		for (int i = 0; i < listaFiguras.size(); ++i) {
			if (!listaFiguras.get(i).figurasSeSolapan(listaFiguras.get(i + 1))) {
				return false;
			}
		}
		return true;
	}

	public void pintarGrupo(String color) throws Exception {

		if (!listaFiguras.isEmpty() && grupoDeFigurasSeSolapan()) {
			for (Figura f : listaFiguras) {
				f.pintar(color);
			}
		} else {
			throw new Exception("No se puede pintar el conjunto de figuras que forma " + this.nombre);
		}
	}
}
