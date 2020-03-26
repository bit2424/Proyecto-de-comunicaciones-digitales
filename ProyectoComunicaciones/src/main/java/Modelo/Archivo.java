package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Esta es una clase para manejar archivos de texto
 *
 * @author Nelson David Quiñones Virgen
 * @author n1
 * @author n2
 * @author n3
 */

public class Archivo {
	
	/**
	 * String que almacenara la informacion que se lea de un archivo
	 */
	String cadena;
	
	/**
	 * String que almacenara la direccion del archivo con el que se quiere trabajar
	 */
	String direccion;
	
	/**
	 * Metodo constructor de archivo {@link #Archivo}
	 * @param direccion : almacenara la direccion del archivo con el que se quiere trabajar
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Archivo(String direccion) throws FileNotFoundException, IOException {
		this.direccion = direccion;
	}

	
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void lecturaArchivo() throws IOException, FileNotFoundException {
		
		FileReader file = new FileReader(direccion);
		BufferedReader br = new BufferedReader(file);
		String temp = "";
		StringBuilder constructor = new StringBuilder();
		while((temp = br.readLine())!= null){
			System.out.println(temp);
			constructor.append(temp);
		}
		cadena = constructor.toString();
		br.close();
	}
	
	
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void lecturaArchivoTextoBinario() throws FileNotFoundException, IOException {
		lecturaArchivo();
		cadena = traducirBinario(cadena); 
	}
	
	/**
	 * Metodo para crear un archivo con la información de <b>info</b>
	 * @param nombre : Un String con el nombre que se le dara al archivo
	 * @param info	: Un String con la informacion que se quiere poner el archivo
	 * @throws IOException
	 */
	public void crearArchivo(String nombre,String info) throws IOException {
		//Crea un archivo con la información (despues de leer el archivo de 
		//texto anteriór, con los metodos de la clase clasificación codificar y generar 
		//un nuevo archivo con la infromación binaria) 
		
		String ruta = "Proyecto-de-comunicaciones-digitales\\ProyectoComunicaciones\\src\\resources\\files";
		String contenido = info; //Debemos asumir que a cadena ya se le hicieron las operaciones pertinentes
		
		File file = new File(ruta);
		
		if(!file.exists()) {
			file.createNewFile();
		} 
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(contenido);
		bw.close();
		
	}

	/**
	 * Metodo para crear un archivo con la información de <b>info</b> traducida a binario
	 * @param nombre : Un String con el nombre que se le dara al archivo
	 * @param info	: Un String con la informacion que se quiere poner el archivo
	 * @throws IOException
	 */
	public void crearArchivoInfoBinaria(String nombre,String info) throws IOException {
		String contenido = generarBinario(info);
		crearArchivo(nombre,contenido);
	}


	/**
	 * Metodo para  traducir un texto binario a un texto alfanumérico
	 * @param info : String con el texto a traducir
	 * @return : Un String con el texto alfanumérico
	 */
	private String traducirBinario(String info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  Metodo para generar la traduccion de un texto alfanumérico a binario
	 * @param info : String con el texto a traducir
	 * @return : Un String con el texto binario1|
	 */
	private String generarBinario(String info) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
