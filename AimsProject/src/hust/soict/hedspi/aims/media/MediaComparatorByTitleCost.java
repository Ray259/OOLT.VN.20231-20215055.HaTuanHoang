package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // Compare by title first
        Float cost1 = o1.getCost();
        Float cost2 = o2.getCost();
        int comp = o1.getTitle().compareTo(o2.getTitle()); 
        if (comp == 0) {
        	comp = cost1.compareTo(cost2);
        }

        return comp;
    }
}