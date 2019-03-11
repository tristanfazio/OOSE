/**
 * SearchByName
 * Option class to handle Name searching
 * Implements Option interface
 * @author Tristan Fazio
 */

public class SearchByName implements Option
{

    private int label;

    public SearchByName(int i)
    {
      label=i;
    }
    @override
    public String doOption(String name,AddressBook addressBook)
    {
      return addressBook.findName(name).toString();
    }
}
