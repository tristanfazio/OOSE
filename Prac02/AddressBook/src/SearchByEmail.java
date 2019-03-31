/**
 * SearchByEmail
 * Option class to handle email searching
 * Implements Option interface
 * @author Tristan Fazio
 */

 public class SearchByEmail implements Option
 {
    public SearchByEmail()
    {

    }
     @Override
     public String doOption(String email,AddressBook addressBook)
     {
       return addressBook.findAddress(email).toString();
     }
     @Override
    public boolean requiresText()
    {
      return true;
    }
 }
