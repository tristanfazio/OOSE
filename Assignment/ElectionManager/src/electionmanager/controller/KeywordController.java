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

public class KeywordController extends ObjectController
{
    //CLASSFIELDS
    Map<String,Keyword>keywords;
    
    //DEFAULT CONSTRUCTOR
    public KeywordController(Map<String,Keyword>keywords,Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Social Media Keywords");
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
}