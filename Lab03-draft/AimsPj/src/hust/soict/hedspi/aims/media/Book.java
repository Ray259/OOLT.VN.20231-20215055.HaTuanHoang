package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	private int length;
	
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	public void addAuthor(String authorName) {
		boolean exist = false;								//Check whether author exist or not
		for (String author : this.getAuthors()) {
			if (author == authorName) exist = true;
		}
		if (exist) System.out.println("The author" +authorName+ "has already been assigned to the book"+this.getTitle());
		else {
			this.getAuthors().add(authorName);
			System.out.println("Author added!");
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean exist = false;								//Check whether author exist or not
		for (String author : this.getAuthors()) {
			if (author == authorName) exist = true;
		}
		if (!exist) System.out.println("Cannot remove. The author" +authorName+ "hasn't already been assigned to the book"+this.getTitle());
		else {
			this.getAuthors().remove(authorName);
			System.out.println("Author removed!");
		}
	}
}
