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

public class SaveState implements State
{
    UI ui;
    public SaveState(MenuController menuController,Set<Person>people,Set<PolicyArea>policies,Set<TalkingPoint>talkingpoints,Set<Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
    }
    public void save()
    {
        ui.printMessage("Data Saved!");
    }
    //METHODS
    public void add(){}
    public void remove(){}
    public void view(){}
    public void load(){}
}