package Truco;

import junit.framework.TestCase;

public class TestInputProvider extends TestCase {
	
	private InputProvider inputProvider;
	
	public void setUp() {
		inputProvider = new InputProvider();
	}
	
	public void testControladorInput() {		
		Integer[] inputs = {1,-5,100,15,999,-200,0};
		Boolean[] expectedReturn = {true,false,false,true,false,true,true};
		Integer[] piso = {0,1,45,-10,800,-300,0};
		Integer[] techo = {5,-7,-100,30,1,0,1};
		for(int i=0;i<inputs.length;i++){
			assertEquals(expectedReturn[i],inputProvider.controladorInput(inputs[i], piso[i], techo[i]));
		}
	}
	
	public void testGetIntegerInput() {
		Integer[] inputs = {1,-5,100,15,999,-200,0};
		for(int i=0;i<inputs.length;i++) {
			assertEquals(inputs,inputProvider.getIntegerInput(new ArrayInputStream(inputs)));
		}
	}

}
