package Truco;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestEquipo extends TestCase {
	
	private Equipo equipo;
	
	public void setUp(){		
		equipo = new Equipo("Test");		
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
	
	public void testAgregarJugadorPc() {
		LinkedList<Jugador> integrantes = new LinkedList<Jugador>();
		integrantes.add(new Jugador("a"));
		integrantes.add(new Jugador("b"));
		equipo.setIntegrantes(integrantes);
		equipo.agregarJugadorPc(2);
		assertEquals(2, equipo.getIntegrantes().getLast().getDificultad().intValue());
	}
	
	public void testpreguntarEnvido() {
		LinkedList<Jugador> integrantes = new LinkedList<Jugador>();
		Jugador a = new Jugador("a");
		Jugador b = new Jugador("b");
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Carta carta4 = new Carta(5,Palo.copa);
		carta4.setValor(5);
		Carta carta5 = new Carta(5,Palo.oro);
		carta5.setValor(5);
		Carta carta6 = new Carta(1,Palo.basto);
		carta6.setValor(1);
		a.setMano(new Mano( carta1,carta2,carta3));
		b.setMano(new Mano( carta4,carta5,carta6));
		a.setValorLimiteEnvido(28);
		b.setValorLimiteEnvido(28);
		integrantes.add(a);
		integrantes.add(b);		
		equipo.setIntegrantes(integrantes);
		assertFalse(equipo.preguntarEnvido());
	}
	
	public void testPreguntarTruco() {
		LinkedList<Jugador> integrantes = new LinkedList<Jugador>();
		integrantes.add(new Jugador("a"));
		integrantes.add(new Jugador("b"));
		equipo.setIntegrantes(integrantes);
		assertTrue(equipo.preguntarTruco());	
	}
	
}