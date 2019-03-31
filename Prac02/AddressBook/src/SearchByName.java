/**
 * SearchByName
 * Option class to handle Name searching
 * Implements Option interface
 * @author Tristan Fazio
 */

public class SearchByName implements Option
{
    AddressBook addressBook;
    public SearchByName(AddressBook inBook)
    {
      addressBook = inBook;
    }
    @Override
    public String doOption(String name)
    {
      return addressBook.findName(name).toString();
    }
    @Override
    public boolean requiresText()
    {
      return true;
    }
}
