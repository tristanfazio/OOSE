package edu.curtin.messaging;

import java.util.*;

public class SMS
{
    public SMS() 
    {
        
    }
    /** Sends an SMS to a given phone number. */
    public void sendSMS(long mobileNumber, String message) 
    {
        System.out.println("\n" + mobileNumber + " notified with message:\n\t" + message);
    }
}