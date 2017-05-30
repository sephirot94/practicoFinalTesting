import java.util.LinkedList;

public class Equipo {
	String nombre;
	LinkedList<Jugador> integrantes;
	Carta cartaGanadoraEquipo;
	Puntos puntos;
	
	public Equipo(String nombre){
		this.setNombre(nombre);
		this.getPuntos().setPuntos(0);
		this.setCartaGanadoraEquipo(null);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Jugador> getIntegrantes() {
		return this.integrantes;
	}
	public void setIntegrantes(LinkedList<Jugador> integrantes) {
		this.integrantes = integrantes;
	}
	public Carta getCartaGanadoraEquipo() {
		return this.cartaGanadoraEquipo;
	}
	public void setCartaGanadoraEquipo(Carta cartaGanadoraEquipo) {
		this.cartaGanadoraEquipo = cartaGanadoraEquipo;
	}
	public Puntos getPuntos() {
		return this.puntos;
	}
	public void setPuntaje(Puntos puntos) {
		this.puntos = puntos;
	}
	
	public void agregarJugador(Jugador jugador){
		this.getIntegrantes().add(jugador);
	}
	
}