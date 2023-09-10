package jueguito0509;

public class Arquero extends Unidad {
	private static final int HP_ARQ = 35;
	private static final int ATAQUE_ARQ = 5;
	private static final double DIST_MAX_ATAQUE_ARQ = 20.0; // son las particularidades
	private int cantFlechas;

	public Arquero(String nombre, String equipo, Punto ubicacion) throws Exception {
		super(HP_ARQ, nombre, equipo, ubicacion);
	}

	public int getCantFlechas() {
		return this.cantFlechas;
	}

	@Override
	protected void atacar(Unidad otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && estaVivo(otro) && estaVivo(this)
				&& getDistanciaAOtro(otro) <= DIST_MAX_ATAQUE_ARQ && getCantFlechas() > 0) {
			otro.recibirDanio(ATAQUE_ARQ);
		}
	}

	@Override
	protected void recibirDanio(int danio) {
		Math.max(this.hp - ATAQUE_ARQ, 0);
	}

}
