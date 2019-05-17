package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;

/*****
* Controller to Exit the program
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class ExitController implements IController
{
    UI ui;
    String context;
    public ExitController(UI ui)
    {
        this.ui=ui;
        context = "Exit";
    }

    public void execute()
    {
        ui.printMessage("Goodbye!");
    }

    public String getContext(){return context;}
}