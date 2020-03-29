package Modelo;

import java.util.HashMap;

/**
 * Esta es una clase para desarrollar codificaciones 
 *
 * @author Nelson David Quiñones Virgen
 * @author n1
 * @author n2
 * @author n3
 */
public class Codificacion {
	
	/**
	 * Este String guarda la información sin codificacion
	 */
	private String mensajeOriginal;
	/**
	 * Este String guarda información codificada
	 */
	private String mensajeCodificado;
	/**
	 * Un entero con la cantidad de bits de la información sin codificacion
	 */
	private int bitsMensajeOriginal;
	/**
	 * Un entero con la cantidad de bits de la información codificada
	 */
	private int bitsMensajeCodificado;
	
	/**
	 * Int representando la opcion de codificar
	 */
	private static final int CODIFICAR = 0;  
	/**
	 * Int representando la opcion de decodificar
	 */
	private static final int DECODIFICAR = 1;  
	
	/**
	 * Constructor de la clase codificación
	 * 
	 * @param mensaje : String ; El mensaje sobre el cual se realizaran las operaciones.
	 * 
	 * @param type : int ; Representa el tipo de operacion que se realizara sobre el String <b>mensaje</b>,
	 *  en caso de ser 0 se codificara el mensaje, en caso de ser 1 se decodificara el mansaje <b>mensaje</b>.
	 *  
	 */
	public Codificacion(String mensaje ,int type) {
		if(type == CODIFICAR) {
			this.mensajeOriginal = mensaje;
			bitsMensajeOriginal = mensaje.length()*7;
		}else if(type == DECODIFICAR){
			this.mensajeCodificado = mensaje;
			bitsMensajeCodificado = mensaje.length()*7;
		}
	}
	
	/**
	 * Metodo para codificar el String <b>mensajeOriginal</b> utilizando el algoritmo LZW,
	 * el resultado se almacena en el String <b>mensajeCodificado</b> con la siguiente estructura: 
	 * <p><b>tabla LZW + "*" + mensaje codificado</b>.</p> 
	 * El mensaje codificado va a ser un String con una serie de enteros separados por comas 
	 * que representan la salida del algoritmos LZW.
	 */
	public void codificarLZW() {
		HashMap<String,Integer> lookUp = new HashMap();
		String info[] = mensajeOriginal.split("");		//abc a,b,c
		StringBuilder out = new StringBuilder();		//Es más rapido
		
		out.append(creacionTablaLZW(lookUp,info));
		int id =lookUp.size();
		
		out.append("*");
		
		String p = "";
		
		for(int i = 0; i<info.length; i++) {
			String c = info[i];
			if(lookUp.containsKey(p+c)) {
				p = p+c;
			}else {
				out.append(lookUp.get(p));out.append(",");
				lookUp.put(p+c,id);id++;
				p = c;
			}
		}
		out.append(lookUp.get(p));
		mensajeCodificado = out.toString();
		bitsMensajeCodificado = mensajeCodificado.length()*7;
	}
	
	/**
	 * El metodo crea un String que representa la tabla LZW que se va a utilizar para codificar.<p></p>
	 * El String esta compuesto de parejas de un caracter unico del mensaje separado por una coma del entero que lo representa <b>ej : a,0</b>
	 * a su vez cada pareja va a estar separada entre si por un punto y coma <b>ej : a,0;b,1;c,2</b>.
	 * 
	 * @param lookUp : El HashMap en el que se representara la tabla LZW para ejecutar el algoritmo.
	 * @param info : Un arreglo de Strings con cada caracter del mensaje a codificar.
	 * 
	 * @return un String con la con la tabla LZW.
	 */
	public String creacionTablaLZW(HashMap<String,Integer> lookUp,String info[]) {
		int id = 0;
		StringBuilder out = new StringBuilder();
		for(int i = 0; i<mensajeOriginal.length(); i++) {
			if(!lookUp.containsKey(info[i])) {
				lookUp.put(info[i],id);
				out.append(info[i]);
				out.append(",");
				out.append(id);
				out.append(";");
				id++;
			}
		}
		return out.toString();
	}
	
	/**
	 * Metodo para decodificar el String <b>mensajeCodificado</b> utilizando el algoritmo LZW,
	 * el resultado se almacena en el String <b>mensajeOriginal</b>.
	 */
	public void decodificarLZW() {
		String rawInfo[] = mensajeCodificado.split("\\*");
		String rawTable[] = rawInfo[0].split(";");
		String rawMessage[] = rawInfo[1].split(",");
		
		HashMap<Integer,String> lookUp = new HashMap();
		
		int id = 0;
		
		for(int i = 0; i<rawTable.length;i++) {
			String symbol = rawTable[i].split(",")[0];
			id = Integer.parseInt(rawTable[i].split(",")[1]);
			lookUp.put(id,symbol);
		}
		
		StringBuilder out = new StringBuilder();
		
		int o = Integer.parseInt(rawMessage[0]);
		String s = "";
		String c = "";
		out.append(lookUp.get(o));
		
		for(int i = 1; i<rawMessage.length;i++) {
			int n = Integer.parseInt(rawMessage[i]);
			
			if(!lookUp.containsKey(n)){
				s = lookUp.get(o);
				s += c;
			}else {
				s = lookUp.get(n);
			}
			
			out.append(s);
			c = s.charAt(0)+"";
			id++;
			lookUp.put(id,lookUp.get(o)+c);
			o = n;
		}
		
		mensajeOriginal = out.toString();
		bitsMensajeOriginal = mensajeOriginal.length()*7;
	}
	
	/**
	 * Metodo para codificar el String <b>mensajeOriginal</b> utilizando el algoritmo RLE,
	 * el resultado se almacena en el String <b>mensajeCodificado</b> con la siguiente estructura: 
	 * <p>
	 * <b>elemento,# repeticiones ; elemento,# repeticiones ; elemento,# repeticiones</b>
	 * </p>
	 * donde el <b>elemento</b> es un String de mensajeOriginal y el <b># de repeticiones</b> 
	 * es la cantidad de veces que aparece consecutivamente en el mensaje original.  
	 */
	public void codificarRLE() {
		String info[] = mensajeOriginal.split(",");
		StringBuilder result = new StringBuilder();
		int pos = 0;
		int accum = 1;
		
		while(pos < info.length-1) {
			if(info[pos].equals(info[pos+1])) {
				accum++;
			}else {
				result.append(accum);
				result.append(',');
				result.append(info[pos]);
				result.append(';');
				accum = 1;
				//System.out.println(accum+info[pos]+",");
			}
			pos++;
		}
		
		result.append(accum);
		result.append(',');
		result.append(info[info.length-1]);
		
		mensajeCodificado =  result.toString();
		bitsMensajeCodificado = mensajeCodificado.length()*7;
	}
	
	/**
	 * Metodo para decodificar el String <b>mensajeCodificado</b> utilizando el algoritmo RLE,
	 * el resultado se almacena en el String <b>mensajeOriginal</b>,
	 * separando cada elemento del mensaje original por una coma.
	 */
	public void decodificarRLE() {
		String info = mensajeCodificado;
		StringBuilder result = new StringBuilder();
		String splitInfo[] = info.split(";");

		for (int i = 0; i < splitInfo.length; i++) {
			String ref[] = splitInfo[i].split(",");
			if (ref.length > 0) {
				int repetitions = Integer.parseInt(ref[0]);
				String symbol = ref[1];
				for (int j = 0; j < repetitions; j++) {
					result.append(symbol);
					result.append(",");
				}
			}
		}

		mensajeOriginal = result.toString();
		bitsMensajeOriginal = mensajeOriginal.length()*7;
	}
	
	
	/**
	 * El metodo calcula la relación de compresión entre <b>bitsMensajeOriginal</b> y <b>bitsMensajeCodificado</b>
	 * @return un numero real representando la relasión de compresion
	 */
	public double calcularRelacionCompresion() {
		return (double)bitsMensajeOriginal/(double)bitsMensajeCodificado;
	}
	
	
	
	/**
	 * @return un String con el mensaje original
	 */
	public String getMensajeOriginal() {
		return mensajeOriginal;
	}
	/**
	 * @param mensajeOriginal : un String con el nuevo mensasje a codificar
	 */
	public void setMensajeOriginal(String mensajeOriginal) {
		this.mensajeOriginal = mensajeOriginal;
	}
	/**
	 * @returnun String con el mensaje codificado
	 */
	public String getMensajeCodificado() {
		return mensajeCodificado;
	}
	/**
	 * @param mensajeCodificado : un String con el nuevo mensasje a decodificar
	 */
	public void setMensajeCodificado(String mensajeCodificado) {
		this.mensajeCodificado = mensajeCodificado;
	}

	public int getBitsMensajeOriginal() {
		return bitsMensajeOriginal;
	}

	public int getBitsMensajeCodificado() {
		return bitsMensajeCodificado;
	}
}
