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
		im = new Imagen("src\\resources\\images\\img1.PNG");
	}
	
	void Scene2() {
		mensaje = new String("como coco");
	}
	
	void Scene3() {
		mensaje = new String("a,a,a,a,a,a,e, ,l,a,s, ,r,e,p,e,t,i,c,i,o,n,e,s, ,e,n, ,m,i,s, ,t,r,a,d,u,c,c,i,o,n,e,s");
	}
	
	void Scene4() {
		im2 = new Imagen("src\\resources\\images\\homero.png");
	}
	
	void Scene5() {
		mensaje2 = new String("tres tristes tigres comian trigo");
	}
	
	void Scene6() {
		mensaje = new String("1100011 101100 110000 111011 1101111 101100 110001 111011 1101101 101100 110010");
	}
	
	void Scene7() {
		mensaje = new String("1100011 101100 110000 111011 1101111 101100 110001 111011 1101101 101100 11");
	}
	
	@Test
	public void testCodificacionCodigoLineal1() {
		System.out.println("\n\n//////////////////////////////////////// TEST CL 1 ////////////////////////////////////////");
		Scene6();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarCodigoLineal();
		System.out.println("\nMensaje codificado CL: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado CL: "+codificador.getBitsMensajeCodificado());
		
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarCodigoLineal();
		System.out.println("\nMensaje decodificado codigo CL: "+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado codigo CL: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador.calcularRelacionCompresion());
	}
	
	@Test
	public void testCodificacionCodigoLineal2() {
		System.out.println("\n\n//////////////////////////////////////// TEST CL 2 ////////////////////////////////////////");
		Scene6();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarCodigoLineal();
		System.out.println("\nMensaje codificado CL: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado CL: "+codificador.getBitsMensajeCodificado());
		
		mensaje = codificador.getMensajeCodificado();
		mensaje = "0"+mensaje.substring(1,mensaje.length());
		
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarCodigoLineal();
		System.out.println("\nMensaje decodificado codigo CL: "+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado codigo CL: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador.calcularRelacionCompresion());
	}
	
	@Test
	public void testRLEAlgorithm1() {
		Scene1();
		codificador = new Codificacion(im.getPixInformation(), 0);
		codificador.codificarRLE();
		codificador2 = new Codificacion(codificador.getMensajeCodificado(),1);
		codificador2.decodificarRLE();
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 1 ////////////////////////////////////////");
		
		System.out.println("\nMensaje codificado RLE: "+codificador.getMensajeCodificado().substring(0,2000));
		System.out.println("Bits mensaje codificado RLE: "+codificador.getBitsMensajeCodificado());
		
		System.out.println("\nMensaje decodificado RLE: "+codificador2.getMensajeOriginal().substring(0,2000));
		System.out.println("Bits mensaje decodificado RLE: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
		assertEquals(codificador2.getMensajeOriginal(),im.getPixInformation());
		
	}
	
	@Test
	public void testRLEAlgorith2() {
		Scene3();
		codificador = new Codificacion(mensaje, 0);
		codificador.codificarRLE();
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 2 ////////////////////////////////////////");
		
		System.out.println("\nMensaje codificado RLE: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado RLE: "+codificador.getBitsMensajeCodificado());
		
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarRLE();
		System.out.println("\nMensaje decodificado RLE:"+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado RLE: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	}
	
	@Test
	public void testLZWAlgorithm1() {
		System.out.println("\n\n//////////////////////////////////////// TEST LZW 1 ////////////////////////////////////////");
		Scene2();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarLZW();
		System.out.println("\nMensaje codificado LZW: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado LZW: "+codificador.getBitsMensajeCodificado());
		
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarLZW();
		System.out.println("\nMensaje decodificado LZW: "+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado LZW: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	}
	
	@Test
	public void testRLEAlgorithm3() {
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 3 ////////////////////////////////////////");
		Scene4();
		codificador = new Codificacion(im2.getPixInformation(),0);
		codificador.codificarRLE();
		codificador2 = new Codificacion(codificador.getMensajeCodificado(),1);
		codificador2.decodificarRLE();
		System.out.println("\nMensaje codificado LZW: "+codificador.getMensajeCodificado().substring(0,2000));
		System.out.println("Bits mensaje codificado LZW: "+codificador.getBitsMensajeCodificado());
		
		System.out.println("\nMensaje decodificado LZW: "+codificador2.getMensajeOriginal().substring(0,2000));
		System.out.println("Bits mensaje decodificado LZW: "+codificador2.getBitsMensajeOriginal());

		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	}
	
	@Test
	public void testLZWAlgorithm2() {
		System.out.println("\n\n//////////////////////////////////////// TEST LZW 2 ////////////////////////////////////////");
		Scene5();
		codificador = new Codificacion(mensaje2,0);
		codificador.codificarLZW();
		System.out.println("\nMensaje codificado LZW: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado LZW: "+codificador.getBitsMensajeCodificado());
		
		mensaje = codificador.getMensajeCodificado();
		
		codificador2 = new Codificacion(mensaje, 1);
		codificador2.decodificarLZW();
		
		System.out.println("\nMensaje decodificado LZW: "+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado LZW: "+codificador2.getBitsMensajeOriginal());

		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	}
	
	@Test
	public void codificarDodigoLineal() {
		System.out.println("\n\n//////////////////////////////////////// CODIGO LINEAL ////////////////////////////////////////");
		Scene5();
		codificador = new Codificacion(mensaje2,0);
		codificador.codificarCodigoLineal();
		System.out.println("\nMensaje codificado Lineal: "+codificador.getMensajeCodificado());
		mensaje = codificador.getMensajeCodificado();
		codificador2 = new Codificacion(mensaje,1);
		codificador2.decodificarCodigoLineal();
		System.out.println("\nMensaje decodificado lineal: "+codificador2.getMensajeOriginal());
		
	}
	
	@Test
	public void testRata() {
		System.out.println("\n\n//////////////////////////////////////// RATA, REDUNDANCIA, REDUNDANCIA EN EXCESO ////////////////////////////////////////");
		Scene2();
		codificador = new Codificacion(mensaje,0);
		codificador.codificarLZW();
		System.out.println("\nRata: "+codificador.calcularRata());
		System.out.println("\nRedundancia: "+codificador.calcularRedundancia());
		System.out.println("\nRedundancia en exceso: "+codificador.calcularRedundanciaExceso());
	}

}
