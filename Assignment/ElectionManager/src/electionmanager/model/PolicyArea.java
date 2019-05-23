package electionmanager.model;

import java.util.*;
import electionmanager.controller.ISubject;
import electionmanager.controller.IObserver;

/******
*Person Class
*Represents a PolicyArea object
*
*@author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PolicyArea implements ISubject
{
    //CLASSFIELDS
    private String name;
    private String category;
    private Set<TalkingPoint> talkingPoints;
    private Set<Keyword> keywords;
    private ArrayList<IObserver> observerList; 
    
    public PolicyArea(String inName, String inCategory)
    {   
        this.name = inName;
        this.category = inCategory;
        talkingPoints = new HashSet<TalkingPoint>();
        keywords = new HashSet<Keyword>();
        this.observerList = new ArrayList<IObserver>();
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
        notifyObserver("Policy " + name + " has a new Talking Point: " + inTalkingPoint.getWord());
        
    }
    public void removeTalkingPoint(TalkingPoint inTalkingPoint)
    {
        talkingPoints.remove(inTalkingPoint);
        notifyObserver("Policy " + name + " no longer has Talking Point: " + inTalkingPoint.getWord());
    }
    public void addKeyword(Keyword inKeyword)
    {
        keywords.add(inKeyword);
        notifyObserver("Policy " + name + " has a new Keyword on social Media: " + inKeyword.getWord());
    }
    public void removeKeyword(Keyword inKeyword)
    {
        keywords.remove(inKeyword);
        notifyObserver("Policy " + name + " no longer has Talking Point: " + inKeyword.getWord());
    }
    
    //METHODS
    @Override
    public String toString()
    {
        String outString ="";
        outString += "Name: " + name;
        outString += "\nCategory: " + category;
        outString += "\nTalking Points: ";
        if(talkingPoints.isEmpty())
        {
            outString += "\n\t" + "No talking points found";
        }
        else
        {
            for(TalkingPoint t : talkingPoints)
            {
                outString += "\n\t" + t.getWord();
            }
        }
        outString += "\nKeywords: ";
        if(keywords.isEmpty())
        {
            outString += "\n\t" + "No keywords found";
        }
        else
        {
            for(Keyword k : keywords)
            {
                outString += "\n\t" + k.getWord();
            }
        }
        return outString;
    }

    public void registerObserver(IObserver obs)
    {
        observerList.add(obs);
    }
    
    public void unregisterObserver(IObserver obs)
    {
        observerList.remove(obs);
    }

    public void notifyObserver(String message)
    {
        if(!observerList.isEmpty())
        {
            for (IObserver obs : observerList)
            {
                 obs.sendNotification(message);    
            }
        }
    }
}