/**
 * SearchByEmail
 * Option class to handle email searching
 * Implements Option interface
 * @author Tristan Fazio
 */

 public class SearchByEmail implements Option
 {



     @override
     public String doOption(String email,AddressBook addressBook)
     {
       return addressBook.findAddress(email).toString();
     }
 }
