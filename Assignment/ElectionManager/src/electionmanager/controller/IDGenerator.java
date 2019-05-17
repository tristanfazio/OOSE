package electionmanager.controller;

public class IDGenerator
{
    private static IDGenerator uniqueInstance = null;
    int currentID = 0;
    private IDGenerator()
    {

    }
    public static IDGenerator getInstance()
    {
        if(uniqueInstance==null)
        {
            uniqueInstance = new IDGenerator();
        }
        return uniqueInstance;
    }
    public int getNewID()
    {
        currentID++;
        return currentID;
        //TODO: implement ID generator
    }
}