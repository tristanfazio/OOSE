package electionmanager.model;

import java.util.*;
import electionmanager.controller.IObserver;
import edu.curtin.messaging.*;

/******
*Person Class
*Represents a person object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public abstract class Person implements IObserver
{
    //CLASSFIELDS
    private int idNum;
    private String name;
    protected String type;
    private Set<Contact> contacts;

    SMS smsMessenger;
    TwitterMessenger twitterMessenger;
    FaceBook facebookMessenger;
    //CONSTRUCTOR
    public Person(int inID, String inName, Set<Contact> inContacts,SMS smsMessenger,TwitterMessenger twitterMessenger,FacebookMessenger facebookMessenger)
    {
        this.idNum = inID;
        this.name = inName;
        this.contacts = inContacts;

        this.smsMessenger = smsMessenger;
        this.twitterMessenger = twitterMessenger;
        this.facebookMessenger = facebookMessenger;
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
    public String toString()
    {
        String outString ="";
        outString += "\nID: " + idNum;
        outString += "\nName: " + name;
        outString += "\nType: " + type;
        outString += "\nContacts: ";
        for(Contact c : contacts)
        {
            outString += "\n\t" + c.toString();
        }
        return outString;
    }

    public void sendNotification(String message)
    {
        //person cant exist without atleast 1 contact, no verification needed
        for (Contact c : contacts) 
        {
            String type = c.getType();
            switch(type)
            {
                case "Mobile": smsMessenger.sendSMS((long)c.getNumber(),message);
                    break;
                case "Twitter":twitterMessenger.sendPrivateMessage(c.getText(),message);
                    break;
                case "Facebook":facebookMessenger.sendPrivateMessage(c.getText(),message);
                    break;
            }
        }
    }

}