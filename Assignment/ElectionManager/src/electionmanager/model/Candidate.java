package electionmanager.model;

import java.util.*;


/******
*Candidate Class
*Represents a Candidate object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class Candidate extends Person
{
    public Candidate(int inID, String inName, Set<Contact> inContacts)
    {
        super(inID,inName,inContacts);
        setType();
    }
    public void setType()
    {
        type = "Candidate";
    }
}