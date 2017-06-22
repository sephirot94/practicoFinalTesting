package Truco;

import junit.framework.TestCase;

public class TestJugador extends TestCase {

	private Jugador j1;
	private Jugador pc1;
	
	public void setUp() {
		j1 = new Jugador("j1");
		pc1 = new Jugador();
	}

	public void testGetNombre() {
		assertEquals("j1", j1.getNombre());
		assertEquals("Computadora", pc1.getNombre());
	}
	
	public void testSetNombre() {
		j1.setNombre("pepe");
		assertEquals("pepe", j1.getNombre());
	}
	
	public void testGetMano() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Mano m = new Mano(carta1,carta2,carta3);
		j1.setMano(m);
		assertEquals(m, j1.getMano());
	}
	
	public void testSetMano() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Mano m = new Mano(carta1,carta2,carta3);
		j1.setMano(m);
		assertEquals(m, j1.getMano());
	}
	
	public void testGetSoyPie() {
		j1.setSoyPie(Boolean.TRUE);
		assertTrue(j1.getSoyPie());
	}
	
	public void testSetSoyPie() {
		j1.setSoyPie(Boolean.FALSE);
		assertFalse(j1.getSoyPie());
	}
	
	public void testRecibirMano() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Mano m = new Mano(carta1,carta2,carta3);
		j1.recibirMano(m);
		assertEquals(m, j1.getMano());
	}
	
	public void testJugarCarta() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Mano m = new Mano(carta1,carta2,carta3);
		j1.recibirMano(m);		
		assertEquals(carta1, j1.jugarCarta(0));
	}
	
	public void testSosPie() {
		j1.sosPie();
		assertTrue(j1.getSoyPie());
	}
	
}