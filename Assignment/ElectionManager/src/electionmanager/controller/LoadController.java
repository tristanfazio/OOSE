package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to Load Objects from file
* CURRENTLY A STUB
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class LoadController implements IController
{
    UI ui;
    String context;
    public LoadController(Set<Person>people,Set<PolicyArea>policies,Set<TalkingPoint>talkingpoints,Set<Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
        context ="Load Data";
    }

    //GETTERS
    public String getContext()
    {
        return context;
    }

    public void execute()
    {
        ui.printMessage("Data Loaded!");
    }
}