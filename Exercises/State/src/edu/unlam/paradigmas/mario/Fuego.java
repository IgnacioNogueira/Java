package edu.unlam.paradigmas.mario;

public class Fuego extends Estado{

	@Override 
	public String toString() {
		return "Fuego";
	}

	@Override
	public Estado comerHongo() {
		throw new RuntimeException();
	}

	@Override
	public Estado tocarFlor() {
		return this;
	}

	@Override
	public Estado recibirDanio() {
		return new Mini();
	}
}
