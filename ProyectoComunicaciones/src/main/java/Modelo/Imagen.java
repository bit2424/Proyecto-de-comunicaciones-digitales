package Modelo;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

/**
 * This is an image class to work with image information
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
	private String binInformation;
	
	/**
    * Constructor de Imagen
    * @param imagePath : String es la ruta de la imagen con que trabajara la instancia de {@link #Imagen}
    */
	public Imagen(String imagePath) {
		this.imagePath = imagePath;
		image = IJ.openImage(imagePath);
		calculateBinInformation();
		image.show();
	}
	
	/**
    *  El metodo obtine la informacion rgb de cada bit de la imagen
    *  y la almacena en el String <b>binInformation<\b>
    */
	public void calculateBinInformation() {
	    ImageProcessor myProcessor = image.getProcessor();
	    
	    int[] pixels = (int[]) myProcessor.getPixels();
	    
	    StringBuilder out = new StringBuilder();
	    
	    
	    // set each pixel value to whatever, between -128 and 127  
	    for (int i=0; i<pixels.length; i++) {  
	    	int red   = (int)(pixels[i] & 0xff0000)>>16;
	    	int green = (int)(pixels[i] & 0x00ff00)>>8;
	    	int blue  = (int)(pixels[i] & 0x0000ff);
	    	out.append(pixels[i]);
	    	out.append(",");
	    	System.out.println(pixels[i]);
	    }
	    
	    binInformation = out.toString();
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
	 * @return
	 */
	public String getBinInformation() {
		return binInformation;
	}

	/**
	 * @param bitInformation
	 */
	public void setBinInformation(String bitInformation) {
		this.binInformation = bitInformation;
	}
	
	

}
