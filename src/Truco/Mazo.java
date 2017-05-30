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
		if(!mazo.isEmpty() && mazo.size() >= indice){
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
	}
}
