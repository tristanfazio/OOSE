package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to handle menu operations and state shifts
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class MenuController
{
    //CLASS FIELDS
    Set<Person> people;
    Set<PolicyArea> policies;
    Set<TalkingPoint> talkingpoints;
    Set<Keyword> keywords;
    UI ui;
    IO io;
    State personState;
    State policyState;
    State talkingPointState;
    State keywordState;
    State state;
    State saveState;
    State loadState;

    //DEFAULT CONTSTRUCTOR
    public MenuController(UI ui,IO io,Set<Person>people,Set<PolicyArea>policies,Set<TalkingPoint>talkingpoints,Set<Keyword>keywords)
    {
        this.people = people;
        this.policies=policies;
        this.talkingpoints=talkingpoints;
        this.keywords=keywords;
        this.ui=ui;
        this.io=io;

        state=null;
        personState = new PersonState(this,people,ui,io);
        policyState = new PolicyState(this,policies,ui,io);
        talkingPointState = new TalkingPointState(this,talkingpoints,ui,io);
        keywordState = new KeywordState(this,keywords,ui,io);
        loadState = new LoadState(this,people,policies,talkingpoints,keywords,ui,io);
        saveState = new SaveState(this,people,policies,talkingpoints,keywords,ui,io);
    }

    //SETTERS
    public void setState(State state)
    {
        this.state = state;
    }

    //METHODS
    public void add()
    {
        state.add();
    }
    public void remove()
    {
        state.remove();
    }
    public void view()
    {
        state.view();
    }
    public void save()
    {
        state.save();
    }
    public void load()
    {
        state.load();
    }

    public void run()
    {
        int choice;
        String context ="";
        //out object loop
        do
        {
            ui.showObjectMenu();
            choice = io.getInt();
            switch(choice)
            {
                 //People
                case 1 : 
                            state = personState;
                            context = "People";
                    break;
                //Policy
                case 2 :    state = policyState;
                            context = "Policy Areas";   
                    break;
                //Talking Points
                case 3 :    state = talkingPointState;
                            context = "Talking Points";
                    break;
                //Key words
                case 4 :    state = keywordState;
                            context = "Social Media Key Words";
                    break;
                case 5 :    state = saveState;
                    break;
                case 6 :    state = loadState;
                    break;
                //Exit
                case 0:
                    break;
                //invalid selection
                default : ui.printMessage("please enter an appropriate selection");
                    break;
            }
            if(choice==5)
            {
                save();
            }
            else if(choice==6)
            {
                load();
            }
            else if(choice!=0)
            {
                //sub function menu
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
                }while(choice!=0);//exit inner sub function menu
                choice=999;//reset choice for outer loop
            }
        }while(choice!=0);//exit
    }
}