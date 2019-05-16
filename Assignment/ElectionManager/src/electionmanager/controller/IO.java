package electionmanager.controller;

import java.util.*;

/*****
* IO class to handle user input
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class IO
{
    Scanner scan = new Scanner(System.in);  // Create a Scanner object

    public int getInt()
    {
        return scan.nextInt();
    }
}