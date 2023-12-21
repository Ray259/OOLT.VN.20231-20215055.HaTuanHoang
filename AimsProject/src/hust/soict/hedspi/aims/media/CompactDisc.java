package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	// Constructor
	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	// Attributes
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	// play() interface
	public void play() throws PlayerException {
		if (this.getLength() > 0) {

			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}

	}


	// toString
	@Override
	public String toString() {
		String tracks = "\n Tracks: ";
		int i = 1;
		for (Track o : this.tracks) {
			tracks += "\n   " + i + ". " + o.getTitle() + ": " + o.getLength() + " (s)";
			i++;
		}
		String string = "CD: \n Title: " + this.getTitle() + ",\n Category: " + this.getCategory() + ",\n Director: "
				+ this.getDirector() + ",\n Artist: " + this.getArtist() + ",\n Length: " + this.getLength() + tracks
				+ ",\n*Cost: " + this.getCost() + " $ \n";
		return string;
	}

	// Add and remove tracks methods
	public void addTrack(Track track) {
		boolean exist = false;
		for (Track o : tracks) {
			if (o.equals(track)) {
				exist = true;
				break;
			}
		}
		if (exist)
			System.out.println("Already exist.");
		else {
			tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added to the disc.");
		}
	}

	public void removeTrack(Track track) {
		boolean exist = false;
		for (Track o : tracks) {
			if (o.equals(track)) {
				exist = true;
				break;
			}
		}
		if (!exist)
			System.out.println("Track not found!");
		else {
			tracks.remove(track);
			System.out.println("The track " + track.getTitle() + " has been removed to the disc.");
		}
	}

	// Getter
	public String getArtist() {
		return artist;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}
}
