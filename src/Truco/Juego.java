package Truco;

public class Juego {

	public static Boolean fin;

	public static Boolean getFin() {
		return fin;
	}

	public static void setFin(Boolean fin) {
		Juego.fin = fin;
	}

	public static void main(String[] args)throws Exception{
		Mazo mazo = new Mazo();
		Menu menu = new Menu();
		InputProvider input = new InputProvider();
		Juego.setFin(false);
		Integer cantidad_jugadores = menu.menuInicial();
		String nombre_jugador = menu.menuNombre();
		Equipo equipo_jugador = new Equipo(cantidad_jugadores, nombre_jugador);
		Equipo equipo_oponente = new Equipo(cantidad_jugadores);
		Jugador user = equipo_jugador.getIntegrantes().get(0);
		do {
			mazo.mezclarMazo();
			Ronda ronda = new Ronda();
			Integer posicion = 0;
			for (Jugador jugador : equipo_jugador.getIntegrantes()) {
				Mano mano = new Mano(mazo.getMazo().get(posicion), mazo.getMazo().get(posicion + 1),
						mazo.getMazo().get(posicion + 2));
				jugador.setMano(mano);
				posicion += 3;
			}
			for (Jugador jugador : equipo_oponente.getIntegrantes()) {
				Mano mano = new Mano(mazo.getMazo().get(posicion), mazo.getMazo().get(posicion + 1),
						mazo.getMazo().get(posicion + 2));
				jugador.setMano(mano);
				posicion += 3;
			}
			for(Integer i=0;i<3;i++){
				menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
				Integer carta = input.getIntegerInput();
				user.jugarCarta(carta);
				equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano()));
				equipo_jugador.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_jugador.getIntegrantes().get(1).getMano()));
				equipo_oponente.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(1).getMano()));
			}
			menu.menuFinal();
		} while (!Juego.getFin());
	}

}
