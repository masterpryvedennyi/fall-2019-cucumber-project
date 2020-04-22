package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            //reads file in java. pass the path to file
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //initialize the object
            properties = new Properties();
            //load the contents of the file to the properties object
            properties.load(fileInputStream);
            fileInputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

