package com.crm.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author SANDEEP K S
 *
 */

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */

	public int getRanDomNumber() {
		Random random=new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
	}
	/**
	 * used to get system data & time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * used to got system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormate() {
		Date date=new Date();
		String dateAndTime=date.toString();
		
		String YYYY=dateAndTime.split("")[5];
		String DD=dateAndTime.split("")[2];
		int MM=date.getMonth()+1;
		
		String FinalFormate=YYYY+"-"+MM+"-"+DD;
		 
		return FinalFormate;
	}
}
		
		

	


