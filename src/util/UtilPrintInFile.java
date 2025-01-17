package util;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

public class UtilPrintInFile {

    private static PrintStream originalOut = System.out;
    private static boolean isFileOutputSet = false;
    private static final Logger logger = Logger.getLogger(UtilPrintInFile.class.getName());

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

    public static <T> void printOutput(T value) throws CustomException {
        setUpFileOutput();
        logger.info((String) value);
        setUpConsoleOutput();
        isFileOutputSet = false;
    }
    
    public static <T> void writeOutput(T value , String fileName) throws CustomException {
        setUpFileOutput(fileName);
        logger.info((String) value );
        setUpConsoleOutput();
        isFileOutputSet = false;
    }
    
    private static void setUpFileOutput(String fileName) throws CustomException {
        if (!isFileOutputSet) {
            try {
                PrintStream fileOut = new PrintStream(new FileOutputStream(fileName , true));
                System.setOut(fileOut);
                isFileOutputSet = true;
            } catch (Exception e) {
                throw new CustomException("Error setting up file output: " + e.getMessage());
            }
        }
    }
}
