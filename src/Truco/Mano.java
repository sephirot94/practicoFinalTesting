package Truco;

import java.util.ArrayList;

public class Mano {
	
	private ArrayList<Carta> mano;
	private Boolean flor;
	private Integer valorMano;
	
	public Mano(Carta carta1, Carta carta2, Carta carta3){		
		this.setMano(new ArrayList<Carta>());
		this.agregarCarta(carta1);
		this.agregarCarta(carta2);
		this.agregarCarta(carta3);
		this.setFlor(hayFlor());
		this.setValorMano(this.calcularValorMano());
	}
	
	public void agregarCarta(Carta carta){
		this.getMano().add(carta);		
	}
	
	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public Boolean getFlor() {
		return this.flor;
	}

	public void setFlor(Boolean flor) {
		this.flor = flor;
	}
	
	public Integer getValorMano() {
		return this.valorMano;
	}

	public void setValorMano(Integer valorMano) {
		this.valorMano = valorMano;
	}

	public static Integer getHighestNum(ArrayList<Carta> mano){
		Integer num = 0;
		for(Carta carta : mano){
			if(carta.getNumero() > num  && carta.getNumero() < 10){
				num = carta.getNumero();				
			}
		}
		return num;
	}
	
	public static Integer getPosicionCartaMayorValor(Mano mano) {
		Integer posicion = 0;
		for(int i=0;i<mano.getMano().size();i++) {
			if(mano.getMano().get(i).getValor() > mano.getMano().get(posicion).getValor())
				posicion = i;
		}
		return posicion;
	}
	
	public Boolean hayFlor(){
		if(this.getMano().get(0).getPalo().equals(this.getMano().get(1).getPalo()) && this.getMano().get(0).getPalo().equals(this.getMano().get(2).getPalo())){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Integer contraFlor(){
		Integer tanto = 20;
		if(this.getFlor() == Boolean.TRUE){
			for(Integer i = 0; i < 3; i++){
				if(this.getMano().get(i).getNumero() <= 7 ){
					tanto += this.getMano().get(i).getNumero();
				}
			}
			return tanto;
		}
		return 0;
	}
	
	public Integer envido(){
		Integer envido;
		if(this.getMano().get(0).getPalo().equals(this.getMano().get(1).getPalo())){
			envido = 20 + this.getMano().get(0).getNumero() + this.getMano().get(1).getNumero();
		}
		else if(this.getMano().get(0).getPalo().equals(this.getMano().get(2).getPalo())){
			envido = 20 + this.getMano().get(0).getNumero() + this.getMano().get(2).getNumero();
		}
		else if(this.getMano().get(1).getPalo().equals(this.getMano().get(2).getPalo())){
			envido = 20 + this.getMano().get(1).getNumero() + this.getMano().get(2).getNumero();
		}
		else{
			ArrayList<Carta> lista_auxiliar = new ArrayList<Carta>();
			for(Carta carta : this.getMano()){
				if(!carta.esFigura(carta)){
					lista_auxiliar.add(carta);
				}
			}
			if(!lista_auxiliar.isEmpty()){
				envido = getHighestNum(lista_auxiliar);
			}
			else{
				return 0;
			}
		}
		return envido;
	}
	
	public Integer calcularValorMano(){
		Integer suma = 0;
		for(Carta carta : this.getMano()){
			suma += carta.getValor();
		}
		return suma;
	}

	
}
