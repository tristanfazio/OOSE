import java.io.*;
import java.util.*;
import addressbook.model.Entry;
import addressbook.model.Addressbook;
import addressbook.view.ui;

/**
 * A simple address book application.
 * @author Dave and Tristan Fazio
 */

public class AddressBookApp
{
    /** Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);
    private static HashMap<Integer,Option> options;

    public static void main(String[] args)
    {
        String fileName;

        System.out.print("\nEnter address book filename: ");
        fileName = input.nextLine();
        options = new HashMap<Integer,Option>();
        

        try
        {
            AddressBook addressBook = readAddressBook(fileName);

            System.out.println("Read Successfull");

            options.put(1,new SearchByName(addressBook));
            options.put(2,new SearchByEmail(addressBook));
            options.put(3,new PrintAll(addressBook));


            showMenu(addressBook);
        }
        catch(IOException e)
        {
            System.out.println("Could not read from " + fileName + ": " + e.getMessage());
        }
    }

    /**
     * Read the address book file, containing all the names and email addresses.
     *
     * @param fileName The name of the address book file.
     * @return A new AddressBook object containing all the information.
     * @throws IOException If the file cannot be read.
     */
    private static AddressBook readAddressBook(String fileName) throws IOException
    {
        AddressBook addressBook = new AddressBook();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while(line != null)
        {
            String[] parts = line.split(":");

            Entry entry = new Entry();
            for(int i=0;i<parts.length;i++)
            {
                if(i==0)
                {
                    entry.setName(parts[i]);
                }
                else
                {
                    entry.pushAddress(parts[i]);
                }
            }
            addressBook.addEntry(entry);
            line = reader.readLine();
        }
        reader.close();

        return addressBook;
    }

    /**
     * Show the main menu, offering the user options to (1) search entries by
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    private static void showMenu(AddressBook addressBook)
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
