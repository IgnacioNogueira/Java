package jueguito0509;

public class Arquero extends Guerrero {
	private static final int HP_ARQUERO = 35;
	private static final int ARMOR_ARQUERO = 75;
	private static final int STAMINA_ARQUERO = 50;
	private static final int ATAQUE_ARQUERO = 30;
	private static final double DIST_MAX_ATAQUE_ARQUERO = 20.0; // son las particularidades
	private static final int DESGASTE_STAMINA_ATAQUE_ARQUERO = 5; // son las particularidades
	private int cantFlechas;

	public Arquero(String nombre, String equipo, Punto ubicacion, int monedasOro) throws Exception {
		super(HP_ARQUERO, nombre, equipo, ubicacion, monedasOro, ARMOR_ARQUERO, STAMINA_ARQUERO);
		this.cantFlechas = 10;
	}
	
	public int getCantFlechas() {
		return this.cantFlechas;
	}

	@Override
	protected void atacar(Unidad otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && otro.sigueEnPie() && this.sigueEnPie()
				&& this.getDistanciaAOtro(otro.getUbicacion()) <= DIST_MAX_ATAQUE_ARQUERO && this.cantFlechas > 0
				&& this.getStamina() >= DESGASTE_STAMINA_ATAQUE_ARQUERO) {
			this.gastarStamina(DESGASTE_STAMINA_ATAQUE_ARQUERO);
			--this.cantFlechas;
			otro.recibirDanio(ATAQUE_ARQUERO);
		}
	}

}
