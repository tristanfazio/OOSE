package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to handle menu operations and Controller shifts
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class MenuController
{
    //CLASS FIELDS
    private Map<Integer,Person> people;
    private Map<String,PolicyArea> policies;
    private Map<String,TalkingPoint> talkingpoints;
    private Map<String,Keyword> keywords;

    private UI ui;
    private IO io;

    private IController personController;
    private IController policyController;
    private IController talkingPointController;
    private IController keywordController;
    private IController saveController;
    private IController loadController;
    private IController exitController;

    private HashMap<Integer,IController> options;

    //DEFAULT CONTSTRUCTOR
    public MenuController(UI ui,IO io,Map<Integer,Person>people,Map<String,PolicyArea>policies,Map<String,TalkingPoint>talkingpoints,Map<String,Keyword>keywords)
    {
        //set dependency references
        this.people = people;
        this.policies=policies;
        this.talkingpoints=talkingpoints;
        this.keywords=keywords;
        this.ui=ui;
        this.io=io;

        //create Controller objects
        personController = new PersonController(people,ui,io);
        policyController = new PolicyController(policies,ui,io);
        talkingPointController = new TalkingPointController(talkingpoints,ui,io);
        keywordController = new KeywordController(keywords,ui,io);
        loadController = new LoadController(people,policies,talkingpoints,keywords,ui,io);
        saveController = new SaveController(people,policies,talkingpoints,keywords,ui,io);
        exitController = new ExitController(ui);

        //create STRATEGY options menu
        options = new HashMap<Integer,IController>();
        options.put(1,personController);
        options.put(2,policyController);
        options.put(3,talkingPointController);
        options.put(4,keywordController);
        options.put(5,loadController);
        options.put(6,saveController);
        options.put(0,exitController);
    }

    //METHODS
    public void run()
    {
        int choice;
        //out object loop
        do
        {
            //show the options menu
            ui.showObjectMenu(options);
            //get user choice
            choice = io.getInt();
            //switch the program Controller
            options.get(choice).execute();
        }while(choice!=0);//exit
    }
}