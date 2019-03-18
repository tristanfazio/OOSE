/**
 * SearchByEmail
 * Option class to handle email searching
 * Implements Option interface
 * @author Tristan Fazio
 */

 public class SearchByEmail implements Option
 {
    AddressBook addressBook;
    public SearchByEmail(AddressBook inBook)
    {
      addressBook = inBook;
    }
     @Override
     public String doOption(String email)
     {
       return addressBook.findAddress(email).toString();
     }
 }
