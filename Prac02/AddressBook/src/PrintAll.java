import java.util.Map;

/**
 * PrintAll
 * Option class to handle printing of all records
 * Implements Option interface
 * @author Tristan Fazio
 */

public class PrintAll implements Option
{
  AddressBook addressBook;
  String optionsText = "Print All";
  public PrintAll(AddressBook inBook)
  {
    addressBook = inBook;
  }
  @Override
  public void doOption(String email)
  {
    Map<String,Entry> map = addressBook.getNameMap();
    for (Map.Entry<String, Entry> mapEntry : map.entrySet()) 
    {
      System.out.println(mapEntry.getValue().toString());
    }
  }
  @Override
  public Boolean requiresText()
  {
    return false;
  }
  @Override
  public String getOptionsText()
  {
    return optionsText;
  }
}