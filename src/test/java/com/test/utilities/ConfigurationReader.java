package com.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //New object from Properties class, provides methods for handle the file
    //priate for make it inaccesible from outside
    private static Properties properties=new Properties();
    //having static block because static runs first
    static {
        try {
            //FileInputStream to open the file
            FileInputStream file = new FileInputStream("configuration.properties");
            //load the opened file
            properties.load(file);
        } catch (IOException exception) {
            System.out.println("File not found in ConfigurationReader class");
            exception.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
