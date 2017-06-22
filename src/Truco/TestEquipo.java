package Truco;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestEquipo extends TestCase {
	
	private Equipo equipo;
	
	public void setUp(){		
		equipo = new Equipo(4,"Test");		
	}
	
	public void testGetNombre() {
		assertEquals("Test", equipo.getNombre());
	}
	
	public void testSetNombre() {
		equipo.setNombre("nombre");
		assertEquals("nombre", equipo.getNombre());
	}
	
	public void testGetIntegrantes() {
		assertEquals(null, equipo.getIntegrantes());
	}
	
	public void testSetIntegrantes() {
		LinkedList<Jugador> integrantes = new LinkedList<Jugador>();
		integrantes.add(new Jugador("a"));
		integrantes.add(new Jugador("b"));
		equipo.setIntegrantes(integrantes);
		assertEquals(integrantes, equipo.getIntegrantes());
	}
	
	public void testGetCartaGanadoraEquipo() {
		assertEquals(null, equipo.getCartaGanadoraEquipo());
	}
	
	public void testSetCartaGanadoraEquipo() {
		Carta carta = new Carta(7,Palo.espada);
		equipo.setCartaGanadoraEquipo(carta);
		assertEquals(carta, equipo.getCartaGanadoraEquipo());
	}
	
	public void testGetPuntos() {
		Puntos puntos = new Puntos();
		equipo.setPuntos(puntos);
		assertEquals(puntos, equipo.getPuntos());
	}

	public void testSetPuntaje() {
		Puntos puntos = new Puntos();
		equipo.setPuntos(puntos);
		assertEquals(puntos, equipo.getPuntos());
	}
	
	public void testAgregarJugador() {
		LinkedList<Jugador> integrantes = new LinkedList<Jugador>();
		integrantes.add(new Jugador("a"));
		integrantes.add(new Jugador("b"));
		equipo.setIntegrantes(integrantes);
		Jugador jugador = new Jugador("a");
		equipo.agregarJugador(jugador);
		assertEquals(jugador, equipo.getIntegrantes().getLast());
	}	
	
}