package Truco;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TestMano extends TestCase {

	private ArrayList<Mano> manos = new ArrayList<>();
	private ArrayList<Integer> expectedValues = new ArrayList<>();

	public void setUp() {
		manos.add(new Mano(new Carta(5,Palo.basto),new Carta(10,Palo.copa),new Carta(3,Palo.oro)));
		manos.add(new Mano(new Carta(5,Palo.basto),new Carta(5,Palo.copa),new Carta(5,Palo.oro)));
		manos.add(new Mano(new Carta(1,Palo.basto),new Carta(7,Palo.copa),new Carta(2,Palo.oro)));
		manos.add(new Mano(new Carta(12,Palo.basto),new Carta(10,Palo.copa),new Carta(11,Palo.oro)));
		manos.add(new Mano(new Carta(2,Palo.basto),new Carta(6,Palo.copa),new Carta(4,Palo.oro)));

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
	
	public void testTruco() {

	}

	public void testReTruco() {

	}

	public void testValeCuatro() {

	}

}