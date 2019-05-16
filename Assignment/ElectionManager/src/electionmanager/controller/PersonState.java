package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to the Add, Remove, View functions when observing Person Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PersonState implements State
{
    //CLASSFIELDS
    UI ui;
    IO io;
    Set<Person> people;

    //DEFAULT CONSTRUCTOR
    public PersonState(MenuController menuController,Set<Person>people,UI ui,IO io)
    {
        this.ui=ui;
        this.io=io;
        this.people=people;
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