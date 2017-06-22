package Truco;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TestMano extends TestCase {

	private ArrayList<Mano> manos = new ArrayList<>();
	private ArrayList<Integer> expectedValues = new ArrayList<>();

	public void setUp() {
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
		Carta carta7 = new Carta(7,Palo.copa);
		carta7.setValor(7);
		Carta carta8 = new Carta(2,Palo.oro);
		carta8.setValor(2);
		Carta carta9 = new Carta(12,Palo.basto);
		carta9.setValor(12);
		Carta carta10 = new Carta(11,Palo.oro);
		carta10.setValor(11);
		Carta carta11 = new Carta(2,Palo.basto);
		carta11.setValor(2);
		Carta carta12 = new Carta(6,Palo.copa);
		carta12.setValor(6);
		Carta carta13 = new Carta(4,Palo.oro);
		carta13.setValor(4);
		
		manos.add(new Mano(carta1,carta2,carta3));
		manos.add(new Mano(carta1,carta4,carta5));
		manos.add(new Mano(carta6,carta7,carta8));
		manos.add(new Mano(carta9,carta2,carta10));
		manos.add(new Mano(carta11,carta12,carta13));

		expectedValues.add(5);
		expectedValues.add(5);
		expectedValues.add(7);
		expectedValues.add(0);
		expectedValues.add(6);
	}

	public void testGetHighestNum() {
		for(int i = 0; i < manos.size(); i++)
		{
			assertEquals(expectedValues.get(i),Mano.getHighestNum(manos.get(i).getMano()));
		}
	}

	public void testHayFlor() {
		for(int i = 0; i < manos.size(); i++)
		{
			assertFalse(manos.get(i).hayFlor());
		}
	}

	public void testContraFlor() {		
		for(int i = 0; i < manos.size(); i++)
		{
			assertEquals(0,manos.get(i).contraFlor().intValue());
		}
	}

	public void testEnvido() {
		expectedValues.set(0, 5);
		expectedValues.set(1, 5);
		expectedValues.set(2, 7);
		expectedValues.set(3, 0);
		expectedValues.set(4, 6);
		for(int i = 0; i < manos.size(); i++)
		{
			assertEquals(expectedValues.get(i).intValue(),manos.get(i).envido().intValue());
		}		
	}

	public void testAgregarCarta() {
		manos.get(0).agregarCarta(new Carta(12,Palo.basto));
		assertEquals(12,manos.get(0).getMano().get(3).getNumero().intValue());
	}

	public void testSetMano() {		
		ArrayList<Carta> expectedValue = new ArrayList<Carta>();
		expectedValue.add(new Carta(5,Palo.basto));
		expectedValue.add(new Carta(10,Palo.copa));
		expectedValue.add(new Carta(3,Palo.oro));
		manos.get(0).setMano(expectedValue);
		assertEquals(expectedValue,manos.get(0).getMano());
	}

	public void testGetFlor() {
		for(int i = 0; i < manos.size(); i++)
		{
			assertFalse(manos.get(i).getFlor());
		}
	}

	public void testSetFlor() {
		for(int i = 0; i < manos.size(); i++)
		{
			manos.get(i).setFlor(Boolean.TRUE);
			assertTrue(manos.get(i).getFlor());
		}
	}

	public void testCalcularValorMano() {
		expectedValues.set(0, 18);
		expectedValues.set(1, 15);
		expectedValues.set(2, 10);
		expectedValues.set(3, 33);
		expectedValues.set(4, 12);

		for(int i = 0; i < manos.size(); i++)
		{			
			assertEquals(expectedValues.get(i),(manos.get(i).calcularValorMano()));
		}
	}
}