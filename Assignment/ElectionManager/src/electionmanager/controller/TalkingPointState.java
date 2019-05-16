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

public class TalkingPointState implements State
{
    //CLASSFIELDS
    UI ui;
    IO io;
    Set<TalkingPoint>talkingpoints;
    
    //DEFAULT CONSTRUCTOR
    public TalkingPointState(MenuController menuController,Set<TalkingPoint>talkingpoints,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        this.talkingpoints=talkingpoints;
    }


    //METHODS
    public void add()
    {

    }
    public void remove()
    {

    }
    public void view()
    {

    }

    public void load()
    {

    }
    
    public void save()
    {

    }
}