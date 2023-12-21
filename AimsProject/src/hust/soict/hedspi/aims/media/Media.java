package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	// constructor
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		id=nbMedia;
	}
	public Media(String title) {
		this.title = title;
	}
	
	//Comparator
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private static int nbMedia;
	private int id;
	private String title;
	private String category;
	private float cost;
	
	//equals method
	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true; 
	        if (o == null || getClass() != o.getClass()) return false; 
	        Media media = (Media) o;
	        return title.equals(media.title) && cost == media.cost; 
	    }
	   
    // isMatch method
    public boolean isMatch(String title) {
    	if(this.getTitle().equals(title)) return true;
    	return false;
    }
	
	
	//Getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
