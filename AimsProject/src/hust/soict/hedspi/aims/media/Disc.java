package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	
	private String director;
	private int length;
	
	//Constructor
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title) {
		super(title);
	}

	//Getter
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
}
