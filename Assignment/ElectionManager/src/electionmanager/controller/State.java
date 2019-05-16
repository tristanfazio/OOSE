package electionmanager.controller;

/*****
* Interface for State objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public interface State
{
    void add();
    void remove();
    void view();
    void save();
    void load();
}