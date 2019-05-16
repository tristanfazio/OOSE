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

public class PolicyState implements State
{
    //CLASSFIELDS
    UI ui;
    IO io;
    Set<PolicyArea> policies;
    
    //DEFAULT CONSTRUCTOR
    public PolicyState(MenuController menuController,Set<PolicyArea>policies,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
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

    public void load()
    {

    }
    
    public void save()
    {

    }
}