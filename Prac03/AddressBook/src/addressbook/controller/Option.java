package addressbook.controller;
/**
 * Interface class for handling option calls
 * @author Tristan Fazio
 *
 */

 public interface Option
 {
    //abstract option call
    void doOption(String term);
    //abstract text check
    Boolean requiresText();
    String getOptionsText();  
 }
