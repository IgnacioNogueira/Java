package edu.unlam.paradigmas.composite;

public abstract class Persona {

	protected String nya;
	protected int edad;
	protected String sexo;
	//private Estado estadoDeAnimo;
	
	public Persona(String nya,int edad, String sexo) {
		this.nya = nya;
		this.edad = edad;
		this.sexo = sexo;
	}
}
