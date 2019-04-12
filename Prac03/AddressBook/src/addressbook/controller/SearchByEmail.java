/**
 * SearchByEmail
 * Option class to handle email searching
 * Implements Option interface
 * @author Tristan Fazio
 */

package addressbook.controller;

import addressbook.model.Entry;
import addressbook.model.AddressBook;

public class SearchByEmail implements Option
{
  AddressBook addressBook;
  String optionsText = "Search By Email";
  public SearchByEmail(AddressBook inBook)
  {
    addressBook = inBook;
  }
  @Override
  public void doOption(String email)
  {
    System.out.println(addressBook.findAddress(email).toString());
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
