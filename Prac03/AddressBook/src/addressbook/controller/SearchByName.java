/**
 * SearchByName
 * Option class to handle Name searching
 * Implements Option interface
 * @author Tristan Fazio
 */

package addressbook.controller;

import addressbook.model.Entry;
import addressbook.model.AddressBook;
import addressbook.view.UI;

public class SearchByName implements Option
{
  AddressBook addressBook;
  String optionsText = "Search By Name";
  
  public SearchByName(AddressBook inBook)
  {
    addressBook = inBook;
  }
  @Override
  public void doOption(String name)
  {
    System.out.println(addressBook.findName(name).toString());
  }
  @Override
  public Boolean requiresText()
  {
    return true;
  }
  @Override
  public String getOptionsText()
  {
    return optionsText;
  }
}
