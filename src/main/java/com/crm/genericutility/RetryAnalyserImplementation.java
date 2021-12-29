package com.crm.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provides implementation for iRetryAnalyser
 * @author SANDEEP K S
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
int count=0;
int retrycount=5;
	public boolean retry(ITestResult result) {
		while(count<=retrycount)
		{
			count++;
		return true;
	}
		return false;
	}
	}
