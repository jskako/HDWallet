package com.example.hdwall.backend;

import java.util.List;

public class AutomateBoringStuff {

    public String convertListToString(List<String> words, String delimiter){
        StringBuilder builder = new StringBuilder();
        for (String details : words) {
            //Log.e("Details: ",details);
            builder.append(details +  delimiter);
        }
        String myWords = builder.toString();
        return myWords;
    }

}
