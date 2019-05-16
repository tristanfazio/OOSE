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
        Set<Person> people = new HashSet<>();
        Set<PolicyArea> policies = new HashSet<>();
        Set<TalkingPoint> talkingpoints = new HashSet<>();
        Set<Keyword> keywords = new HashSet<>();
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