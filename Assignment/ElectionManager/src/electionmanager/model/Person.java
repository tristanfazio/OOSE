package electionmanager.model;

import java.util.*;


/******
*Person Class
*Represents a person object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public abstract class Person
{
    //CLASSFIELDS
    private int idNum;
    private String name;
    protected String type;
    private Set<Contact> contacts;
    //CONSTRUCTOR
    public Person(int inID, String inName, Set<Contact> inContacts)
    {
        this.idNum = inID;
        this.name = inName;
        this.contacts = inContacts;
    }
    //GETTERS
    public int getID(){return idNum;}
    public String getName(){return name;}
    public String getType(){return type;}
    public Set<Contact> getContacts(){return contacts;}
    //SETTERS
    public void setID(int inID)
    {
        this.idNum = inID;
    }

    public void setName(String inName)
    {
        this.name = inName;
    }

    abstract void setType();

    public void addContact(Contact inContact)
    {
        contacts.add(inContact);
    }
    
    public void removeContact(Contact inContact)
    {
        contacts.remove(inContact);
    }
    //METHODS

}