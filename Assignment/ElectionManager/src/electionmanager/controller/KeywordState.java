package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to the Add, Remove, View functions when observing Keyword Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class KeywordState implements State
{
    //CLASSFIELDS
    UI ui;
    IO io;
    Set<Keyword>keywords;
    
    //DEFAULT CONSTRUCTOR
    public KeywordState(MenuController menuController,Set<Keyword>keywords,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        this.keywords=keywords;
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