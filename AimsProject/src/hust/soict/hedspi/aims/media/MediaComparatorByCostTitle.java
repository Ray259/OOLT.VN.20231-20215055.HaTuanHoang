package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // Compare by cost first
        Float cost1 = o1.getCost();
        Float cost2 = o2.getCost();
        int comp = cost1.compareTo(cost2);
        if (comp == 0) {
            comp = o1.getTitle().compareTo(o2.getTitle());
        }

        return comp;
    }
}