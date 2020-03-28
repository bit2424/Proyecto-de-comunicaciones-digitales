package ModeloTests;

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
	Imagen im2;
	String mensaje2;
	
	void Scene1() {
		im = new Imagen("src\\resources\\images\\img 1.PNG");
	}
	
	void Scene2() {
		mensaje = new String("como coco");
		System.out.println("Mensaje Original: "+ mensaje);
	}
	
	void Scene3() {
		mensaje = new String("a,a,a,a,a,a,e, ,l,a,s, ,r,e,p,e,t,i,c,i,o,n,e,s, ,e,n, ,m,i,s, ,t,r,a,d,u,c,c,i,o,n,e,s");
		System.out.println("Mensaje Original: "+ mensaje);
	}
	
	void Scene4() {
		im2 = new Imagen("src\\resources\\images\\homero.png");
	}
	
	void Scene5() {
		mensaje2 = new String("tres tristes tigres comian trigo");
	}
	
	@Test
	public void testRLEAlgorithm1() {
		Scene1();
		codificador = new Codificacion(im.getBinInformation(), 0);
		codificador.codificarRLE();
		codificador2 = new Codificacion(codificador.getMensajeCodificado(),1);
		codificador2.decodificarRLE();
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 1 ////////////////////////////////////////");
		System.out.println("Mensaje codificado RLE: "+codificador.getMensajeCodificado());
		System.out.println("Mensaje decodificado RLE: "+codificador2.getMensajeOriginal());
		assertEquals(codificador2.getMensajeOriginal(),im.getBinInformation());
		
	}
	
	@Test
	public void testRLEAlgorith2() {
		Scene3();
		codificador = new Codificacion(mensaje, 0);
		codificador.codificarRLE();
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 2 ////////////////////////////////////////");
		System.out.println("Mensaje codificado RLE: "+codificador.getMensajeCodificado());
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarRLE();
		System.out.println("Mensaje decodificado RLE:"+codificador2.getMensajeOriginal());
	}
	
	@Test
	public void testLZWAlgorithm1() {
		System.out.println("\n\n//////////////////////////////////////// TEST LZW 1 ////////////////////////////////////////");
		Scene2();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarLZW();
		System.out.println("Mensaje codificado LZW: "+codificador.getMensajeCodificado());
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarLZW();
		System.out.println("Mensaje decodificado LZW: "+codificador2.getMensajeOriginal());

	}
	
	@Test
	public void testRLEAlgorithm3() {
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 3 ////////////////////////////////////////");
		Scene4();
		codificador = new Codificacion(im2.getBinInformation(),0);
		codificador.codificarRLE();
		codificador2 = new Codificacion(codificador.getMensajeCodificado(),1);
		codificador2.decodificarRLE();
		System.out.println("Mensaje codificado LZW: "+codificador.getMensajeCodificado());
		System.out.println("Mensaje decodificado LZW: "+codificador2.getMensajeOriginal());
		
	}
	
	@Test
	public void testLZWAlgorithm2() {
		System.out.println("\n\n//////////////////////////////////////// TEST LZW 2 ////////////////////////////////////////");
		Scene5();
		codificador = new Codificacion(mensaje2,0);
		codificador.codificarLZW();
		System.out.println("Mensaje codificado LZW: "+codificador.getMensajeCodificado());
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarLZW();
		System.out.println("Mensaje decodificado LZW: "+codificador2.getMensajeOriginal());

	}

}
