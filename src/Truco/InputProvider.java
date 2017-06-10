package Truco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputProvider {

	public InputProvider(){

	}

	public Integer getIntegerInput(){
		Scanner scanner = new Scanner(System.in);
		Boolean valid = true;
		Integer returnable = null;
		do{
			try {
				returnable = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, Ingrese un valor entero");
				valid = false;
			}
		}while(valid);
		scanner.close();
		return returnable;
	}
	
	public String getStringInput() {
		Scanner scanner = new Scanner(System.in);
		String returnable;
		returnable = scanner.nextLine();
		scanner.close();
		return returnable;
	}
	
	public Boolean controladorInput(Integer input, Integer piso, Integer techo) {
		if(piso <= input && input <= techo){
			return true;
		}
		else {
			return false;
		}
	}

}
