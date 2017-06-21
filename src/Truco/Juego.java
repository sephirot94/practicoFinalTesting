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
		Integer cantidad_jugadores_equipo = menu.menuInicial();
		String nombre_jugador = menu.menuNombre();
		Equipo equipo_jugador = new Equipo(cantidad_jugadores_equipo, nombre_jugador);
		Equipo equipo_oponente = new Equipo(cantidad_jugadores_equipo);
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
			menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
			for(Integer i=0;i<3;i++){
				if(!ronda.getEnvido()) {
					menu.menuEnvido();
					Integer num;
					do{
						num = input.getIntegerInput();
					}while(!input.controladorInput(num, 1, 2));
					if(num == 1) {
						ronda.setEnvido(Boolean.TRUE);
						//Jugar el ENVIDO!!!!!
					}
				}
				if(!ronda.getTruco()) {
					Integer num;
					num = menu.menuCantarTruco();
					if(num == 1){
						ronda.setTruco(Boolean.TRUE);
						Integer aux_num;
						aux_num = menu.menuRespuestaReTruco();	
						if(aux_num == 1){
							ronda.setReTruco(Boolean.TRUE);
						}
						if(aux_num == 2){
							ronda.setReTruco(Boolean.FALSE);
							//Terminar RONDA!!
						}
						if(aux_num == 3){
							ronda.setValeCuatro(Boolean.TRUE);
						}
					}
				}
				if(cantidad_jugadores_equipo == 2){
					System.out.println("Turno de: " + nombre_jugador);
					menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
					Integer carta = input.getIntegerInput();
					user.jugarCarta(carta-1);
					System.out.println("Turno de: Oponente1");
					equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano()));
					System.out.println("Turno de: Compañero");
					equipo_jugador.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_jugador.getIntegrantes().get(1).getMano()));
					System.out.println("Turno de: Oponente2");
					equipo_oponente.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(1).getMano()));
				}
				else{
					System.out.println("Turno de: " + nombre_jugador);
					menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
					Integer carta = input.getIntegerInput();
					user.jugarCarta(carta-1);
					System.out.println("Turno de: Oponente");
					equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano()));
				}
			}
			menu.menuFinal();
		} while (!Juego.getFin());
	}

}
