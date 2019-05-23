package edu.curtin.messaging;

import java.util.*;

public abstract class TwitterMessenger
{
    public TwitterMessenger() 
    {

    }
    /** Sends a private Twitter message to a given user. */
    public void sendPrivateMessage(String id, String message) 
    {

    }
    /**
    * Replaces the existing set of keywords to be monitored with a new set.
    */
    public void setKeywords(Set<String> keywords) 
    {}
    /**
    * Called by the monitoring thread after every search. For each keyword
    * being monitored, the map parameter contains the number of times that
    * keyword has been mentioned on Twitter since the previous search was
    * performed. The timestamp parameter is the time of the search,
    * measured in seconds since the "epoch" (01/01/1970).
    */
    protected abstract void keywordsDetected(Map<String,Integer> keywords,
    long timestamp);

}