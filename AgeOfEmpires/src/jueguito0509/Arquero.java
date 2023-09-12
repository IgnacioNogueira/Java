package jueguito0509;

public class Arquero extends Guerrero {
	private static final int HP_ARQ = 35;
	private static final int ATAQUE_ARQ = 5;
	private static final double DIST_MAX_ATAQUE_ARQ = 20.0; // son las particularidades
	private int cantFlechas;

	public Arquero(String nombre, String equipo, Punto ubicacion, int monedasOro, int armor, int stamina)
			throws Exception {
		super(HP_ARQ, nombre, equipo, ubicacion, monedasOro, armor, stamina);
	}

	public int getCantFlechas() {
		return this.cantFlechas;
	}

	@Override
	protected void atacar(UnidadBase otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && otro.sigueEnPie() && this.sigueEnPie()
				&& getDistanciaAOtro(otro.getUbicacion()) <= DIST_MAX_ATAQUE_ARQ && getCantFlechas() > 0) {
			otro.recibirDanio(ATAQUE_ARQ);
		}
	}
}
