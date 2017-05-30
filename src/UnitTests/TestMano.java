package UnitTests;

import junit.framework.TestCase;

import java.util.ArrayList;

import Truco.*;

public class TestMano extends TestCase {	

	public void testGetHighestNum() {
		ArrayList<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta(5,Palo.basto));
		mano.add(new Carta(10,Palo.copa));
		mano.add(new Carta(3,Palo.oro));
		int num = 0;
		for(Carta carta : mano){
			if(carta.getNumero() > num  && carta.getNumero() < 10)
				num = carta.getNumero();			
		}		
		assertEquals(5, num);
	}

	public void testHayFlor() {
		ArrayList<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta(5,Palo.oro));
		mano.add(new Carta(10,Palo.oro));
		mano.add(new Carta(3,Palo.oro));
		assertTrue(mano.get(0).getPalo().equals(mano.get(1).getPalo()) && mano.get(0).getPalo().equals(mano.get(2).getPalo()));	
	}

	public void testContraFlor() {
		ArrayList<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta(5,Palo.oro));
		mano.add(new Carta(10,Palo.oro));
		mano.add(new Carta(3,Palo.oro));
		int tanto = 20;
		for(Integer i = 0; i < 3; i++){
			if(mano.get(i).getNumero() <= 7 ){
				tanto += mano.get(i).getNumero();
			}
		}
		assertEquals(28, tanto);
	}
	
	public void testEnvido() {
		ArrayList<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta(5,Palo.basto));
		mano.add(new Carta(10,Palo.copa));
		mano.add(new Carta(3,Palo.basto));
		int envido=0;
		if(mano.get(0).getPalo().equals(mano.get(1).getPalo())){
			envido = 20 + mano.get(0).getNumero() + mano.get(1).getNumero();
		}
		else if(mano.get(0).getPalo().equals(mano.get(2).getPalo())){
			envido = 20 + mano.get(0).getNumero() + mano.get(2).getNumero();
		}
		else if(mano.get(1).getPalo().equals(mano.get(2).getPalo())){
			envido = 20 + mano.get(1).getNumero() + mano.get(2).getNumero();
		}
		else{
			ArrayList<Carta> lista_auxiliar = new ArrayList<Carta>();
			for(Carta carta : mano){
				if(!carta.esFigura(carta)){
					lista_auxiliar.add(carta);
				}
			}			
		}
		assertEquals(28,envido);
	}
	
	public void testTruco() {
		
	}
	
	public void testReTruco() {
		
	}
	
	public void testValeCuatro() {
		
	}

}



