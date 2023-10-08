package edu.unlam.paradigmas.composite;

import java.util.ArrayList;

public class GrupoFiguras extends Figura {
	private ArrayList<Figura> listaFiguras;

	public GrupoFiguras(String nombre, String color, ArrayList<Figura> figuras) {
		super(nombre, color);
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
	protected double calcularArea() throws Exception {
		if (listaFiguras.isEmpty()) {
			throw new Exception("No se puede calcular el area de una casa sin figuras");
		}

		double totalArea = 0;

		for (Figura f : listaFiguras) {
			totalArea += f.calcularArea();
		}
		return totalArea;
	}

	public void pintarGrupo(Pomo pomo) throws Exception {

		if (!listaFiguras.isEmpty() && !pomo.estaVacio()) {
			for (Figura f : listaFiguras) {
				f.pintar(pomo);
			}
		} else {
			throw new Exception("No se puede pintar, si no dispone de las figuras para armarla");
		}
	}

	public int calcularCantPomos() throws Exception {
		return (int) ((calcularArea() + Pomo.CAPACIDAD_TOTAL - 1) / Pomo.CAPACIDAD_TOTAL);
	}
}
