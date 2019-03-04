import java.util.*;

/**
 * Contains all the address book entries.
 *
 * @author Tristan Fazio
 */
public class AddressBook
{
    private Map<String,Entry> nameMap;

    public AddressBook()
    {
        nameMap = new HashMap<String,Entry>();
    }

    public Entry findName(String name)
    {
      Entry entry = new Entry();
      try
      {
        entry = nameMap.get(name);
      }
      catch(NullPointerException e)
      {
          System.out.println("The name " + name + " does not exist");
      }
      return entry;
    }

    public void addEntry(Entry entry)
    {
        nameMap.put(entry.getName(), entry);
    }
}
