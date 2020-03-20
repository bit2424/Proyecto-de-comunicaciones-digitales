package Modelo;

public class Usuario {
	private String numBoleta;
	private String nombreCompleto;
	private String documentoIdentidad;
	private int edad;
	private String genero;
	private Imagen imagenId;
	//Agregar un tipo para la inmagen
	
	public Usuario(String numBoleta, String nombreCompleto, String documentoIdentidad, int edad, String genero,Imagen imagenId) {
		super();
		this.numBoleta = numBoleta;
		this.nombreCompleto = nombreCompleto;
		this.documentoIdentidad = documentoIdentidad;
		this.edad = edad;
		this.genero = genero;
		this.imagenId = imagenId;
	}
	
	
	public String getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(String numBoleta) {
		this.numBoleta = numBoleta;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}
	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Imagen getImagenId() {
		return imagenId;
	}


	public void setImagenId(Imagen imagenId) {
		this.imagenId = imagenId;
	}
	
	
}
