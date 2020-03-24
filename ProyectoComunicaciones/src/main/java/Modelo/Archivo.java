package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
	
	Codificacion codificacion;
	String cadena; 
	
	public Archivo() {
		
		codificacion = new Codificacion(null, 0);
	}

	public void lecturaArchivo(String archivo) throws IOException, FileNotFoundException {
		
		FileReader file = new FileReader(archivo);
		BufferedReader br = new BufferedReader(file);
		
		while((cadena= br.readLine())!= null){
			System.out.println(cadena);	
			
		}
		br.close();
	}
	
	public void crearArchivoInfoBinaria() throws IOException {
		//Crea un archivo con la información (despues de leer el archivo de 
		//texto anteriór, con los metodos de la clase clasificación codificar y generar 
		//un nuevo archivo con la infromación binaria) 
		
		String ruta = "Proyecto-de-comunicaciones-digitales\\ProyectoComunicaciones\\src\\resources\\files";
		String contenido = "Aqui debo llamar el metodo de Codificación o los metodos";
		
		File file = new File(ruta);
		
		if(!file.exists()) {
			file.createNewFile();
		} 
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(contenido);
		bw.close();
		
	
	}
	
	public void guardarArchivo() {
		
	}
	
	public void abrirArchivoTextoBinario() {
		
	}
	
	
}
