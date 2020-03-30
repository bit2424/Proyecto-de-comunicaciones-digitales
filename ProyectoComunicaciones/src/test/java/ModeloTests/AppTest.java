package ModeloTests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import Modelo.Archivo;
import Modelo.Codificacion;
import Modelo.Imagen;


public class AppTest
{
	Imagen im;
	Codificacion codificador;
	Codificacion codificador2;
	Archivo arc1;
	Archivo arc2;
	
	void Scene1() {
		im = new Imagen("src\\resources\\images\\img1.PNG");
	}
	
	@Test
	public void testRLEAlgorithm1() {
		
		System.out.println("\n\n//////////////////////////////////////// TEST RLE 1 ////////////////////////////////////////");	
		
		Scene1();
		
		
		codificador = new Codificacion(im.getPixInformation(),0);
		codificador.codificarRLE();
		System.out.println("\nMensaje codificado RLE: "+codificador.getMensajeCodificado().substring(0,3000));
		System.out.println("Bits mensaje codificado RLE: "+codificador.getBitsMensajeCodificado());
		String mensajeBin = "";
		try {
			arc1 = new Archivo("src\\resources\\Files");
			arc1.crearArchivoInfoBinaria("TextBin1", codificador.getMensajeCodificado());
			arc1.lecturaArchivo();
			mensajeBin = arc1.getCadena();
			arc1.lecturaArchivoTextoBinario();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nMensaje codificado RLE en binario: "+mensajeBin.substring(0,3000));
		
		codificador2 = new Codificacion(arc1.getCadena(), 1);
		codificador2.decodificarRLE();
		System.out.println("\nMensaje decodificado RLE: "+codificador2.getMensajeOriginal().substring(0,3000));
		System.out.println("Bits mensaje decodificado RLE: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	
		
	}
	
	@Test
	public void testLZWAlgorithm1() {
		System.out.println("\n\n//////////////////////////////////////// TEST LZW 1 ////////////////////////////////////////");	
		try {
			arc1 = new Archivo("src\\resources\\Files\\Text1");
			arc1.lecturaArchivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		codificador = new Codificacion(arc1.getCadena(),0);
		codificador.codificarLZW();
		System.out.println("\nMensaje codificado LZW: "+codificador.getMensajeCodificado());
		System.out.println("Bits mensaje codificado LZW: "+codificador.getBitsMensajeCodificado());
		String mensajeBin = "";
		try {
			arc1 = new Archivo("src\\resources\\Files");
			arc1.crearArchivoInfoBinaria("TextBin1", codificador.getMensajeCodificado());
			arc1.lecturaArchivo();
			mensajeBin = arc1.getCadena();
			arc1.lecturaArchivoTextoBinario();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nMensaje codificado LZW en binario: "+mensajeBin);
		
		codificador2 = new Codificacion(arc1.getCadena(), 1);
		codificador2.decodificarLZW();
		System.out.println("\nMensaje decodificado LZW: "+codificador2.getMensajeOriginal());
		System.out.println("Bits mensaje decodificado LZW: "+codificador2.getBitsMensajeOriginal());
		
		System.out.println("\nRelacion de compresión: "+ codificador2.calcularRelacionCompresion());
	}
    
}
