package edu.matc.utilities;

import java.io.*;
import java.util.*;


/**
 * The interface Properties loader.
 */
public interface PropertiesLoader{

    /**
     * Load properties properties.
     *
     * @param propertiesFilePath the properties file path
     * @return the properties
     * @throws Exception the exception
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try (var input = this.getClass().getResourceAsStream(propertiesFilePath)) {
            if (input == null) {
                throw new FileNotFoundException("Properties file not found: " + propertiesFilePath);
            }
            properties.load(input);
        }
        return properties;
    }
}