package com.example.helpers;

public class StringHelper {

    public static String capitalizeString(String projectName) {
        if (projectName == null || projectName.isEmpty()) {
            return projectName;
        }
        return projectName.substring(0, 1).toUpperCase() + projectName.substring(1);
    }
    
}
