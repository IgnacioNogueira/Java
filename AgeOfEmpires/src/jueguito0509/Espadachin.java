package jueguito0509;

public class Espadachin extends Guerrero {

	private static final int HP_ESP = 100;
	private static final int ATAQUE_ESP = 10;
	private static final double DIST_MAX_ATAQUE_ESP = 1.0; // son las particularidades

	public Espadachin(String nombre, String equipo, Punto ubicacion, int monedasOro, int armor, int stamina)
			throws Exception {
		super(HP_ESP, nombre, equipo, ubicacion, monedasOro, armor, stamina);
	}

	@Override
	protected void atacar(UnidadBase otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && otro.sigueEnPie() && this.sigueEnPie()
				&& getDistanciaAOtro(otro.getUbicacion()) <= DIST_MAX_ATAQUE_ESP) {
			otro.recibirDanio(ATAQUE_ESP);
		}
	}
}
