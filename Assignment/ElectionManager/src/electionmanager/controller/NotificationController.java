package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to Add and Remove Notifications to People
* 
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class NotificationController implements IController
{
    UI ui;
    IO io;
    String context;
    Map<Integer,Person>people;
    Map<String,PolicyArea>policies;

    public NotificationController(Map<Integer,Person>people,Map<String,PolicyArea>policies,Map<String,TalkingPoint>talkingpoints,Map<String,Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        context ="Notifications";
        this.people = people;
        this.policies = policies;
    }

    //GETTERS
    public String getContext()
    {
        return context;
    }

    public void add()
    {
        Person person;
        PolicyArea policy;
        ui.printMessage("Choose which Person you wish to have notified");
        //print people map
        for (Map.Entry<Integer,Person> entry : people.entrySet())
         {
            ui.printMessage("(" + entry.getKey() + "), " + entry.getValue().getName());
        }
        //get person
        person = people.get(io.getInt());
        ui.printMessage("Enter the name of the Policy for " + person.getName() + " to be notified about");
        //print policy map
        for (Map.Entry<String,PolicyArea> entry : policies.entrySet())
         {
            ui.printMessage(entry.getKey());
        }
        //get policy
        policy = policies.get(io.getString());
        //register person in policy
        policy.registerObserver(person);
        ui.printMessage(person.getName() + " will be notified of changes to " + policy.getName());
    }
    public void remove()
    {
        //TODO:implement
    }

    public void execute()
    {
        int choice;
        do
        {
            ui.showNotificationMenu(context);
            choice = io.getInt();
            switch(choice)
                    {
                        //add
                        case 1: add();
                            break;
                        //remove
                        case 2: remove();
                            break;
                        //go back
                        case 0:
                            break;
                        //invalid selection
                        default: ui.printMessage("please enter an appropriate selection");
                            break;
                    }
        }while(choice!=0);//exit
    }
}