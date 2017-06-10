package Truco;

import junit.framework.TestCase;

public class TestCarta extends TestCase {

	private Carta carta;

	public void testGetPalo() {
		carta = new Carta(10,Palo.basto);
		assertEquals(Palo.basto,carta.getPalo());
	}

	public void testSetPalo() {
		carta = new Carta(10,Palo.basto);
		carta.setPalo(Palo.copa);
		assertEquals(Palo.copa,carta.getPalo());
	}

	public void testGetNumero() {
		carta = new Carta(10,Palo.basto);
		assertEquals(10, carta.getNumero().intValue());
	}

	public void testSetNumero() {
		carta = new Carta(10,Palo.basto);
		carta.setNumero(7);
		assertEquals(7, carta.getNumero().intValue());
	}

	public void testSetValor() {
		carta = new Carta(10,Palo.basto);
		carta.setValor(30);
		assertEquals(30, carta.getValor().intValue());
	}

	public void testGetValor() {
		carta = new Carta(10,Palo.basto);
		carta.setValor(30);
		assertEquals(30, carta.getValor().intValue());
	}


	public void testEsFigura() {
		Carta carta = new Carta(10,Palo.basto);		
		assertTrue(carta.esFigura(carta));
	}

	public void testEsAnchoEspada() {
		Carta carta = new Carta(1,Palo.espada);
		assertTrue(carta.esAnchoEspada(carta));
	}

	public void testEsAnchoBasto() {
		Carta carta = new Carta(1,Palo.basto);
		assertTrue(carta.esAnchoBasto(carta));
	}

	public void testEsSieteEspada() {
		Carta carta = new Carta(7,Palo.espada);
		assertTrue(carta.esSieteEspada(carta));
	}

	public void testEsSieteOro() {
		Carta carta = new Carta(7,Palo.oro);
		assertTrue(carta.esSieteOro(carta));
	}

}