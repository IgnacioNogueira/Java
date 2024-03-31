package edu.unlam.paradigmas.mario;

public class Mario {
	private Estado estado = new Mini();

	public void comerHongo() {
		this.estado = estado.comerHongo();
	}

	public void tocarFlor() {
		this.estado = estado.tocarFlor();
	}

	public void recibirDanio() {
		this.estado = estado.recibirDanio();
	}
}
