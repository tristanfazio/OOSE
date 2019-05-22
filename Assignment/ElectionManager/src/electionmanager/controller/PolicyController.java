package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to the Add, Remove, View functions when observing Policy Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PolicyController extends ObjectController
{
    //CLASSFIELDS--------------------------------------------------
    Map<String,PolicyArea> policies;
    
    //DEFAULT CONSTRUCTOR--------------------------------------------------
    public PolicyController(Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Policy Areas");
        this.policies=policies;
    }

    //METHODS--------------------------------------------------
    public void add()
    {
        //get policy name
        ui.printMessage("Enter Policy Name:");
        String name = io.getString();
        //get the policy type
        ui.printMessage("Choose Policy area:");
        String type = chooseType();
        //create policy object
        PolicyArea newPolicy = new PolicyArea(name,type);
        //add to policy storage
        policies.put(newPolicy.getName(),newPolicy);
        ui.printMessage(newPolicy.getName() + " created successfully!");
    }

    public void remove()
    {
        //get value to remove
        ui.printMessage("Enter the Name of the Policy you wish to remove");
        String name = io.getString();
        //check if policy exists
        if(policies.containsKey(name))
        {
            //found
            PolicyArea p = policies.get(name);
            //list talkingpoints and keywords
            ui.printMessage(name + " found");
            Set<TalkingPoint> tp = p.getTalkingPoints();
            if(!tp.isEmpty())
            {
                //has talking points
                ui.printMessage("Attached Talking Points: ");
                //print all talking points
                Iterator<TalkingPoint> iterator = tp.iterator();
                String outString = "";
                while(iterator.hasNext())
                {
                   outString+=(iterator.next().getWord());
                }
                ui.printMessage(outString);
            }
            Set<Keyword> kw = p.getKeywords();
            if(!kw.isEmpty())
            {
                //has talking points
                ui.printMessage("Attached Keywords: ");
                //print all talking points
                Iterator<Keyword> iterator = kw.iterator();
                String outString = "";
                while(iterator.hasNext())
                {
                   outString+=(iterator.next().getWord());
                }
                ui.printMessage(outString);
            }
            //check if remove ok?
            ui.printMessage("Would you still like to remove " + name+"?\n\t(1) Yes, (2) No,");
            int choice = io.getInt();
            if(choice==1)
            {
                //remove talking poitns and keywords
                tp.clear();
                kw.clear();
                //remove policy
                policies.remove(name);
                ui.printMessage("Removed " + name);
            }

        }
        else
        {
            //not found
            ui.printMessage(name + " not found");
        }
        
    }

    public void view()
    {
        if(policies.isEmpty())
        {
            ui.printMessage("There are no policies currently stored");
        }
        else
        {
            ui.printMessage("--------------------\nList of all Policies");
            for(Map.Entry<String, PolicyArea> entry : policies.entrySet())
            {
                PolicyArea p = entry.getValue();
                ui.printMessage(p.toString());
            }
            ui.printMessage("--------------------");
        }
    }

    private String chooseType()
    {
        int choice;
        String type ="";
        do
        {
            ui.printMessage("Select type:\n\t(1) Education, (2) Defence, (3) Workplace Relations, (4) Custom...");
            choice = io.getInt();
        }
        while(choice>4||choice<1);

        switch(choice)
        {
            case 1: type = "Education";
                break;
            case 2: type = "Defence";
                break;
            case 3: type = "Workplace Relations";
                break;
            case 4: ui.printMessage("Enter the name of the custom category");
                    type = io.getString(); 
                break;
        }  
        return type;
    }
}