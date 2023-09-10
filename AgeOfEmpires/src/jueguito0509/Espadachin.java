package jueguito0509;

public class Espadachin extends Unidad {

	private static final int HP_ESP = 100;
	private static final int ATAQUE_ESP = 10;
	private static final double DIST_MAX_ATAQUE_ESP = 1.0; // son las particularidades

	public Espadachin(String nombre, String equipo, Punto ubicacion) throws Exception {
		super(HP_ESP, nombre, equipo, ubicacion);
	}

	@Override
	protected void atacar(Unidad otro) { // atacar a otro si yo tengo vida
		if (this != otro && esEquipoContrario(otro) && estaVivo(otro) && estaVivo(this)
				&& getDistanciaAOtro(otro) <= DIST_MAX_ATAQUE_ESP) {
			otro.recibirDanio(ATAQUE_ESP);
		}
	}

	@Override
	protected void recibirDanio(int danio) {
		Math.max(this.hp - ATAQUE_ESP, 0);
	}
}
