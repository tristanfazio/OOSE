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

    public void showObjectMenu()
    {
        System.out.println("\nManage:");
        System.out.println("\t(1) People, (2) Policy Areas, (3) Talking Points, (4) Social Media Keywords, (5) Save Data, (6) Load Data, (0) Exit");
    }

    public void showFunctionMenu(String context)
    {
        System.out.println("\n" + context + ":");
        System.out.println("\n\t (1) Add, (2) Remove, (3) View, (0) Go Back");
    }
}