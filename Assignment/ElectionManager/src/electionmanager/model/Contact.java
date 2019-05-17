package electionmanager.model;

/*****
* Abstract class for a contact
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public abstract class Contact
{
    private String type;

    public Contact(String type)
    {
        this.type=type;       
    }

    public abstract int getNumber();
    public abstract String getText();
    public String toString()
    {
        return type + ":";
    }
}