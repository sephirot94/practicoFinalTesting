package Truco;

public class Menu {

	public Menu(){

	}

	public void menuInicial(){
		System.out.println("Vamos a jugar al truco :");
	}

	public void menuFinal() {
		InputProvider input = new InputProvider();
		Integer num1;
		do{
			System.out.println("Desea seguir jugando: ");
			System.out.println("1) Si");
			System.out.println("2) No");
			num1 = input.getIntegerInput();
		}while(!input.controladorInput(num1, 1, 2));
		if(num1.equals(1)){
			Juego.setFin(false);
		}
		if(num1.equals(2)){
			Juego.setFin(true);
		}

	}
	
	public String menuNombre() throws Exception{
		InputProvider input = new InputProvider();
		System.out.println("Elija su nombre: ");
		return input.getStringInput();
	}

	public Integer menuCantarTruco() {
		InputProvider input = new InputProvider();
		Integer num1;
		do{
			System.out.println("Desea cantar truco?: ");
			System.out.println("1) Si");
			System.out.println("2) No");
			num1 = input.getIntegerInput();
		}while(!input.controladorInput(num1, 1, 2));
		return num1;
	}
	
	public Integer menuRespuestaReTruco() {
		InputProvider input = new InputProvider();
		Integer num1;
		do{
			System.out.println("El oponente canto retruco: ");
			System.out.println("1) Quiero");
			System.out.println("2) No quiero");
			System.out.println("3) Quiero vale 4");
			num1 = input.getIntegerInput();
		}while(!input.controladorInput(num1, 1, 3));
		return num1;
	}
	
	public void menuCartas(Mano cartas) {
		System.out.println("Sus cartas son: ");
		Integer i = 1;
		for(Carta carta : cartas.getMano()) {
			System.out.println(i + ")" + " " + carta.getNumero() + " " + carta.getPalo());
			i++;
		}
	}
	
	public void menuEnvido() {
		System.out.println("Desea cantar envido?: ");
		System.out.println("1) Si");
		System.out.println("2) No");
	}



}
