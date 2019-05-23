package edu.curtin.messaging;

import java.util.*;

public abstract class FacebookMessenger
{
    public FacebookMessenger() 
    {}
    public void sendPrivateMessage(String id, String message) 
    {}
    public void setKeywords(Set<String> keywords) 
    {}
    protected abstract void keywordsDetected(Map<String,Integer> keywords,
    long timestamp);
}
// Note: except for the word "Facebook", the declarations and functionality
// here are identical to the TwitterMessenger class.