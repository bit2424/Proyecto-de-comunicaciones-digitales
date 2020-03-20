package Modelo;

public class Codificacion {
	
	private String mensajeOriginal;
	private String mensajeCodificado;
	
	
	public Codificacion(String mensaje ,int type) {
		if(type == 1) {
			this.mensajeCodificado = mensaje;			
		}else {
			this.mensajeOriginal = mensaje;						
		}
	}
	
	public void codificarLZW(String info) {
		
	}
	
	public void decodificarLZW(String info) {
		
	}
	
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
	
	
	
	
	public String getMensajeOriginal() {
		return mensajeOriginal;
	}
	public void setMensajeOriginal(String mensajeOriginal) {
		this.mensajeOriginal = mensajeOriginal;
	}
	public String getMensajeCodificado() {
		return mensajeCodificado;
	}
	public void setMensajeCodificado(String mensajeCodificado) {
		this.mensajeCodificado = mensajeCodificado;
	}
	
	

}
