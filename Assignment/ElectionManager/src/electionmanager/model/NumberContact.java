package electionmanager.model;

/*****
* Controller to the Add, Remove, View functions when observing Person Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class NumberContact extends Contact
{
    private int number;
    public NumberContact(String type, int number)
    {
        super(type);
        this.number=number;
    }
    public int getNumber()
    {
        return number;
    }
    public String getText()
    {
        return "";//empty class for override
    }
    @Override
    public String toString()
    {
        String outString = super.toString()+" "+number;
        return outString;
    }
}
