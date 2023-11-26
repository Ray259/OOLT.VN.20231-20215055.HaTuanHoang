package hust.soict.hedspi.aims.media;

public class Track {
	//Constructor 
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	private String title;
	private int length;
	
	public boolean isMatch(Track track) {
		if (this.getTitle().equals(track.getTitle())
			&& this.getLength()==track.getLength()) return true;
		
		return false;			
	}
	
	//Getter
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
}
