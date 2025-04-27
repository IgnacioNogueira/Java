package edu.unlam.paradigmas.mario;

public class Mini extends Estado{
	
	@Override 
	public String toString() {
		return "Mini";
	}

	@Override
	public Estado comerHongo() {
		return new Hongo();
	}

	@Override
	public Estado tocarFlor() {
		return new Hongo();
	}

	@Override
	public Estado recibirDanio() {
		return new Muerto();
	}	
}
