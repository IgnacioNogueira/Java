package jueguito0509;

import java.util.List;

public abstract class Transporte extends Contenedor {
	
	protected int distanciaRecorrida;
	
	
	public Transporte(int hp, String nombre, String equipo, Punto ubicacion, int cuposTotales)
			throws Exception {
		super(hp, nombre, equipo, ubicacion, cuposTotales);
		this.distanciaRecorrida = 0;
	}
	
	protected abstract void subirPersonas(int cantKilometros, List <Persona> personas);
	
	protected void finalizarViaje(int cantKilometros) {
		this.distanciaRecorrida+=cantKilometros;
		
		
	}
	

}
