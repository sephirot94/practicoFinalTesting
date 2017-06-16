package Truco;


public class Puntos {
	
	private Integer puntos;
	
	public Puntos(){
		
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	public void sumarPuntos(Integer puntos){
		this.setPuntos(this.getPuntos() + puntos);
	}
	
}
