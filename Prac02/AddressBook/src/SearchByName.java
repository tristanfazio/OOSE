/**
 * SearchByName
 * Option class to handle Name searching
 * Implements Option interface
 * @author Tristan Fazio
 */

public class SearchByName implements Option
{
    public SearchByName()
    {

    }
    @Override
    public String doOption(String name,AddressBook addressBook)
    {
      return addressBook.findName(name).toString();
    }
    @Override
    public boolean requiresText()
    {
      return true;
    }
}
