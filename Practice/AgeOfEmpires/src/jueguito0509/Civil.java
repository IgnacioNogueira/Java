package jueguito0509;

public abstract class Civil extends Persona {

	protected int espacioRecursosDisp;
	protected int espacioRecursosAct;

	public Civil(int hp, String nombre, String equipo, Punto ubicacion, int monedasOro, int espacioRecursosDisp)
			throws Exception {
		super(hp, nombre, equipo, ubicacion, monedasOro);
		this.espacioRecursosDisp = validarEspacio(espacioRecursosDisp, "Ingrese correctamente el parámetro de espacio");
		this.espacioRecursosAct = this.espacioRecursosDisp;
	}

	@Override
	public void recibirDanio(int danio) {
		if (!this.sigueEnPie()) {
			return;
		}

		Math.max(this.hp - danio, 0);
	}

	protected void transportar() throws Exception {
		if (espacioRecursosAct == 0) {
			throw new Exception("No se pueden transportar más recursos");
		}

		--this.espacioRecursosDisp;
	}

	public int validarEspacio(int espacio, String mensaje) throws Exception {
		if (espacio <= 0 || espacio > 10) {
			throw new Exception(mensaje);
		}
		return espacio;
	}

}
