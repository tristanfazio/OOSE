package electionmanager.view;

import java.util.*;

/*****
* UI class to handle interaction with user
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class UI
{
    //CLASSFIELDS

    public UI()
    {

    }
    public void printMessgage(String message)
    {
        System.out.println("/n"+message);
    }
    public void showStartupHeader()
    {
        System.out.println("---------- Election Manager 9000 ----------");
        System.out.println("\n Manage:");
        System.out.println("\t (1) People, (2)Policy Areas, (3) Talking Points, (4)Social media Keywords");
        System.out.println("\n=>");
    }
}