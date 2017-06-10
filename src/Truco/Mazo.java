package Truco;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	
	public ArrayList<Carta> mazo;
	
	public Mazo(){
		this.setMazo(new ArrayList<Carta>());
		
		for(int i = 1; i<=7 ; i++){
			Carta carta = new Carta(i, Palo.basto);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.espada);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.oro);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.copa);
			this.agregarCarta(carta);	
		}
		
		for(int i = 10;i<=12;i++){
			Carta carta = new Carta(i, Palo.basto);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.espada);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.oro);
			this.agregarCarta(carta);
			carta = new Carta(i, Palo.copa);
			this.agregarCarta(carta);	
		}
		
		this.darValores();
	}

	public ArrayList<Carta> getMazo() {
		return mazo;
	}

	public void setMazo(ArrayList<Carta> mazo) {
		this.mazo = mazo;
	}
	
	public void agregarCarta(Carta carta) {
		this.getMazo().add(carta);
	}
	
	public Carta retirarCarta(Integer indice, ArrayList<Carta> mazo){
		if(!mazo.isEmpty() && mazo.size() > indice){
			return mazo.get(indice);
		}
		return null;
	}
	
	public void mezclarMazo(){
		Collections.shuffle(this.getMazo());
	}
	
	public void darValores(){
		for(Carta carta : this.getMazo()){
			if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.espada)){
				carta.setValor(100);
				continue;
			}
			if(carta.getNumero().equals(1) && carta.getPalo().equals(Palo.basto)){
				carta.setValor(90);
				continue;
			}
			if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.espada)){
				carta.setValor(80);
				continue;
			}
			if(carta.getNumero().equals(7) && carta.getPalo().equals(Palo.oro)){
				carta.setValor(70);
				continue;
			}
			if(carta.getNumero().equals(3)){
				carta.setValor(30);
			}
			if(carta.getNumero().equals(2)){
				carta.setValor(20);
			}
			if(carta.getNumero().equals(1)){
				carta.setValor(13);
			}
			if(carta.getNumero().equals(12)){
				carta.setValor(12);
			}
			if(carta.getNumero().equals(11)){
				carta.setValor(11);
			}
			if(carta.getNumero().equals(10)){
				carta.setValor(10);
			}
			if(carta.getNumero().equals(7)){
				carta.setValor(4);
			}
			if(carta.getNumero().equals(6)){
				carta.setValor(3);
			}
			if(carta.getNumero().equals(5)){
				carta.setValor(2);
			}
			if(carta.getNumero().equals(4)){
				carta.setValor(1);
			}
		}
	}
}
