package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to the Add, Remove, View functions when observing Keyword Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class KeywordController extends ObjectController
{
    //CLASSFIELDS
    Map<String,Keyword>keywords;
    Map<String,PolicyArea>policies;
    
    //DEFAULT CONSTRUCTOR
    public KeywordController(Map<String,Keyword>keywords,Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Social Media Keywords");
        this.keywords=keywords;
        this.policies=policies;
    }

    //METHODS
    public void add()
    {
        //enter the keyword
        ui.printMessage("Enter the talking point:");
        String wordString = io.getString();
        //find the related policy
        PolicyArea relatedPolicy = findPolicy();
        //create the talking point
        if(relatedPolicy==null)
        {
            //no suitable policy, user chose to abort
            ui.printMessage("Keyword creation aborted");
        }
        else
        {
            Keyword keyword = new Keyword(wordString,relatedPolicy);
            //add to the related policies talking point set
            relatedPolicy.addKeyword(keyword);
            //add to talkingpoints storage map
            keywords.put(keyword.getWord(),keyword);
            ui.printMessage("Talking Point created successfully");
        }
    }
    public void remove()
    {
        //TP implementationc urrently bugged, @TODO: fix TP before implementing KW
    }
    public void view()
    {
        if(keywords.isEmpty())
        {
            ui.printMessage("There are no Keywords currently stored");
        }
        else
        {
            ui.printMessage("--------------------\nList of all Talking Points:");
            for(Map.Entry<String, Keyword> entry : keywords.entrySet())
            {
                Keyword kw = entry.getValue();
                ui.printMessage(kw.toString());
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