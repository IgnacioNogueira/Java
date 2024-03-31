package edu.unlam.paradigmas.mario;

public class Muerto extends Estado {

	@Override
	public String toString() {
		return "Muerto";
	}

	@Override
	public Estado comerHongo() {
		return this;
	}

	@Override
	public Estado tocarFlor() {
		return this;
	}

	@Override
	public Estado recibirDanio() {
		return this;
	}
}
