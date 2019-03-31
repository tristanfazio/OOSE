import java.util.*;

/**
 * Contains all the address book entries.
 *
 * @author Tristan Fazio
 */
public class AddressBook
{
    private Map<String,Entry> nameMap;
    private Map<String,Entry> addressMap;


    public AddressBook()
    {
        nameMap = new HashMap<String,Entry>();
        addressMap = new HashMap<String,Entry>();
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

    public Entry findAddress(String address)
    {
      Entry entry = new Entry();
      try
      {
        entry = addressMap.get(address);
      }
      catch(NullPointerException e)
      {
          System.out.println("The address " + address + " does not exist");
      }
      return entry;
    }

    public void addEntry(Entry entry)
    {
        nameMap.put(entry.getName(), entry);
        for(String s:entry.getAddresses())
        {
          addressMap.put(s,entry);
        }
    }
    public Map getNameMap()
    {
      return nameMap;
    }
}
