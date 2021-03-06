import java.io.*;
import java.util.*;

/**
 * A simple address book application.
 * @author Dave and ...
 */
public class AddressBookApp
{
    /** Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        String fileName;

        System.out.print("\nEnter address book filename: ");
        fileName = input.nextLine();

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
        Entry entry = new Entry();
        boolean done = false;
        while(!done)
        {
            int option;
            System.out.println("(1) Search by name, (2) Search by email, (3) Quit");
            try
            {
                option = Integer.parseInt(input.nextLine());
                switch(option)
                {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        entry = addressBook.findName(name);
                        if(entry!=null)
                        {
                            System.out.println(entry.toString());
                        }
                        break;

                    case 2:
                        System.out.print("Enter email address: ");
                        String email = input.nextLine();
                        entry = addressBook.findAddress(email);
                        if(entry!=null)
                        {
                            System.out.println(entry.toString());
                        }
                        break;
                        
                    case 3:
                        done = true;
                        break;
                }
            }
            catch(NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
        }
    }
}
