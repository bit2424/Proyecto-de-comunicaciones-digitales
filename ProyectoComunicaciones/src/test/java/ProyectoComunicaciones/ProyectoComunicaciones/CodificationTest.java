package ProyectoComunicaciones.ProyectoComunicaciones;

import org.junit.Test;

import Modelo.Codificacion;
import Modelo.Imagen;

public class CodificationTest {
	
	Imagen im;
	String info;
	Codificacion codificador;
	
	void Scene1() {
		im = new Imagen("C:\\Users\\nelso\\ProyectoComunicaciones\\src\\resources\\images\\img 1.PNG");
	}
	
	@Test
	public void testRLEAlgorithm() {
		Scene1();
		codificador = new Codificacion(im.getBinInformation(), 0);
		codificador.codificarRLE();
		System.out.println(codificador.getMensajeCodificado());
		
	}

}
