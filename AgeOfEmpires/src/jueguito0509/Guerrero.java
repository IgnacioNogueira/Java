package jueguito0509;

public abstract class Guerrero extends Persona {

	protected int armor;
	protected int stamina;

	public Guerrero(int hp, String nombre, String equipo, Punto ubicacion, int monedasOro, int armor, int stamina)
			throws Exception {
		super(hp, nombre, equipo, ubicacion, monedasOro);
		this.armor = armor;
		this.stamina = stamina;
	}

	public int getArmor() {
		return this.armor;
	}

	public int getStamina() {
		return this.stamina;
	}

	@Override
	public void recibirDanio(int danio) {

		if (!this.sigueEnPie()) {
			return;
		}

		double difDanioRecibido = this.armor - danio;

		if (difDanioRecibido >= 0) {
			this.armor -= danio;
		} else {
			Math.max(this.hp - difDanioRecibido, 0);
			this.armor = 0;
		}
	}

	protected abstract void atacar(UnidadBase otro);
}
