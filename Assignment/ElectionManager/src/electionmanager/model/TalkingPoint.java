package electionmanager.model;

import java.util.*;


/******
*TalkingPoint Class
*Represents a TalkingPoint object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class TalkingPoint
{
    //CLASSFIELDS
    private String wordString;
    private PolicyArea relatedPolicy;

    public TalkingPoint(String inWordString, PolicyArea inRelatedPolicy)
    {
        this.wordString=inWordString;
        this.relatedPolicy=inRelatedPolicy;
    }

    //GETTERS
    public String getWord(){return wordString;}
    public PolicyArea getRelatedPolicy(){return relatedPolicy;}
}