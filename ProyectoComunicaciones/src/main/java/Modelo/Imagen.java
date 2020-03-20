package Modelo;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Imagen {
	
	private String imagePath;
	private ImagePlus image;
	private String binInformation;
	
	public Imagen(String imagePath) {
		this.imagePath = imagePath;
		image = IJ.openImage(imagePath);
		calculateBinInformation();
		image.show();
	}
	
	
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
	    	out.append("-");
	    	//System.out.println(pixels[i]+" - ");
	    }
	    
	    binInformation = out.toString();
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public ImagePlus getImage() {
		return image;
	}
	public void setImage(ImagePlus image) {
		this.image = image;
	}


	public String getBinInformation() {
		return binInformation;
	}

	public void setBinInformation(String bitInformation) {
		this.binInformation = bitInformation;
	}
	
	

}
