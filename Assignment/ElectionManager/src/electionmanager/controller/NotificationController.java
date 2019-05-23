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
    public NotificationController(Map<Integer,Person>people,Map<String,PolicyArea>policies,Map<String,TalkingPoint>talkingpoints,Map<String,Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        context ="Notifications";
    }

    //GETTERS
    public String getContext()
    {
        return context;
    }

    public void add(){};
    public void remove(){};

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