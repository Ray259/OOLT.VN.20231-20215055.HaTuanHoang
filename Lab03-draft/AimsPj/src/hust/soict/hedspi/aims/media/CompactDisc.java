package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	public CompactDisc(String director, int length, String artist, List<Track> tracks) {
		super(director, length);
		this.artist = artist;
		this.tracks = tracks;
	}

	//Constructor
	public CompactDisc(String director, int length) {
		super(director, length);
		// TODO Auto-generated constructor stub
	}
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	//Getter
	public String getArtist() {
		return artist;
	}
	

	
	public void addTrack(Track track) {
		boolean exist=false;
		for (Track o : tracks) {
			if(o.isMatch(track)) {
				exist = true;
				break;
			} 
		}
		if(exist) System.out.println("Already exist.");
		else {
			tracks.add(track);
			System.out.println("The track "+track.getTitle()+" has been added to the disc.");
		}
	}
	
	
	
	public void removeTrack(Track track) {
		boolean exist=false;
		for (Track o : tracks) {
			if(o.isMatch(track)) {
				exist = true;
				break;
			} 
		}
		if(!exist) System.out.println("Track not found!");
		else {
			tracks.remove(track);
			System.out.println("The track "+track.getTitle()+" has been removed to the disc.");
		}
	}
}
