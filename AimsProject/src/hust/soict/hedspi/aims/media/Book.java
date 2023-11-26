package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private ArrayList<String> authors = new ArrayList<String>();
	
	
	//constructor
	public Book(String title, String category, ArrayList<String> authors, float cost) {
		super(title, category, cost);
		this.authors = authors;
	}
	
	//getter setter
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	
	//toString
	@Override
    public String toString() {
		String authors = "\n Authors: ";
		int i=1;
		for (String o : this.authors) {
			authors+= "\n   "+i+ ". " + o;
			i++;
		}
    	String string = "Book: \n Title: "+ this.getTitle()+
    						  "\n Category: "+this.getCategory()+                			
    						  authors+
    						  "\n*Cost: "+this.getCost()+" $ \n";
    	return string;
    }
	
	//add and remove authors
	public void addAuthor(String authorName) {
		boolean exist = false;								
		for (String author : this.getAuthors()) {
			if (author.equals(authorName)) exist = true;
		}
		if (exist) System.out.println("The author" +authorName+ "has already been assigned to the book"+this.getTitle());
		else {
			this.getAuthors().add(authorName);
			System.out.println("Author added!");
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean exist = false;								
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
