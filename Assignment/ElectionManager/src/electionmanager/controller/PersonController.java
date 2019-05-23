package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.controller.IDGenerator;
import electionmanager.model.*;
import edu.curtin.messaging.*;

/*****
* Controller to the Add, Remove, View functions when observing Person Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PersonController extends ObjectController
{
    //CLASSFIELDS--------------------------------------------------
    Map<Integer,Person> people;
    IDGenerator idGenerator;

    //DEFAULT CONSTRUCTOR
    public PersonController(Map<Integer,Person>people,UI ui,IO io)
    {
        super(ui,io,"People");
        this.people=people;
        idGenerator = IDGenerator.getInstance();
    }

    //GETTERS--------------------------------------------------
  

    //METHODS--------------------------------------------------

    //Implementation of the add method for Person Class
    //collects variables required to construct a person then creates the object, adding it to the people storage structure
    public void add()
    {
        //get name
        ui.printMessage("Enter Name:");
        String name = io.getString();
        //get type
        int type = chooseType();
        //get contact details
        ui.printMessage("Enter " + name + "'s contact information");
        Set<Contact> contacts = createContacts();
        //generate id
        int id = idGenerator.getNewID();
        //create person(determine by type)
        Person newPerson = createPerson(id,name,type,contacts);
        //add to people set
        people.put(id,newPerson);
        ui.printMessage(newPerson.getName() + " Created Successfully!");
    }

    //Implementation of the remove method for Person Class
    //searches the people object for the user specified "person" object, and removes it from storage
    public void remove()
    {
        ui.printMessage("Enter the ID of the person you wish to remove");
        int id = io.getInt();
        Person p = people.get(id);
        p = people.remove(id);
        if(p==null)
        {
            ui.printMessage("No one with ID of " + id + " found");
        }
        else
        {
            ui.printMessage("Person: " + p.getName() + " ID: " + p.getID() + "\nRemoved from storage ...");

        }
    }

    //Implementation of the view methods for Person Class
    //lists all the Person objects stored in the people storage.
    public void view()
    {
        if(people.isEmpty())
        {
            ui.printMessage("There are no people currently stored");
        }
        else
        {
            ui.printMessage("--------------------\nList of all People:");
            for(Map.Entry<Integer, Person> entry : people.entrySet())
            {
                Person p = entry.getValue();
                ui.printMessage(p.toString());
            }
            ui.printMessage("--------------------");
        }
    }

    //Private method to handle selecting which type of person to construct
    //Types include Candidate,Strategist,Volunteer
    private int chooseType()
    {
        int choice;
        do
        {
            ui.printMessage("Select type:\n\t(1) Candidate, (2) Strategist, (3) Volunteer");
            choice = io.getInt();
        }
        while(choice>3||choice<1);
        
        return choice;
    }

    //Private method to handle collecting a set of contact methods for a person object
    private Set<Contact> createContacts()
    {
        boolean done = false;
        Set<Contact> contacts = new HashSet<Contact>();
        String handle;
        int number;

        while(!done)
        {
            ui.printMessage("\t(1) Mobile, (2)Twitter ID, (3)Facebook ID");
            int choice = io.getInt();
            switch(choice)
            {
                //Mobile
                case 1: 
                    ui.printMessage("Enter a mobile number:");
                    number = io.getInt();
                    contacts.add(new NumberContact("Mobile",number));
                    break;
                //Twitter
                case 2:
                    ui.printMessage("Enter a Twitter ID:");
                    handle = io.getString();
                    contacts.add(new TextContact("Twitter",handle));
                    break;
                //Facebook    
                case 3:
                    ui.printMessage("Enter a Facebook ID:");
                    handle = io.getString();
                    contacts.add(new TextContact("Facebook",handle));
                    break;
            }
            ui.printMessage("Enter another contact? \n\t (1) YES, (2) NO");
           if(io.getInt()==2)
           {
               done = true;
           }
        }
        return contacts;
    }

    //Private method to handle the creation of a new person
    private Person createPerson(int id,String name,int type, Set<Contact> contacts)
    {
        Person newPerson = null;
        switch(type)
        {
            case 1: newPerson = new Candidate(id,name,contacts,new SMS(),new ConcTwitter(),new ConcFacebook());
                break;
            case 2: newPerson = new Strategist(id,name,contacts,new SMS(),new ConcTwitter(),new ConcFacebook());
                break;
            case 3: newPerson = new Volunteer(id,name,contacts,new SMS(),new ConcTwitter(),new ConcFacebook());
                break;
        }
        return newPerson;
    }
}