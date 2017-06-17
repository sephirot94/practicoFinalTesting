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
		Mazo mazo = new Mazo();
		Menu menu = new Menu();
		Juego.setFin(false);
		Integer cantidad_jugadores = menu.menuInicial();
		String nombre_jugador = menu.menuNombre();
		Equipo equipo_jugador = new Equipo(cantidad_jugadores, nombre_jugador);
		Equipo equipo_oponente = new Equipo(cantidad_jugadores);
		do{
			mazo.mezclarMazo();
			Ronda ronda = new Ronda();
			Integer posicion = 0;
			for(Jugador jugador : equipo_jugador.getIntegrantes()){
				Mano mano = new Mano(mazo.getMazo().get(posicion), mazo.getMazo().get(posicion + 1), mazo.getMazo().get(posicion + 2));
				jugador.setMano(mano);
				posicion+= 3;
			}
			for(Jugador jugador : equipo_oponente.getIntegrantes()){
				Mano mano = new Mano(mazo.getMazo().get(posicion), mazo.getMazo().get(posicion + 1), mazo.getMazo().get(posicion + 2));
				jugador.setMano(mano);
				posicion+= 3;
			}
			menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
			menu.menuFinal();
		}while(!Juego.getFin());
	} 
	
}
