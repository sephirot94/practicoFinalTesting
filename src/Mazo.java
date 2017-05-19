import java.util.ArrayList;

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
	}

	public ArrayList<Carta> getMazo() {
		return mazo;
	}
	
	public void agregarCarta(Carta carta) {
		this.getMazo().add(carta);
	}

	public void setMazo(ArrayList<Carta> mazo) {
		this.mazo = mazo;
	}
	
	public Carta retirarCarta(Integer indice, ArrayList<Carta> mazo){
		if(!mazo.isEmpty() && mazo.size() >= indice){
			return mazo.get(indice);
		}
		return null;
	}
	
	//funcion para mezclar el mazo
	public void mezclarMazo(){
		Collections.shuffle(this.getMazo());
	}
	
}
