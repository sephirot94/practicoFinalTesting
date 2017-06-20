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
			for(Integer i=0;i<3;i++){
				if(!ronda.getEnvido()) {
					menu.menuEnvido();
					Integer num;
					do{
						num = input.getIntegerInput();
					}while(!input.controladorInput(num, 1, 2));
					if(num == 1) {
						ronda.setEnvido(Boolean.TRUE);
					}
				}
				if(!ronda.getTruco()) {
					menu.menuCantarTruco();
					Integer num;
					do{
						num = input.getIntegerInput();
					}while(!input.controladorInput(num, 1, 2));
					if(num == 1){
						ronda.setTruco(Boolean.TRUE);
						menu.menuRespuestaReTruco();
						Integer aux_num;
						do{
							aux_num = input.getIntegerInput();
						}while(input.controladorInput(aux_num, 1, 3));
						if(aux_num == 1){
							ronda.setReTruco(Boolean.TRUE);
						}
						if(aux_num == 2){
							ronda.setReTruco(Boolean.FALSE);
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
					System.out.println("Turno de: Openente1");
					equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano()));
					System.out.println("El oponente 1 jugo: " + equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano())).getNumero() + equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano())).getPalo());
					System.out.println("Turno de: Compa�ero");
					equipo_jugador.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_jugador.getIntegrantes().get(1).getMano()));
					System.out.println("El companero jugo: " + equipo_jugador.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_jugador.getIntegrantes().get(1).getMano())).getNumero() + equipo_jugador.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_jugador.getIntegrantes().get(1).getMano())).getPalo());
					System.out.println("Turno de: Oponente2");
					equipo_oponente.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(1).getMano()));
					System.out.println("El oponente 2 jugo: " + equipo_oponente.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(1).getMano())).getNumero() + equipo_oponente.getIntegrantes().get(1).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(1).getMano())).getPalo());
				}
				else{
					System.out.println("Turno de: " + nombre_jugador);
					menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
					Integer carta = input.getIntegerInput();
					user.jugarCarta(carta-1);
					System.out.println("Turno de: Openente");
					equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano()));
					System.out.println("El oponente jugo: " + equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano())).getNumero() + equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano())).getPalo());
				}
			}
			menu.menuFinal();
		} while (!Juego.getFin());
	}

}
