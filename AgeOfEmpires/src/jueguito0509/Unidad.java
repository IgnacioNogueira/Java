package jueguito0509;

public interface Unidad {

	public int validarHp(int hp, String msj) throws Exception;

	public String validarEquipo(String equipo, String msj) throws Exception;

	public double getDistanciaAOtro(Punto p);

	public boolean esEquipoContrario(UnidadBase otro);

	public boolean sigueEnPie();

	public abstract void recibirDanio(int danio);

	public static final String[] EQUIPOS_DISPONIBLES = { "Rojo", "Amarillo", "Azul", "Morado", "Negro" };
}
