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

public class LoadState implements State
{
    UI ui;
    public LoadState(MenuController menuController,Set<Person>people,Set<PolicyArea>policies,Set<TalkingPoint>talkingpoints,Set<Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
    }
    public void load()
    {
        ui.printMessage("Data Loaded!");
    }

    //METHODS
    public void add(){}
    public void remove(){}
    public void view(){}
    public void save(){}
}