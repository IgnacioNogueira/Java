package jueguito0509;

import java.util.Arrays;

public abstract class Unidad {

	protected int hp; // hay que validar que no se pegue el mismo
	protected String nombre;
	protected String equipo;
	protected Punto ubicacion;

	private static final String[] EQUIPOS_DISPONIBLES = { "Rojo", "Amarillo", "Azul", "Morado", "Negro" };

	public Unidad(int hp, String nombre, String equipo, Punto ubicacion) throws Exception {
		this.hp = validarHp(hp, "No se puede crear una unidad con hp menor a 1"); // validar hp
		this.nombre = nombre;
		this.equipo = validarEquipo(equipo, "No existe el equipo que quiere agregar a la unidad");
		this.ubicacion = ubicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getEquipo() {
		return this.equipo;
	}
	
	private int validarHp(int atributo, String mensaje) throws Exception {
		if (atributo <= 0) {
			throw new Exception(mensaje);
		}
		return atributo;
	}
	
	private String validarEquipo(String atributo, String mensaje) throws Exception {
		if (!Arrays.asList(EQUIPOS_DISPONIBLES).contains(atributo)) {
			throw new Exception(mensaje);
		}
		return atributo;
	}


	protected double getDistanciaAOtro(Unidad otro) {
		return otro.ubicacion.distanciaAotroPunto(this.ubicacion);
	}
	
	protected boolean esEquipoContrario(Unidad otro) {
		return !this.equipo.equals(otro.equipo);
	}


	protected boolean estaVivo(Unidad tipo) {
		return this.hp > 0;
	}

	protected abstract void atacar(Unidad otro);
	
	protected abstract void recibirDanio(int danio);

	/*
	 * public Boolean getEstado() { //puede ser que sea un problema como una
	 * variable mantenible, con la vida está ok return this.estaActivo; }
	 */

}
