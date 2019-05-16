package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to the Add, Remove, View functions when observing Person Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PersonState implements State
{
    //CLASSFIELDS
    UI ui;
    IO io;
    Set<Person> people;
    MenuController menuController;

    //DEFAULT CONSTRUCTOR
    public PersonState(MenuController menuController,Set<Person>people,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        this.people=people;
        this.menuController=menuController;
    }


    //METHODS
    public void add()
    {
        //get name
        ui.printMessage("Enter Name:");
        String name = io.getString();
        //get type
        String type = getType();
        //get contact details
        contacts = getContacts();
        //generate id
        int id = idGenerator.getNewID();
        //create person(determine by type)
        Person newPerson = getPerson(id,name,type,contacts);
        //add to people set
        people.add(newPerson);
        menuController.setState(null);
    }
    public void remove()
    {

    }
    public void view()
    {

    }

    public void load()
    {
        //empty method
    }
    
    public void save()
    {
        //empty method
    }

    private String getType()
    {
        int choice;
        String type;
        do
        {
            ui.printMessage("Select type:\n\t(1) Candidate, (2) Strategist, (3) Volunteer");
            choice = io.getInt();
        }
        while(choice>3||choice<1);
        switch(choice)
        {
            case 1: type = "Candidate";
                break;
            case 2: type = "Strategist";
                break;
            case 3: type = "Volunteer";
                break;
        }
        return type;
    }
    private Set<Contact> getContacts()
    {

    }
    private Person getPerson()
    {

    }
}