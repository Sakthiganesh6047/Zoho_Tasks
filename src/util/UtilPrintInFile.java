package util;

import java.io.FileOutputStream;
import java.io.PrintStream;
import exception.CustomException;

public class UtilPrintInFile {

    private static PrintStream originalOut = System.out;
    private static boolean isFileOutputSet = false;

    public static void setUpFileOutput() throws CustomException {
        if (!isFileOutputSet) {
            try {
                PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt", true));
                System.setOut(fileOut);
                isFileOutputSet = true;
            } catch (Exception e) {
                throw new CustomException("Error setting up file output: " + e.getMessage());
            }
        }
    }
    
    public static void setUpConsoleOutput() {
    	 System.setOut(originalOut);
    }

    public static void printOutput(String value) throws CustomException {
        setUpFileOutput();
        System.out.println(value);
        setUpConsoleOutput();
    }

    public static void printOutput(int value) throws CustomException {
        setUpFileOutput();
        System.out.println(value);
        setUpConsoleOutput();
    }
}
