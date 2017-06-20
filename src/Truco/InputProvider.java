
package Truco;

import java.io.InputStream;
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
				Scanner scanner = new Scanner(readFrom);
				System.in.skip(System.in.available());
				returnable = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Por favor, Ingrese un valor entero");
				valid = false;
			}
		}while(!valid);	
		return returnable;
	}
	
	public String getStringInput() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.in.skip(System.in.available());
		String returnable;
		returnable = scanner.nextLine();
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
