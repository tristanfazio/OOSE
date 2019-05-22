package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to the Add, Remove, View functions when observing TalkingPoint Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class TalkingPointController extends ObjectController
{
    //CLASSFIELDS
    Map<String,TalkingPoint>talkingPoints;
    Map<String,PolicyArea>policies;

    //DEFAULT CONSTRUCTOR
    public TalkingPointController(Map<String,TalkingPoint>talkingpoints,Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Talking Points");
        this.talkingPoints=talkingpoints;
        this.policies=policies;
    }

    //METHODS
    public void add()
    {
        //enter the talking point
        ui.printMessage("Enter the talking point:");
        String wordString = io.getString();
        //find the related policy
        PolicyArea relatedPolicy = findPolicy();
        //create the talking point
        if(relatedPolicy==null)
        {
            //no suitable policy, user chose to abort
            ui.printMessage("Talking Point creation aborted");
        }
        else
        {
            TalkingPoint talkingPoint = new TalkingPoint(wordString,relatedPolicy);
            //add to the related policies talking point set
            relatedPolicy.addTalkingPoint(talkingPoint);
            //add to talkingpoints storage map
            talkingPoints.put(talkingPoint.getWord(),talkingPoint);
            ui.printMessage("Talking Point created successfully");
        }
    }

    public void remove()
    {
        
    }
    public void view()
    {
        if(talkingPoints.isEmpty())
        {
            ui.printMessage("There are no Talking Points currently stored");
        }
        else
        {
            ui.printMessage("--------------------\nList of all Talking Points:");
            for(Map.Entry<String, TalkingPoint> entry : talkingPoints.entrySet())
            {
                TalkingPoint tp = entry.getValue();
                ui.printMessage(tp.toString());
            }
            ui.printMessage("--------------------");
        }
    }

    private PolicyArea findPolicy()
    {
        int i = 1;
        String outString = "";
        //print ui message
        ui.printMessage("Choose the related policy area");
        //put current policies in a menu map, constructing outstring
        Map<Integer,PolicyArea> options = new HashMap<Integer,PolicyArea>();
        for(Map.Entry<String,PolicyArea> entry : policies.entrySet())
        {
            options.put(i,entry.getValue());
            outString+= "(" + i + ") " + entry.getValue().getName() + ", ";
            i++;
        }
        outString+= "(0) Abort";
        //print menu string to user
        ui.printMessage(outString);
        //get user input
        int choice = io.getInt();
        //get choice from menu map, will return null if no choice
        PolicyArea relatedPolicy = options.get(choice);
        //return
        return relatedPolicy;
    }
}