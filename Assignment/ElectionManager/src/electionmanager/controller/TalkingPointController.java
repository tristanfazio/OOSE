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
    Set<TalkingPoint>talkingpoints;

    //DEFAULT CONSTRUCTOR
    public TalkingPointController(Set<TalkingPoint>talkingpoints,UI ui,IO io)
    {
        super(ui,io,"Talking Points");
        this.talkingpoints=talkingpoints;
    }

    public String getContext()
    {
        return context;
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
}