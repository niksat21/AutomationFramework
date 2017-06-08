package com.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by niksat21 on 2/21/2017.
 */
public class LoadPropFiles {

    private  Properties dataProp,locatorProp;
    private InputStream dataInputStream,locatorInputStream;

    public Properties getDataProp() throws IOException {
        dataProp = new Properties();
        String dataPropFileName = "data.properties";

        dataInputStream = getClass().getClassLoader().getResourceAsStream(dataPropFileName);
        if(dataInputStream!=null){
            dataProp.load(dataInputStream);
        }else {
            throw new FileNotFoundException("property file '" + dataPropFileName + "' not found in the classpath");
        }

        return dataProp;

    }

    public Properties getLocatorProp() throws IOException {
        //laoding locator prop file
        locatorProp = new Properties();
        String locatorPropFileName = "locator.properties";

        locatorInputStream = getClass().getClassLoader().getResourceAsStream(locatorPropFileName);
        if(locatorInputStream!=null){
            locatorProp.load(locatorInputStream);
        }else {
            throw new FileNotFoundException("property file '" + locatorPropFileName + "' not found in the classpath");
        }

        return locatorProp;
    }


}
