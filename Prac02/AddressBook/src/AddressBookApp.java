import java.io.*;
import java.util.*;

/**
 * A simple address book application.
 * @author Dave and Tristan Fazio
 */

public class AddressBookApp
{
    /** Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);
    private static Map<int,Option> options;

    public static void main(String[] args)
    {
        String fileName, entryName;

        System.out.print("\nEnter address book filename: ");
        fileName = input.nextLine();
        options = new HashMap<int,Option>();
        options.put(1,new SearchByName(AddressBook));
        options.put(2,new SearchByEmail(AddressBook));

        try
        {
            AddressBook addressBook = readAddressBook(fileName);
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
        String entry;
        Option option;
        int choice;

        while(!done)
        {
            String text = null;
            int option;
            System.out.println("(1) Search by name, (2) Search by email, (3) Quit");
            try
            {
                choice = Integer.parseInt(input.nextLine());

                option = options.get(choice);
                if(option.reqText())
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
