package hust.soict.hedspi.test.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class MediaTest {
	public static void main (String[] args) {
	ArrayList<Media> media = new ArrayList<Media>();
		
	
		//add DVD
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		//add Book
		ArrayList<String> authorList = new ArrayList<String>();
		authorList.add("Paulo Coelho");
		Book book = new Book("The Alchemist","Fiction", authorList, 20f);
		
		//add CD
		Track track1 = new Track("Track 1", 120);
        Track track2 = new Track("Track 2", 180);
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd = new CompactDisc("Sample Title", "Music", "John A", 300, 25f, "Jack B", tracks);

		
		media.add(cd);
		media.add(dvd);
		media.add(book);
		
		for(Media o: media) {
			System.out.println(o.toString());
		}
	}
}
