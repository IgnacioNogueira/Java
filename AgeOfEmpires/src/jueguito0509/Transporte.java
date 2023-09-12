package jueguito0509;

public abstract class Transporte extends Contenedor {

	public Transporte(int hp, String nombre, String equipo, Punto ubicacion, int cuposTotales, int cuposDisponibles)
			throws Exception {
		super(hp, nombre, equipo, ubicacion, cuposTotales, cuposDisponibles);
	}

}
