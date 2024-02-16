package utils;

import org.apache.log4j.Logger;

public class Log {
//    / Initialize Log4j logs
//intialize the log
    private static Logger Log = Logger.getLogger(Log.class.getName());//

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startOfTestCase(String sTestCaseName){
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("the test cases started"+sTestCaseName);
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }
  public static void logTheException(String exception){
      Log.info("****************************************************************************************");
      Log.info("*************************the Exception **************************************");
      Log.info("the exception is"+exception);
      Log.info("**********************************");

  }

    public static void endOfTestCase(String sTestCaseName){
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("the test cases ended"+sTestCaseName);
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }



}
