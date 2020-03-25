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
			this.mensajeCodificado = mensaje;	
			mensajeOriginal = "";
		}else if(type == DECODIFICAR){
			this.mensajeOriginal = mensaje;	
			mensajeCodificado = "";
		}
	}
	
	/**
	 * Metodo para aplicar el algoritmo de codificacion LZW sobre el String 
	 * de <b>mensajeOriginal</b> y almacenar el resultado en el String <b>mensajeCodificado</b>
	 */
	public void codificarLZW() {
		HashMap<String,Integer> lookUp = new HashMap();
		String info[] = mensajeOriginal.split("");		//abc a,b,c
		StringBuilder out = new StringBuilder();		//Es más rapido
		
		int id = 0;
		
		for(int i = 0; i<info.length ; i++) {
			if(!lookUp.containsKey(info[i])) {
				lookUp.put(info[i],id);
				out.append(info[i]);
				out.append(",");
				out.append(id);
				out.append(";");
				id++;
			}
		}
		
		out.append("*");
		
		String p = "";
		
		for(int i = 0; i<info.length; i++) {
			String c = info[i];
			if(lookUp.containsKey(p+c)) {
				p = p+c;
			}else {
				out.append(p);out.append(",");
				lookUp.put(p+c,id);id++;
				p = c;
			}
		}
		mensajeCodificado = out.toString();
	}
	
	/**
	 * Metodo para aplicar el algoritmo de decodificacion LZW sobre el String 
	 * de <b>mensajeCodificado</b> y almacenar el resultado en el String <b>mensajeOriginal</b>
	 */
	public void decodificarLZW() {
		String rawInfo[] = mensajeCodificado.split("*");
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
		out.append(lookUp.get(o));out.append(",");
		
		for(int i = 1; i<rawMessage.length;i++) {
			int n = Integer.parseInt(rawMessage[i]);
			
			if(lookUp.containsKey(n)){
				s = lookUp.get(o);
				s += c;
			}else {
				s = lookUp.get(n);
			}
			
			out.append(s);out.append(",");
			c = c.charAt(0)+"";
			id++;
			lookUp.put(id,lookUp.get(o)+c);
			o = n;
		}
		
		mensajeOriginal = out.toString();
	}
	
	/**
	 * Metodo para aplicar el algoritmo de codificacion RLE sobre el String 
	 * de <b>mensajeOriginal</b> y almacenar el resultado en el String <b>mensajeCodificado</b>
	 */
	public void codificarRLE() {
		String info = mensajeOriginal;
		StringBuilder result = new StringBuilder();
		int pos = 0;
		int accum = 1;
		
		while(pos < info.length()-1) {
			if(info.charAt(pos) == info.charAt(pos+1)) {
				accum++;
			}else {
				result.append(accum);
				result.append(info.charAt(pos));
				result.append('-');
				accum = 1;
			}
		}
		
		result.append(accum);
		result.append(info.charAt(info.length()-1));
		
		mensajeCodificado =  result.toString();
	}
	
	/**
	 * Metodo para aplicar el algoritmo de decodificacion RLE sobre el String 
	 * de <b>mensajeCodificado</b> y almacenar el resultado en el String <b>mensajeOriginal</b>
	*/
	
	public void decodificarRLE() {
		String info = mensajeOriginal;
		StringBuilder result = new StringBuilder();
		String splitInfo[] = info.split("-");
		
		for(int i = 0; i<splitInfo.length; i++){
			String ref = splitInfo[i]; 
			int repetitions = Integer.parseInt(ref.substring(0,ref.length()));
			char symbol = ref.charAt(ref.length()-1);
			for(int j = 0; j<repetitions;j++) {
				result.append(symbol);
			}
		}
		
		mensajeOriginal = result.toString();
	}
	
	
	
	
	/**
	 * @return mensajeOriginal : Un String con el mensaje original
	 */
	public String getMensajeOriginal() {
		return mensajeOriginal;
	}
	/**
	 * @param mensajeOriginal : Un String con el mensaje original que se quiere codificar
	 */
	public void setMensajeOriginal(String mensajeOriginal) {
		this.mensajeOriginal = mensajeOriginal;
	}
	/**
	 * @return mensajeCodificado : Un String con el mensaje con la informacion codificada
	 */
	public String getMensajeCodificado() {
		return mensajeCodificado;
	}
	/**
	 * @param mensajeCodificado :  Un String con el mensaje con la informacion que se quiere decodificar
	 */
	public void setMensajeCodificado(String mensajeCodificado) {
		this.mensajeCodificado = mensajeCodificado;
	}
	
	

}
