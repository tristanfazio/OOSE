package electionmanager.view;

import java.util.*;
import electionmanager.controller.IController;

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
    public void printMessage(String message)
    {
        System.out.println("\n"+message);
    }
    public void showStartupHeader()
    {
        System.out.println("\n");
        System.out.println("-------------------- \tElection Manager 9000\t--------------------");
        System.out.println("Author: Tristan Fazio\tObject Oriented Software Engineering\tSemester 1 2019");
    }

    public void showObjectMenu(HashMap<Integer,IController> options)
    {
        System.out.println("\nManage:");
        String menuString ="\t";
        int i;
        //print options in menu string, except final exit option as 0 key at end of string
        for(i=0;i<options.size()-1;i++)   
        {
            menuString+="(" + (i+1) + ") " + options.get(i+1).getContext() + " ";
        }
        //append quit option
        menuString+="(0) Quit";
        System.out.println(menuString);
    }

    public void showFunctionMenu(String context)
    {
        System.out.println("\n" + context + ":");
        System.out.println("\n\t (1) Add, (2) Remove, (3) View, (0) Go Back");
    }
}