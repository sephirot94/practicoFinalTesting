package Truco;

import junit.framework.TestCase;

public class TestPuntos extends TestCase {
	
	private Puntos puntos;
	
	public void setUp() {
		puntos = new Puntos();
	}
	
	public void testGetPuntos(){
		assertEquals(0,puntos.getPuntos().intValue());
	}
	
	public void testSetPuntos() {
		puntos.setPuntos(20);
		assertEquals(20,puntos.getPuntos().intValue());
	}
	
	public void testSumarPuntos() {
		puntos.sumarPuntos(10);
		puntos.sumarPuntos(15);
		assertEquals(25, puntos.getPuntos().intValue());
	}

}
