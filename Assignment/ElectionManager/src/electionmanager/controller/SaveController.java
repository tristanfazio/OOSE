package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to save Objects to file.
* CURRENTLY A STUB 
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class SaveController implements IController
{
    //VARIABLES
    UI ui;
    String context;
    //CONSTRUCTOR
    public SaveController(Map<Integer,Person>people,Map<String,PolicyArea>policies,Map<String,TalkingPoint>talkingpoints,Map<String,Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
        context = "Save Data";
    }
    //METHODS
    public void execute()
    {
        ui.printMessage("Data Saved!");
    }

    public String getContext(){return context;}
}