package addressbook.controller;

/**
 * A simple address book application.
 * @author Dave and Tristan Fazio
 */

import java.io.*;
import java.util.*;
import addressbook.model.Entry;
import addressbook.model.AddressBook;
import addressbook.view.UI;


public class AddressBookApp
{
    /** Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);
    private static HashMap<Integer,Option> options;

    public static void main(String[] args)
    {
        String fileName = "";
        Option option;
        int choice;
        String text = null;
        boolean done = false;
        options = new HashMap<Integer,Option>();
        AddressBook addressBook = new AddressBook();
        UI ui  = new UI();

        try
        {
            //get filename
            ui.printMessage("Enter address book filename: ");
            fileName = input.nextLine();

            //read addressbook
            addressBook = readAddressBook(fileName);

            //create options list
            options.put(1,new SearchByName(addressBook));
            options.put(2,new SearchByEmail(addressBook));
            options.put(3,new PrintAll(addressBook));
        }
        catch(IOException e)
        {
            ui.printMessage("Could not read from " + fileName + ": " + e.getMessage());
        }

        ui.printMessage("Read Successfull");

        //show menu
        while(!done)
        {
            ui.showMenu(options, addressBook);
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
                ui.printMessage("Enter a number");
            }
            catch(NullPointerException e)
            {
                done=true;
            }
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
}
