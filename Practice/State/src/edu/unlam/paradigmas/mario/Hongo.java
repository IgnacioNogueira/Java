package edu.unlam.paradigmas.mario;

public class Hongo extends Estado{ //estado de mario cuando est� grande
	
	@Override 
	public String toString() {
		return "Hongo";
	}

	@Override
	public Estado comerHongo() {
		throw new RuntimeException();
	}

	@Override
	public Estado tocarFlor() {
		throw new RuntimeException();
	}

	@Override
	public Estado recibirDanio() {
		return new Mini();
	}

}