
public class Puntos {
	
	private Integer puntos;
	
	public Puntos(Integer puntos){
		this.setPuntos(puntos);
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
