package Truco;

import java.util.Random;

public class Jugador {

	private String nombre;
	//0 para la persona, numeros para los demas
	private Integer dificultad;
	private Mano mano;
	private Boolean soyPie;
	private Integer valorLimiteEnvido;
	
	public Jugador(String nombre){
		this.setNombre(nombre);
		this.setDificultad(0);
	}
	
	public Jugador(Integer dificultad){
		this.setNombre("Computadora");
		this.setDificultad(dificultad);
		if(dificultad == 1){
			this.setValorLimiteEnvido(new Random().nextInt(33));
		}else if(dificultad == 2){
			this.setValorLimiteEnvido(25);
		}else{
			this.setValorLimiteEnvido(27);
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(Integer dificultad) {
		this.dificultad = dificultad;
	}
	
	public Integer getValorLimiteEnvido() {
		return this.valorLimiteEnvido;
	}

	public void setValorLimiteEnvido(Integer valorLimiteEnvido) {
		this.valorLimiteEnvido = valorLimiteEnvido;
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
	
	public Boolean tieneEnvido(){
		if(this.getMano().envido() >= this.getValorLimiteEnvido()){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	
	public Boolean tieneTruco(){
		return Boolean.TRUE;
	}
	
	
}