package UnitTests;

import junit.framework.TestCase;

import java.util.ArrayList;

import Truco.*;

public class TestCarta extends TestCase {
	
	public void testEsFigura() {
		Carta carta = new Carta(10,Palo.basto);		
		assertTrue(carta.getNumero().equals(10) || carta.getNumero().equals(11) || carta.getNumero().equals(12));
	}
	
	public void testEsAnchoEspada() {
		Carta carta = new Carta(1,Palo.espada);
		assertTrue(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.espada));
	}
	
	public void testEsAnchoBasto() {
		Carta carta = new Carta(1,Palo.basto);
		assertTrue(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.basto));
	}
	
	public void testEsSieteEspada() {
		Carta carta = new Carta(7,Palo.espada);
		assertTrue(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.espada));
	}
	
	public void testEsSieteOro() {
		Carta carta = new Carta(7,Palo.oro);
		assertTrue(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.oro));
	}
	
	public void testCompararCartas(){
		
		ArrayList<Carta> mano = new ArrayList<Carta>();
		mano.add(new Carta(5,Palo.basto));
		mano.add(new Carta(10,Palo.copa));
		
		
		for(Carta carta : mano){
			if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.espada)){
				carta.setValor(40);
			}
			if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.basto)){
				carta.setValor(39);
			}
			if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.espada)){
				carta.setValor(38);
			}
			if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.oro)){
				carta.setValor(37);
			}
			if(carta.getNumero().equals(3)){
				carta.setValor(36);
			}
			if(carta.getNumero().equals(2)){
				carta.setValor(35);
			}
			if(carta.getNumero().equals(1)){
				carta.setValor(34);
			}
			if(carta.getNumero().equals(12)){
				carta.setValor(33);
			}
			if(carta.getNumero().equals(11)){
				carta.setValor(32);
			}
			if(carta.getNumero().equals(10)){
				carta.setValor(31);
			}
			if(carta.getNumero().equals(7)){
				carta.setValor(30);
			}
			if(carta.getNumero().equals(6)){
				carta.setValor(29);
			}
			if(carta.getNumero().equals(5)){
				carta.setValor(28);
			}
			if(carta.getNumero().equals(4)){
				carta.setValor(27);
			}
		}
		
		int aux=0;
		if(mano.get(0).getValor() > mano.get(1).getValor()){
			aux=1;
		}
		if(mano.get(0).getValor() < mano.get(1).getValor()){
			aux=2;
		}
		if(mano.get(0).getValor().equals(mano.get(1).getValor())){
			aux=0;
		}
		assertEquals(2, aux);	
	}

}