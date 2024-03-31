/**
 * 
 */
package jueguito0509;

import java.util.Arrays;

public abstract class Unidad {
	protected int hp; // hay que validar que no se pegue el mismo
	protected String nombre;
	protected String equipo;
	protected Punto ubicacion;
	public static final String[] EQUIPOS_DISPONIBLES = { "Rojo", "Amarillo", "Azul", "Morado", "Negro" };

	
	public Unidad(int hp, String nombre, String equipo, Punto ubicacion) throws Exception {
		this.hp = validarHp(hp, "No se puede crear una persona con hp menor a 1"); // validar hp
		this.nombre = nombre;
		this.equipo = validarEquipo(equipo, "No existe el equipo que quiere agregar a la persona");
		this.ubicacion = ubicacion;
	}

	public int getHp() {
		return this.hp;
	}
	
	public String getEquipo() {
		return this.equipo;
	}

	public Punto getUbicacion() {
		return this.ubicacion;
	}

	public int validarHp(int hp, String mensaje) throws Exception {
		if (hp <= 0) {
			throw new Exception(mensaje);
		}
		return hp;
	}

	public String validarEquipo(String atributo, String mensaje) throws Exception {
		if (!Arrays.asList(EQUIPOS_DISPONIBLES).contains(atributo)) {
			throw new Exception(mensaje);
		}
		return atributo;
	}

	public double getDistanciaAOtro(Punto p) {
		return p.distanciaAotroPunto(this.ubicacion);
	}

	public boolean esEquipoContrario(Unidad otro) {
		return !this.equipo.equals(otro.equipo);
	}

	public boolean sigueEnPie() {
		return this.hp > 0;
	}

	public abstract void recibirDanio(int danio);

	/*
	 * public Boolean getEstado() { //puede ser que sea un problema como una
	 * variable mantenible, con la vida está ok return this.estaActivo; }
	 */
}
