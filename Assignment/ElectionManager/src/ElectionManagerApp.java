import java.util.*;
import electionmanager.view.UI;
import electionmanager.model.*;
import electionmanager.controller.IO;
import electionmanager.controller.MenuController;

/*****
* Main app class for Election Manager
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class ElectionManagerApp
{
    public static void main(String[] args)
    {
        //Variables
        Map<Integer,Person> people = new HashMap<>();
        Map<String,PolicyArea> policies = new HashMap<>();
        Map<String,TalkingPoint> talkingpoints = new HashMap<>();
        Map<String,Keyword> keywords = new HashMap<>();
        UI ui = new UI();
        IO io = new IO();
        

        //Controllers setup and dependency injection
        MenuController menuController = new MenuController(ui,io,people,policies,talkingpoints,keywords);
        //show initial "header" splashscreen
        try
        {   
             //Print Menu Options
            ui.showStartupHeader();
            //start program by running menu cotnroller
            menuController.run();
            //menu exited, end program
           
        }
        //TODO: add proper exceptions
        catch(Exception e)
        {

        }

    }
}