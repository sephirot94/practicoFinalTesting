
public class Jugador {

	private String nombre;
	//0 para la persona, numeros para los demas
	private Integer dificultad;
	private Mano mano;
	
	public Jugador(String nombre){
		this.setNombre(nombre);
		this.setDificultad(0);
	}
	
	public Jugador(Integer dificultad){
		this.setNombre("Computadora");
		this.setDificultad(dificultad);
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
	
	public Mano getMano() {
		return this.mano;
	}

	public void setMano(Mano mano) {
		this.mano = mano;
	}

	public void recibirMano(Mano mano){
		this.setMano(mano);
	}
	
}