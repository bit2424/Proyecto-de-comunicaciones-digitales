package ModeloTests;

import org.junit.Test;

import Modelo.Imagen;

public class ImageTest {
	
	@Test
	public void test1ComputerImage() {
		System.out.println("\n\n//////////////////////////////////////// TEST READ IMAGE 1 ////////////////////////////////////////");
		Imagen im = new Imagen("src\\resources\\images\\img 1.PNG");
		String val = im.getBinInformation();
		System.out.println("Here: "+val);
	}
	
	@Test
	public void test2OnlineImage() {
		System.out.println("\n\n//////////////////////////////////////// TEST READ IMAGE 2 ////////////////////////////////////////");
		Imagen im = new Imagen("https://media.caradvice.com.au/image/private/c_fill,q_auto,f_auto,w_400,ar_16:9/nccvjom7pgi5jolixcza.jpg");
		String val = im.getBinInformation();
		System.out.println("Here: "+val);
	}
	
}
