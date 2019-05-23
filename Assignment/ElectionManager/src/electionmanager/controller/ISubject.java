package electionmanager.controller;

/*****
* Interface for Subject observer pattern objects
* 
* @author Tristan Fazio
*Object Oriented Software Engineering
*Semester One, 2019
*Curtin University
******/

public interface ISubject
{
    void registerObserver(IObserver obs);
    void unregisterObserver(IObserver obs);
    void notifyObserver(String Message);
}