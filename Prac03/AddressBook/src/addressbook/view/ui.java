/**
 * A simple address book application.
 * @author Dave and Tristan Fazio
 */

import addressbook.model.Entry;
import addressbook.model.Addressbook;


public class ui
 {
    /**
     * Show the main menu, offering the user options to (1) search entries by
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    public static void showMenu(AddressBook addressBook)
    {
        Option option;
        int choice;
        boolean done = false;

        while(!done)
        {
            String text = null;
            String menuString ="\n";
            int i;
            for(i=0;i<options.size();i++)
            {
                menuString+="(" + (i+1) + ") " + options.get(i+1).getOptionsText() + " ";
            }
            menuString+="(" + (i+1) + ") Quit";
            System.out.println(menuString);
            try
            {
                choice = Integer.parseInt(input.nextLine());

                option = options.get(choice);
                if(option.requiresText())
                {
                  System.out.println("Enter the search term");
                  text = input.nextLine();
                }
                
                option.doOption(text);

            }
            catch(NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
            catch(NullPointerException e)
            {
              done=true;
            }
        }
    }
 }
 
 