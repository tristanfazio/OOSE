package electionmanager.controller;


import electionmanager.view.UI;
import electionmanager.controller.IO;


/*****
* Abstract Object Controller Class.
* Implements IController Interface to implement execute() from strategy pattern
* Abstractions allows sub object classes to define own behaviour
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public abstract class ObjectController implements IController
{
    //CLASSFIELDS
    UI ui;
    IO io;
    String context;
    public ObjectController(UI ui,IO io, String context)
    {
        this.ui = ui;
        this.io=io;
        this.context=context;
    }

    //GETTERS
    public String getContext()
    {
        return context;
    }

    //METHODS

    abstract void add();
    abstract void remove();
    abstract void view();

    //Handler function from STRATEGY
    //executes sub menu interactions for Person objects
    public void execute()
    {
        int choice;
        do
        {
            ui.showFunctionMenu(context);
            choice = io.getInt();
            switch(choice)
                    {
                        //add
                        case 1: add();
                            break;
                        //remove
                        case 2: remove();
                            break;
                        //view
                        case 3: view();
                            break;
                        //go back
                        case 0:
                            break;
                        //invalid selection
                        default: ui.printMessage("please enter an appropriate selection");
                            break;
                    }
        }while(choice!=0);//exit
    }
}