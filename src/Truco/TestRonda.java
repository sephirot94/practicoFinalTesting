package Truco;

import junit.framework.TestCase;

public class TestRonda extends TestCase {
	
	private Ronda r;
	
	public void setUp() {
		r = new Ronda();
	}
	
	public void testGetEnvido() {
		assertFalse(r.getEnvido());
	}
	
	public void testSetEnvido() {
		r.setEnvido(true);
		assertTrue(r.getEnvido());
	}
	
	public void testGetTruco() {
		assertFalse(r.getTruco());
	}
	
	public void testSetTruco() {
		r.setTruco(true);
		assertTrue(r.getTruco());		
	}
	
	public void testGetReTruco() {
		assertFalse(r.getReTruco());
	}
	
	public void testSetReTruco() {
		r.setReTruco(true);
		assertTrue(r.getReTruco());
	}
	
	public void testGetValeCuatro() {
		assertFalse(r.getValeCuatro());
	}
	
	public void testSetValeCuatro() {
		r.setValeCuatro(true);
		assertTrue(r.getValeCuatro());
	}
	
	public void testGetFlor() {
		assertFalse(r.getFlor());
	}
	
	public void testSetFlor() {
		r.setFlor(true);
		assertTrue(r.getFlor());
	}
	
	public void testTruco() {
		r.truco();
		assertTrue(r.getTruco());
	}
	
	public void testReTruco() {
		r.reTruco();
		assertTrue(r.getReTruco());
	}
	
	public void testValeCuatro() {
		r.valeCuatro();
		assertTrue(r.getValeCuatro());
	}
	
	public void testCompararCartas() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		assertEquals("ganador carta 2", r.compararCartas(carta1, carta2));
		carta2.setValor(5);
		carta1.setValor(10);
		assertEquals("ganador carta 1", r.compararCartas(carta1, carta2));
		carta1.setValor(carta2.getValor());
		assertEquals("empate", r.compararCartas(carta1, carta2));		
	}

}
