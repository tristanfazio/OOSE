import java.util.*;

/**
 * Contains all the address book entries.
 * 
 * @author Tristan Fazio
 */
public class AddressBook
{
    private Map<String,Entry> addressMap;

    public AddressBook()
    {
        addressMap = new HashMap<String,Entry>();
    }

    public Entry findName(String name)
    {
        Entry entry = addressMap.get(name);
        return entry;
    }

    public void addEntry(Entry entry)
    {
        addressMap.put(entry.getName(), entry);
    }
}
