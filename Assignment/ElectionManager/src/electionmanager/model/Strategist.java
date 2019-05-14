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

public class Strategist extends Person
{
    public Strategist(int inID, String inName, Set<Contact> inContacts)
    {
        super(inID,inName,inContacts);
        setType();
    }
    public void setType()
    {
        type = "Strategist";
    }
}