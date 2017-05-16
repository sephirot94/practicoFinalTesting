import java.util.ArrayList;

public class Mazo {
	
	public ArrayList<Carta> mazo;
	
	public Mazo(){
		
		for(int i = 1; i<=7 ; i++){
			Carta carta = new Carta(i, Palo.basto);
			this.setMazo(carta);
			carta = new Carta(i, Palo.espada);
			this.setMazo(carta);
			carta = new Carta(i, Palo.oro);
			this.setMazo(carta);
			carta = new Carta(i, Palo.copa);
			this.setMazo(carta);	
		}
		
		for(int i = 10;i<=12;i++){
			Carta carta = new Carta(i, Palo.basto);
			this.setMazo(carta);
			carta = new Carta(i, Palo.espada);
			this.setMazo(carta);
			carta = new Carta(i, Palo.oro);
			this.setMazo(carta);
			carta = new Carta(i, Palo.copa);
			this.setMazo(carta);	
		}
	}

	public ArrayList<Carta> getMazo() {
		return mazo;
	}

	public void setMazo(Carta carta) {
		this.mazo.add(carta);
	}
	
	public void mezclarMazo(ArrayList<Carta> mazo){
		
	}
	
	public Carta retirarCarta(Integer indice, ArrayList<Carta> mazo){
		if(!mazo.isEmpty() && mazo.size() >= indice){
			return mazo.get(indice);
		}
		return null;
	}
	
}
