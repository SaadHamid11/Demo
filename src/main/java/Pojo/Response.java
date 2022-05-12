package Pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Response {
	
	
	private  int charityType;
	private String ImageSource;
	private String DarkModeImageSource;
	private String Description;
	private String Tagline;
	
	
	public int getCharityType() {
		return charityType;
	}
	public void setCharityType(int charityType) {
		this.charityType = charityType;
	}
	public String getImageSource() {
		return ImageSource;
	}
	public void setImageSource(String imageSource) {
		ImageSource = imageSource;
	}
	public String getDarkModeImageSource() {
		return DarkModeImageSource;
	}
	public void setDarkModeImageSource(String darkModeImageSource) {
		DarkModeImageSource = darkModeImageSource;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTagline() {
		return Tagline;
	}
	public void setTagline(String tagline) {
		Tagline = tagline;
	}
    

    // Jackson requires to have this constructor
   
  
    
    /*public Response(int type, String imgSource, String darkModeSource, String description, String tagLine) {
        this.charityType = type;
        this.imageSource = imgSource;
        this.darkModeImageSurce = darkModeSource;
        this.description = description;
        this.tagLine = tagLine;
    }
  */
	
	
    
    

   

   

 
}