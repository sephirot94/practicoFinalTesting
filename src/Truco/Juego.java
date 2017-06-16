package Truco;


public class Juego {
	
	public static Boolean fin;
	
	public static Boolean getFin() {
		return fin;
	}

	public static void setFin(Boolean fin) {
		Juego.fin = fin;
	}

	public static void main(String[] args) {
		Juego.setFin(false);
		do{
			Ronda ronda = new Ronda();
			Menu menu = new Menu();
			Integer cantidad_jugadores = menu.menuInicial();
			String nombre_jugador = menu.menuNombre();
			Equipo equipo_jugador = new Equipo(cantidad_jugadores, nombre_jugador);
			Equipo equipo_oponente = new Equipo(cantidad_jugadores);
			menu.menuFinal();
		}while(!Juego.getFin());
		
	} 
	
}
