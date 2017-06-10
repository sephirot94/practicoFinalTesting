package Truco;

import junit.framework.TestCase;

public class TestJugador extends TestCase {

	private Jugador j1;
	private Jugador pc1;
	
	public void setUp() {
		j1 = new Jugador("j1");
		pc1 = new Jugador(1);
	}

	public void testGetNombre() {
		assertEquals("j1", j1.getNombre());
		assertEquals("Computadora", pc1.getNombre());
	}
	
	public void testSetNombre() {
		j1.setNombre("pepe");
		assertEquals("pepe", j1.getNombre());
	}
	
	public void testGetDificultad() {
		assertEquals(0, j1.getDificultad().intValue());
		assertEquals(1, pc1.getDificultad().intValue());
	}
	
	public void testSetDificultad() {
		pc1.setDificultad(2);
		assertEquals(2,pc1.getDificultad().intValue());
	}
	
	public void testGetValorLimiteEnvido() {
		pc1 = new Jugador(2);
		assertEquals(25, pc1.getValorLimiteEnvido().intValue());
	}
	
	public void testSetValorLimiteEnvido() {
		pc1.setValorLimiteEnvido(5);
		assertEquals(5, pc1.getValorLimiteEnvido().intValue());
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
	
	public void testTieneEnvido() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		Carta carta2 = new Carta(10,Palo.copa);
		carta2.setValor(10);
		Carta carta3 = new Carta(3,Palo.oro);
		carta3.setValor(3);
		Mano m = new Mano(carta1,carta2,carta3);
		j1.setMano(m);
		j1.setValorLimiteEnvido(27);
		assertFalse(j1.tieneEnvido());
	}
	
	public void testTieneTruco() {
		assertTrue(j1.tieneTruco());
	}
	
}