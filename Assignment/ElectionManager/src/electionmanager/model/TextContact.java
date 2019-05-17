package electionmanager.model;

/*****
* Object to hold a text type Contact
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class TextContact extends Contact
{
    private String id;
    public TextContact(String type, String id)
    {
        super(type);
        this.id = id;
    }

    public String getText()
    {
        return id;
    }
    public int getNumber()
    {
        return 0;//empty method for override
    }
    @Override
    public String toString()
    {
        String outString = super.toString()+" "+id;
        return outString;
    }
}