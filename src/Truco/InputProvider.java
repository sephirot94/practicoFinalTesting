package Truco;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputProvider {

	public InputProvider(){

	}
	
	public Integer getIntegerInput() 
	{
		return getIntegerInput(System.in);
	}

	public Integer getIntegerInput(InputStream readFrom) {	
		Boolean valid = true;
		Integer returnable = null;
		do{
			valid = true;
			try {
				Scanner scanner = new Scanner(System.in);
				returnable = scanner.nextInt();
				scanner.close();
			} catch (Exception e) {
//				System.out.println("Por favor, Ingrese un valor entero");
				System.out.println(e);
				valid = false;
			}
		}while(!valid);	
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
