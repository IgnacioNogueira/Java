package jueguito0509;

public class Espadachin extends Guerrero {

	private static final int HP_ESPADACHIN = 100;
	private static final int STAMINA_ESPADACHIN = 50;
	private static final int ATAQUE_ESPADACHIN = 10;
	private static final double DIST_MAX_ATAQUE_ESPADACHIN = 1.0; // son las particularidades
	private static final int DESGASTE_STAMINA_ATAQUE_ESPADACHIN = 30; // son las particularidades

	public Espadachin(String nombre, String equipo, Punto ubicacion, int monedasOro, int armor, int stamina)
			throws Exception {
		super(HP_ESPADACHIN, nombre, equipo, ubicacion, monedasOro, armor, STAMINA_ESPADACHIN);
	}

	@Override
	protected void atacar(Unidad otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && otro.sigueEnPie() && this.sigueEnPie()
				&& this.getDistanciaAOtro(otro.getUbicacion()) <= DIST_MAX_ATAQUE_ESPADACHIN
				&& this.getStamina() >= DESGASTE_STAMINA_ATAQUE_ESPADACHIN) {
			this.gastarStamina(DESGASTE_STAMINA_ATAQUE_ESPADACHIN);
			otro.recibirDanio(ATAQUE_ESPADACHIN);
		}
	}
}
