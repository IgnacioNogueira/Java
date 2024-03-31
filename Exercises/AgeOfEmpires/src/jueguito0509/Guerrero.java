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

		int difDanioRecibido = this.armor - danio;

		if (difDanioRecibido >= 0) {
			this.armor -= danio;
		} else {
			this.armor = 0;
			this.hp = Math.max(this.hp - Math.abs(difDanioRecibido), 0);
		}
	}

	protected void gastarStamina(int cantEstamina) {
		if (cantEstamina <= this.stamina) {
			this.stamina = Math.max(this.stamina - cantEstamina, 0);
		}
	}

	protected void recuperarStamina(int cantEstamina, int cantMaxPermitido) {
		if (cantMaxPermitido <= cantEstamina) {
			if (this.stamina > 0) {
				int cantARecargar = cantEstamina - this.stamina;
				this.stamina += cantARecargar;
			} else {
				this.stamina = cantEstamina;
			}
		}
	}

	protected abstract void atacar(Unidad otro);
}
