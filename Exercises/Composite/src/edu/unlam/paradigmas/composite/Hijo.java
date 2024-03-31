package edu.unlam.paradigmas.composite;

import java.util.ArrayList;

public class Hijo extends Persona {

	private Progenitor progenitor;
	private ArrayList<Pomo> pomosDisponibles;

	public Hijo(String nya, int edad, String sexo, Progenitor progenitor) {
		super(nya, edad, sexo);
		this.progenitor = progenitor;
	}
	
	
	//1 - Debo calcularPomosParaPintar
	//2 - Luego debo ver si el poder cubritorio de los pomos que ya tengo en mi poder, me van a alcanzar
	// 2.1 - en caso de estar llenos, ni siquiera pregunto esto
	// 2.2 hagamos de cuenta que yo persona tengo una cantidad de pomos asignados y comprados.
		  //2.2 en caso de no tenerlos, tengo que comprar más si tengo dinero
			//2.2.1 en caso de no tener dinero, no me debería dejar comprar, por ende, no puedo pintar
	        //2.2.2 en caso de tener dinero, debería comprar, bajar mi dinero disponible y poder pintar

//	protected void pintar(String color) throws Exception {
//
//		if (pomo.estaVacio()) {
//			throw new Exception("No puede pintar la figura " + this.nombre + ", debido a que el pomo " + pomo.getColor()
//					+ "no tiene la capacidad suficiente para cubrir el área. Por favor, compre más pomos de pintura");
//		}
//
//		pomo.utilizarPomo(this.calcularArea());
//	}
}
