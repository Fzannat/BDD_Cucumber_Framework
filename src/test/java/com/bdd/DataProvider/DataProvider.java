package com.bdd.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class DataProvider {
    public Properties dataProp;
    public FileInputStream ip;
    public DataProvider() throws IOException {
        dataProp = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/bdd/TestData/TestData.properties");
        dataProp.load(ip);
    }
}
