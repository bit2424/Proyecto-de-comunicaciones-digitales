package ModeloTests;

import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import Modelo.Archivo;
import Modelo.Imagen;

public class ArchivoTest {
	Archivo arc1;
	Archivo arc2;
	@Test
	public void openTest1(){
		System.out.println("\n\n//////////////////////////////////////// TEST ABRIR ARCHIVO 1 ////////////////////////////////////////");
		try {
			arc1 = new Archivo("src\\resources\\Files\\Text1");
			arc1.lecturaArchivo();
		} catch (FileNotFoundException e) {
			assertFalse(true);
			e.printStackTrace();
		} catch (IOException e) {
			assertFalse(true);
			e.printStackTrace();
		}
		String val = arc1.getCadena();
		System.out.println("Here: "+val);
	}
	
	@Test
	public void createTest1() {
		System.out.println("\n\n//////////////////////////////////////// TEST CREAR ARCHIVO 1 ////////////////////////////////////////");
		
		try {
			arc1 = new Archivo("src\\resources\\Files");
			arc1.crearArchivo("Text2", "La luna lunar");
			
			arc2 = new Archivo("src\\resources\\Files\\Text2");
			arc2.lecturaArchivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String val = arc2.getCadena();
		System.out.println("Here: "+val);
	}
	
	@Test
	public void openBinTest1(){
		System.out.println("\n\n//////////////////////////////////////// TEST LECTURA ARCHIVO BINARIO 1 ////////////////////////////////////////");
		try {
			arc1 = new Archivo("src\\resources\\Files\\TextBin1");
			arc1.lecturaArchivo();
			arc2 = new Archivo("src\\resources\\Files\\TextBin1");
			arc2.lecturaArchivoTextoBinario();
		} catch (FileNotFoundException e) {
			assertFalse(true);
			e.printStackTrace();
		} catch (IOException e) {
			assertFalse(true);
			e.printStackTrace();
		}
		String val = arc1.getCadena();
		System.out.println("Original : "+arc1.getCadena());
		System.out.println("Traducido : "+arc2.getCadena());
	}
	
	@Test
	public void createBinTest1() {
		System.out.println("\n\n//////////////////////////////////////// TEST CREAR ARCHIVO BINARIO 1 ////////////////////////////////////////");
		String contenido = "No se sabe mañana";
		try {
			arc1 = new Archivo("src\\resources\\Files");
			arc1.crearArchivoInfoBinaria("TextBin2", contenido);
			
			arc2 = new Archivo("src\\resources\\Files\\TextBin2");
			arc2.lecturaArchivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String val = arc2.getCadena();
		System.out.println("Original: "+contenido);
		System.out.println("Traducido: "+val);
	}
}
