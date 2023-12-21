package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	//Constructor 
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	private String title;
	private int length;
	
	
	// equals
	@Override
    public boolean equals(Object o) {
		Track t = (Track) o;
        if (this.getTitle() == t.getTitle()
        	&& this.getLength() == t.getLength()) {
            return true;
        } else return false;      
    }
	
    // Play method
    public void play() throws PlayerException {
    	if(this.getLength()>0) {
	    	System.out.println("Playing DVD: "+this.getTitle());
	    	System.out.println("DVD length: "+ this.getLength());
    	}else {
    		throw new PlayerException("ERROR: DVD length is non-positive!");
    	}
    }
	
	//Getter
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
}
