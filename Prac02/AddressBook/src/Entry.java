import java.util.*;
        
/**
 * Represents a single address book entry.
 * 
 * @author Tristan Fazio
 * 
 */

public class Entry 
{
    private String name;
    private Set<String> addresses;
    
    //default constructor
    public Entry()
    {
        name="";
        addresses=new HashSet<String>();
    }

    //GETTERS
    public String getName()
    {
        return name;
    }

    public Set<String> getAddresses()
    {
        return addresses;
    }

    //SETTERS
    public void setName(String inName)
    {
        name = inName;
    }

    public void pushAddress(String inAddress)
    {
        addresses.add(inAddress);
    }

    public String toString()
    {
        String string = "";
        string+="------------------------------\n";
        string+=(name + ":");
        for(String s: addresses)
        {
           string+=("\n\t" + s);
        }
        string+=("\n------------------------------");
        return string;
    }
}
