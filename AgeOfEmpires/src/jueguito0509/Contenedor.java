package jueguito0509;

public abstract class Contenedor extends UnidadBase {

	protected int cuposTotales;
	protected int cuposDisponibles;

	public Contenedor(int hp, String nombre, String equipo, Punto ubicacion, int cuposTotales, int cuposDisponibles)
			throws Exception {
		super(hp, nombre, equipo, ubicacion);
		// TODO Auto-generated constructor stub
	}

}
