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
    //CLASSFIELDS
    Set<PolicyArea> policies;
    
    //DEFAULT CONSTRUCTOR
    public PolicyController(Set<PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Policy Areas");
        this.policies=policies;
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