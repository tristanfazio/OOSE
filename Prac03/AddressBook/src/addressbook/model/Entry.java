package addressbook.model;

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
        String outString = "";
        outString+="\n------------------------------\n";
        outString+=(name + ":");
        for(String s: addresses)
        {
            outString+=("\n\t" + s);
        }
        return outString;
    }
}
