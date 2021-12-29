package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author SANDEEP K S
 *
 */

public class FileUtility {
	/**
	 * its used to data from commonData.properties File based on key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Data.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		}
	}
