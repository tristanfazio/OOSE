/**
 * A simple address book application.
 * @author Dave and Tristan Fazio
 */

package addressbook.view;

import addressbook.model.Entry;
import addressbook.model.AddressBook;
import addressbook.controller.Option;
import java.io.*;
import java.util.*;

public class UI
 {
    /**
     * Show the main menu, offering the user options to (1) search entries by
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    public static void showMenu(HashMap<Integer, Option> options, AddressBook addressbook)
    {
        
        String menuString ="\n";
        int i;
        for(i=0;i<options.size();i++)
        {
            menuString+="(" + (i+1) + ") " + options.get(i+1).getOptionsText() + " ";
        }
        menuString+="(" + (i+1) + ") Quit";
        System.out.println(menuString);
    }

    public static void printMessage(String inMessage)
    {
        System.out.println("\n" + inMessage +"\n");
    }
  }
    
 