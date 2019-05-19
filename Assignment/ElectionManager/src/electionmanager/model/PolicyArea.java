package electionmanager.model;

import java.util.*;


/******
*Person Class
*Represents a PolicyArea object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PolicyArea
{
    //CLASSFIELDS
    private String name;
    private String category;
    private Set<TalkingPoint> talkingPoints;
    private Set<Keyword> keywords;
    
    public PolicyArea(String inName, String inCategory)
    {   
        this.name = inName;
        this.category = inCategory;
        talkingPoints = new HashSet<TalkingPoint>();
        keywords = new HashSet<Keyword>();
    }

    //GETTERS
    public String getName(){return name;}
    public String getCategory(){return category;}
    public Set<TalkingPoint> getTalkingPoints(){return talkingPoints;}
    public Set<Keyword> getKeywords(){return keywords;}

    //SETTERS
    public void setName(String inName) 
    {
        this.name = inName;
    }
    public void setCategory(String inCategory)
    {
        this.category=inCategory;
    }
    public void addTalkingPoint(TalkingPoint inTalkingPoint)
    {
        talkingPoints.add(inTalkingPoint);
    }
    public void removeTalkingPoint(TalkingPoint inTalkingPoint)
    {
        talkingPoints.remove(inTalkingPoint);
    }
    public void addKeyword(Keyword inKeyword)
    {
        keywords.add(inKeyword);
    }
    public void removeKeyword(Keyword inKeyword)
    {
        keywords.remove(inKeyword);
    }
    
    //METHODS
    @Override
    public String toString()
    {
        System.out.println(1);
        String outString ="";
        outString += "\nName: " + name;
        outString += "\nCategory: " + category;
        outString += "\nTalking Points: ";
        if(talkingPoints.isEmpty())
        {
            System.out.println(2);
            outString += "\n\t" + "No talking points found";
        }
        else
        {
            System.out.println(3);
            for(TalkingPoint t : talkingPoints)
            {
                System.out.println(4);
                outString += "\n\t" + t.getWord();
            }
        }
        System.out.println(5);
        outString += "\nKeywords: ";
        if(keywords.isEmpty())
        {
            System.out.println(6);
            outString += "\n\t" + "No keywords found";
        }
        else
        {
            for(Keyword k : keywords)
            {
                System.out.println(7);
                outString += "\n\t" + k.getWord();
            }
        }
        System.out.println(8);
        return outString;
    }
}