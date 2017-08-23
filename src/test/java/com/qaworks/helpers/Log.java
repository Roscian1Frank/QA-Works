package com.qaworks.helpers;


import org.apache.log4j.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName){
		Log.info("***********************************************************");
		Log.info("$$$$$$$$$$$$$$$$" + sTestCaseName + "$$$$$$$$$$$$$$$$");
		Log.info("***********************************************************");
	}


	public static void endTestCase(String sTestCaseName){
		Log.info("***********************************************************");
		Log.info("$$$$$$$$$$$$$$$$" + "E N D  Testcase"+ "$$$$$$$$$$$$$$$$");
		Log.info("***********************************************************");
	}

	public static void info(String message)
	{
		Log.info(message);
	}

}