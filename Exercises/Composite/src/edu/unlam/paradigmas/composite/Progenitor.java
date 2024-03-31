package edu.unlam.paradigmas.composite;

public class Progenitor extends Persona {

	private double dinero = 100;
	private Hijo hijo;

	public Progenitor(String nya, int edad, String sexo, Hijo hijo) {
		super(nya, edad, sexo);
		this.hijo = hijo;
	}

	public void comprarMaterial(double costoMaterial) throws Exception {

		if (costoMaterial > dinero) {
			throw new Exception("No tiene el suficiente dinero para comprarlo");
		}

		this.dinero -= costoMaterial;
	}

}
