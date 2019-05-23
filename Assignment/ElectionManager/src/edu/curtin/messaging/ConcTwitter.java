package edu.curtin.messaging;

import java.util.*;

public class ConcTwitter
{
    public ConcTwitter() 
    {
        super();
    }
    /**
    * Called by the monitoring thread after every search. For each keyword
    * being monitored, the map parameter contains the number of times that
    * keyword has been mentioned on Twitter since the previous search was
    * performed. The timestamp parameter is the time of the search,
    * measured in seconds since the "epoch" (01/01/1970).
    */
    protected void keywordsDetected(Map<String,Integer> keywords,long timestamp)
    {
        //TODO:implement
    }

}