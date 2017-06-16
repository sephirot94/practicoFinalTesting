package Truco;

import java.util.Random;

public class Jugador {

	private String nombre;
	private Mano mano;
	private Boolean soyPie;

	public Jugador(String nombre){
		this.setNombre(nombre);
	}

	public Jugador(){
		this.setNombre("Computadora");
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Mano getMano() {
		return this.mano;
	}

	public void setMano(Mano mano) {
		this.mano = mano;
	}

	public Boolean getSoyPie() {
		return this.soyPie;
	}

	public void setSoyPie(Boolean soyPie) {
		this.soyPie = soyPie;
	}

	public void recibirMano(Mano mano){
		this.setMano(mano);
	}

	public Carta jugarCarta(int posicion){
		return this.getMano().getMano().remove(posicion);
	}

	public void sosPie(){
		this.setSoyPie(Boolean.TRUE);
	}

	public Boolean cantarEnvido(){
		Integer limite = 20;
		limite += new Random().nextInt(13);
		if(this.getSoyPie() == Boolean.TRUE){
			if(mano.envido() > limite){
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	public void cambiarPie(){
		if(this.getSoyPie()){
			this.setSoyPie(Boolean.FALSE);
		}else{
			this.getSoyPie();
		}
	}

	public Boolean cantarTruco(){
		Integer limite = 20;
		limite += new Random().nextInt(20);
		if(limite< mano.getValorMano()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	

}