package electionmanager.controller;

import java.util.*;
import electionmanager.view.UI;
import electionmanager.controller.IO;
import electionmanager.model.*;


/*****
* Controller to the Add, Remove, View functions when observing Policy Objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public class PolicyController extends ObjectController
{
    //CLASSFIELDS--------------------------------------------------
    Map<String,PolicyArea> policies;
    
    //DEFAULT CONSTRUCTOR--------------------------------------------------
    public PolicyController(Map<String,PolicyArea>policies,UI ui,IO io)
    {
        super(ui,io,"Policy Areas");
        this.policies=policies;
    }

    //METHODS--------------------------------------------------
    public void add()
    {
        //get policy name
        ui.printMessage("Enter Policy Name:");
        String name = io.getString();
        //get the policy type
        ui.printMessage("Choose Policy area:");
        String type = chooseType();
        //create policy object
        PolicyArea newPolicy = new PolicyArea(name,type);
        //add to policy storage
        policies.put(newPolicy.getName(),newPolicy);
    }

    public void remove()
    {

    }

    public void view()
    {

    }

    private String chooseType()
    {
        int choice;
        String type ="";
        do
        {
            ui.printMessage("Select type:\n\t(1) Education, (2) Defence, (3) Workplace Relations, (4) Custom...");
            choice = io.getInt();
        }
        while(choice>4||choice<1);
        
        return type;
    }
}