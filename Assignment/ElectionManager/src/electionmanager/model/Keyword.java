package electionmanager.model;

/******
*Keyword Class
*Represents a Keyword object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class Keyword
{
    //CLASSFIELDS
    private String wordString;
    private PolicyArea relatedPolicy;

    public Keyword(String inWordString, PolicyArea inRelatedPolicy)
    {
        this.wordString=inWordString;
        this.relatedPolicy=inRelatedPolicy;
    }

    //GETTERS
    public String getWord(){return wordString;}
    public PolicyArea getRelatedPolicy(){return relatedPolicy;}

    //METHODS
    @Override
    public String toString()
    {
        String outString = "Keyword: " + wordString;
        outString += "\n\t Related to: " + relatedPolicy.getName();
        return outString;
    }
}