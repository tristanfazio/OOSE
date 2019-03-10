import java.util.*;

/**
 * Represents an album of images.
 */
public class Album
{
    LinkedList<ImageRecord> album;

    public Album()
    {
      album = new LinkedList<ImageRecord>();
    }

    public void addImage(ImageRecord newRecord)
    {
      album.add(newRecord);
    }

    public ImageRecord getFirst()
    {
      return album.getFirst();
    }

    public ListIterator<ImageRecord> getIterator(int idx)
    {
      return album.listIterator(idx);
    }
}
