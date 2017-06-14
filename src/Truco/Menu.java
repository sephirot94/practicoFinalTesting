package Truco;

public class Menu {

	public Menu(){

	}

	public void menuInicial(){
		InputProvider input = new InputProvider();
		Integer dificultad;
		Integer num;
		String nombre;
		System.out.println("Vamos a jugar al truco");
		do{
			System.out.println("Elija cantidad de jugadores: ");
			System.out.println("1) 2 Jugadores");
			System.out.println("2) 4 Jugadores");
			num = input.getIntegerInput();
		}while(input.controladorInput(num, 1, 2));
		do{
			System.out.println("Elija dificultad: ");
			System.out.println("1) Facil");
			System.out.println("2) Medio");
			System.out.println("3) Dificil");
			dificultad = input.getIntegerInput();
		}while(input.controladorInput(dificultad, 1, 3));
		System.out.println("Elija su nombre: ");
		nombre = input.getStringInput();		
		
		Equipo equipo = new Equipo(num, dificultad);		
	}
	
	public void menuFinal() {
		InputProvider input = new InputProvider();
		Integer num1;
		Integer num2;
		do{
			System.out.println("Desea abandonar el juego: ");
			System.out.println("1) Si");
			System.out.println("2) No");
			num1 = input.getIntegerInput();
		}while(input.controladorInput(num1, 1, 2));
		if(num1.equals(1)){
			do {
				System.out.println("Desea guardar la partida antes de cerrar el juego: ");
				System.out.println("1) Si");
				System.out.println("2) No");
				num2 = input.getIntegerInput();
			}while(input.controladorInput(num2, 1, 2));
			if(num2.equals(1)){
				//ejecuta metodo guardaar
				//exit juego
			}
			if(num2.equals(2)){
				//exit juego
			}
		}
		if(num1.equals(2)){
			//Seguir jugando
		}
		
	}



}
