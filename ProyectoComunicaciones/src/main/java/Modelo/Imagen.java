package Modelo;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

/**
 * Esta es una clase para trabajar con informacion de Imagenes
 *
 * @author Nelson David Quiñones Virgen
 * @author n1
 * @author n2
 * @author n3
 */

public class Imagen {
	
	/**
	 * String que contiene la dirección de la imagen a trabajar
	 */
	private String imagePath;
	/**
	 * ImagePlus el obejeto con el que se manejara la información de la imagen 
	 */
	private ImagePlus image;
	/**
	 * String con la información rgb de cada bit de la imagen
	 */
	private String pixInformation;
	
	
	
	/**
    * Constructor de Imagen
    * @param imagePath : String es la ruta de la imagen con que trabajara la instancia de {@link #Imagen}
    */
	public Imagen(String imagePath) {
		this.imagePath = imagePath;
		image = IJ.openImage(imagePath);
		calculatePixInformation();
		//image.show();
	}
	
	/**
    * Constructor de Imagen
    * 
    * @param imageInfo : String[] es un arreglo con la información de cada pixel de la imagen
    * con el que se creara una instancia de {@link #Imagen}.
    * 
    * imageInfo[] se puede obtener del String <b>bitInformation</b> 
    * separando su contenido por comas.
    */
	public Imagen(String imageInfo[]) {
		int altura = Integer.parseInt(imageInfo[0]);
		int ancho = Integer.parseInt(imageInfo[1]);
		
		ImagePlus ref = new ImagePlus();
		ImageProcessor myProcessor = ref.getProcessor();
				
		
		for(int i = 0; i<altura ; i++) {
			for(int j = 0; j<ancho; j++) {
				myProcessor.set(i, j, Integer.parseInt(imageInfo[i*ancho+j]));
			}
		}
		
		this.image = ref;
		//image.show();
	}
	
	/**
	*  
    *  El metodo obtine la informacion rgb de cada bit de la imagen
    *  y los almacena en el String <b>binInformation</b> separados por comas.
    *  Los primeros dos datos del String contienen la <b>altura</b> y el <b>ancho</b> de la imagen.
    */
	private void calculatePixInformation() {
	    ImageProcessor myProcessor = image.getProcessor();
	    
	    int[] pixels = (int[]) myProcessor.getPixels();
	    
	    StringBuilder out = new StringBuilder();
	    out.append(image.getHeight());
	    out.append(",");
	    out.append(image.getWidth());
	    out.append(",");
	    
	    // set each pixel value to whatever, between -128 and 127  
	    for (int i=0; i<pixels.length; i++) {  
	    	int red   = (int)(pixels[i] & 0xff0000)>>16;
	    	int green = (int)(pixels[i] & 0x00ff00)>>8;
	    	int blue  = (int)(pixels[i] & 0x0000ff);
	    	out.append(pixels[i]);
	    	out.append(",");
	    	//System.out.println(pixels[i]);
	    }
	    
	    pixInformation = out.toString();
	}
	
	
	
	/**
	 * @return String : {@link imagePath}
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param String : imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return ImagePlus : image  
	 */
	public ImagePlus getImage() {
		return image;
	}
	/**
	 * @param ImagePlus : image
	 */
	public void setImage(ImagePlus image) {
		this.image = image;
	}


	/**
	 * @return bitInfomation : String
	 */
	public String getPixInformation() {
		return pixInformation;
	}
	
}
