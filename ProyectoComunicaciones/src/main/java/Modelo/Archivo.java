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
		
		String ruta = direccion+"//"+nombre;
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
	 * @param s : String con el texto a traducir
	 * @return : Un String con el texto alfanumérico
	 */
	private String traducirBinario(String s) {
		StringBuilder out = new StringBuilder();
        String chars[] = s.split(" ");
		
        for(int i = 0; i<chars.length; i++) {
        	out.append((char)Long.parseLong(chars[i],2));
        }
		
		return out.toString();
	}
	
	/**
	 *  Metodo para generar la traduccion de un texto alfanumérico a binario
	 * @param s : String con el texto a traducir
	 * @return : Un String con el texto binario1
	 */
	private String generarBinario(String s) {
		int n = s.length(); 
		StringBuilder bin = new StringBuilder();
        for (int i = 0; i < n; i++)  
        { 
            // convert each char to 
            // ASCII value 
            int val = Integer.valueOf(s.charAt(i)); 
  
            // Convert ASCII value to binary 
            StringBuilder ref = new StringBuilder();
            while (val > 0)  
            { 
                if (val % 2 == 1) 
                { 
                    ref.append('1'); 
                } 
                else
                	ref.append('0');
                val /= 2; 
            }
            bin.append(ref.reverse().toString());
            bin.append(" ");
        }
		return bin.toString();
	}


	public String getCadena() {
		return cadena;
	}


	public void setCadena(String cadena) {
		this.cadena = cadena;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
