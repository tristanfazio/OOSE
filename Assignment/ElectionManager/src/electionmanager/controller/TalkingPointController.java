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
    Map<String,TalkingPoint>talkingpoints;
    Map<String,PolicyArea>policies;

    //DEFAULT CONSTRUCTOR
    public TalkingPointController(Map<String,TalkingPoint>talkingpoints,Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Talking Points");
        this.talkingpoints=talkingpoints;
        this.policies=policies;
    }

    //METHODS
    public void add()
    {
        //enter the talking point
        
    }
    public void remove()
    {

    }
    public void view()
    {

    }
}