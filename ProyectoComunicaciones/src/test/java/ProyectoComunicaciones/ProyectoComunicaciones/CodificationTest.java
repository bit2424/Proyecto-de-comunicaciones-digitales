package ProyectoComunicaciones.ProyectoComunicaciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Codificacion;
import Modelo.Imagen;

public class CodificationTest {
	
	Imagen im;
	String info;
	Codificacion codificador;
	Codificacion codificador2;
	String mensaje;
	
	void Scene1() {
		im = new Imagen("C:\\Users\\nelso\\ProyectoComunicaciones\\src\\resources\\images\\img 1.PNG");
	}
	
	void Scene2() {
		mensaje = new String("como coco");
	}
	
	@Test
	public void testRLEAlgorithm() {
		Scene1();
		codificador = new Codificacion(im.getBinInformation(), 0);
		codificador.codificarRLE();
		//System.out.println(codificador.getMensajeCodificado());
		
	}
	
	@Test
	public void testLZW() {
		Scene2();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarLZW();
		System.out.println(codificador.getMensajeCodificado());
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarLZW();
		System.out.println(codificador2.getMensajeOriginal());

	}

}
