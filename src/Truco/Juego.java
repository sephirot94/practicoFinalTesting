package Truco;

import java.util.ArrayList;

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
		ArrayList<Carta> array_temporal = new ArrayList<Carta>();
		InputProvider input = new InputProvider();
		Juego.setFin(false);
		menu.menuInicial();
		String nombre_jugador = menu.menuNombre();
		Equipo equipo_jugador = new Equipo(1, nombre_jugador);
		Equipo equipo_oponente = new Equipo(1);
		Jugador user = equipo_jugador.getIntegrantes().get(0);
		do {
			mazo.mezclarMazo();
			Ronda ronda = new Ronda();
			Integer posicion = 0;
			Integer gano_jugador = 0;
			Integer gano_oponente = 0;
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
			System.out.println("Los puntos de " + user.getNombre() + " son: " + equipo_jugador.getPuntos().getPuntos());
			System.out.println("Los puntos del oponente son: " + equipo_oponente.getPuntos().getPuntos());
			for(Integer i=0;i<3;i++){
				array_temporal.clear();
				if(!ronda.getEnvido() && i==0) {									
					menu.menuEnvido();
					Integer num;
					do{
						num = input.getIntegerInput();
					}while(!input.controladorInput(num, 1, 2));
					if(num == 1) {
						ronda.setEnvido(Boolean.TRUE);
						System.out.println(user.getMano().envido());
						System.out.println("Oponente: " + equipo_oponente.getIntegrantes().get(0).getMano().envido());
						if(user.getMano().envido() >= equipo_oponente.getIntegrantes().get(0).getMano().envido()){
							equipo_jugador.getPuntos().sumarPuntos(2);
						}
						else {
							equipo_oponente.getPuntos().sumarPuntos(2);
						}
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
							Juego.setFin(true);
						}
						if(aux_num == 3){
							ronda.setValeCuatro(Boolean.TRUE);
						}
					}
				}
				if(!Juego.getFin()){
					System.out.println("Turno de: " + nombre_jugador);
					menu.menuCartas(equipo_jugador.getIntegrantes().get(0).getMano());
					Integer carta = input.getIntegerInput();
					array_temporal.add(user.jugarCarta(carta-1));
					System.out.println("Turno de: Oponente");
					array_temporal.add(equipo_oponente.getIntegrantes().get(0).jugarCarta(Mano.getPosicionCartaMayorValor(equipo_oponente.getIntegrantes().get(0).getMano())));
					String ganador = Ronda.compararCartas(array_temporal.get(0), array_temporal.get(1));
					if(ganador.equals("ganador carta 1")){
						gano_jugador ++;
					}
					if(ganador.equals("ganador carta 2")){
						gano_oponente ++;
					}
					if(gano_jugador == 2) {
						if(ronda.getValeCuatro()){
							equipo_jugador.getPuntos().sumarPuntos(4);
						}
						else if(ronda.getReTruco()){
							equipo_jugador.getPuntos().sumarPuntos(3);
						}
						else if(ronda.getTruco()){
							equipo_jugador.getPuntos().sumarPuntos(2);
						}
						else {
							equipo_jugador.getPuntos().sumarPuntos(1);
						}
						System.out.println("Ganador de la ronda: " + user.getNombre());
						Juego.setFin(true);
					}
					if(gano_oponente == 2){
						if(ronda.getValeCuatro()){
							equipo_oponente.getPuntos().sumarPuntos(4);
						}
						else if(ronda.getReTruco()){
							equipo_oponente.getPuntos().sumarPuntos(3);
						}
						else if(ronda.getTruco()){
							equipo_oponente.getPuntos().sumarPuntos(2);
						}
						else {
							equipo_oponente.getPuntos().sumarPuntos(1);
						}
						System.out.println("Ganador de la ronda: Oponente");
						Juego.setFin(true);
					}
					
				}
			}
			menu.menuFinal();
		} while (!Juego.getFin());
	}

}
