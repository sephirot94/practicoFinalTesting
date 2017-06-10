package Truco;

import junit.framework.TestCase;

public class TestMazo extends TestCase {
	
	private Mazo mazo;

	public void setUp() {
		mazo = new Mazo();
	}
	
	public void testGetMazo(){		
		assertEquals(mazo.getMazo(), mazo.getMazo());
	}
	
	public void testSetMazo() {
		mazo.setMazo(new Mazo().getMazo());		
		assertEquals(mazo, mazo);
	}
	
	public void testAgregarCarta() {
		Carta carta1 = new Carta(5,Palo.basto);
		carta1.setValor(5);
		mazo.agregarCarta(carta1);
		assertEquals(carta1, mazo.getMazo().get(40));
	}
	
	public void testRetirarCarta() {
		Carta carta1 = new Carta(12,Palo.copa);
		carta1.setValor(12);
		assertEquals(12, mazo.retirarCarta(39, mazo.getMazo()).getNumero().intValue());
		assertEquals(Palo.copa, mazo.retirarCarta(39, mazo.getMazo()).getPalo());
		assertEquals(12, mazo.retirarCarta(39, mazo.getMazo()).getValor().intValue());
		assertEquals(null, mazo.retirarCarta(40, mazo.getMazo()));
	}
	
	public void testMezclarMazo() {		
		Mazo mazo2 = new Mazo();
		mazo.mezclarMazo();		
		assertNotSame(mazo.getMazo().get(10).getNumero(), mazo2.getMazo().get(10).getNumero());
	}
	
	public void testDarValores() {
		mazo.darValores();
		assertEquals(90, mazo.getMazo().get(0).getValor().intValue());
		assertEquals(100, mazo.getMazo().get(1).getValor().intValue());
		assertEquals(13, mazo.getMazo().get(2).getValor().intValue());
		assertEquals(13, mazo.getMazo().get(3).getValor().intValue());
		
	}

}
