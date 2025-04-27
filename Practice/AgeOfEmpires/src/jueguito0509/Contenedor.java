package jueguito0509;

public abstract class Contenedor extends Unidad {

	protected int cuposTotales;
	protected int cuposDisponibles;

	public Contenedor(int hp, String nombre, String equipo, Punto ubicacion, int cuposTotales) throws Exception {
		super(hp, nombre, equipo, ubicacion);
		this.cuposTotales = cuposTotales;
		this.cuposDisponibles = this.cuposTotales;
	}
	
	protected abstract void resguardar(Persona p);
	protected abstract void desalojar(Persona p);
	public abstract void recibirDanio(int danio);
}
