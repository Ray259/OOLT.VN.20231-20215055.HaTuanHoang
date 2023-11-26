package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	
	private String director;
	private int length;
	
	//Constructor
	public Disc(String director, int length) {
		super();
		this.director = director;
		this.length = length;
	}

	//Getter
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
}
