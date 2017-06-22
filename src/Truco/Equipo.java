package Truco;

import java.util.LinkedList;

public class Equipo {
	String nombre;
	LinkedList<Jugador> integrantes;
	Carta cartaGanadoraEquipo;
	Puntos puntos;
	
	public Equipo(Integer cantidadJugadores, String nombre){
		this.setIntegrantes(new LinkedList<Jugador>());
		this.setNombre("Equipo de " + nombre);
		this.setPuntos(new Puntos());
		this.setCartaGanadoraEquipo(null);
		this.agregarJugador(new Jugador(nombre));
		if(cantidadJugadores == 2){
			this.agregarJugador(new Jugador());
		}
	}
	
	public Equipo(Integer cantidadJugadores){
		this.setIntegrantes(new LinkedList<Jugador>());
		for(Integer i = 0; i < cantidadJugadores; i++){
			this.agregarJugador(new Jugador());
		}
		this.setPuntos(new Puntos());
		this.setNombre("Computadora");
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
	public void setPuntos(Puntos puntos) {
		this.puntos = puntos;
	}
	
	public void agregarJugador(Jugador jugador){
		this.getIntegrantes().add(jugador);
	}
	
}