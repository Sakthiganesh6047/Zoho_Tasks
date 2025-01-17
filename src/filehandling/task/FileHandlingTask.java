package filehandling.task;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import util.CustomException;

public class FileHandlingTask {
	
	 private FileHandlingTask() {}

	 private static class FileHandlingTaskHolder {
		 private static final FileHandlingTask INSTANCE = new FileHandlingTask();
	 }

	 public static FileHandlingTask getInstance() {
		 return FileHandlingTaskHolder.INSTANCE;
	 }
    
    public <T> String writeToFile(String fileName , T[] inputArray) throws CustomException {
    	try (FileWriter writer = new FileWriter(fileName)) {
            for (T line : inputArray) {
                writer.write(line + System.lineSeparator());
            }
            return ("File '" + fileName + "' created and content written successfully!");
        } catch (Exception e) {
            throw new CustomException("Error writing to file: " , e);
        }
    }
    
    public Path createFileInDir(String fileName, String dirName) throws CustomException {
        try {
            String baseDir = System.getProperty("user.dir");
            Path dirPath = Paths.get(baseDir, dirName);

            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            Path filePath = dirPath.resolve(fileName);

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            return filePath;
        } catch (Exception e) {
            throw new CustomException("Error occurred while creating the file", e);
        }
    }
    
    /*public Path createFileInDir(String baseDir , String dirName , String fileName) throws CustomException {
	 try {
		 
		 String fullDirPath = baseDir + dirName;
		 
        Path dirPath = Paths.get(fullDirPath);
        
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        Path FilePath = Paths.get(fullDirPath, fileName );

        if (!Files.exists(FilePath)) {
            Files.createFile(FilePath);
            return FilePath;
        } else {
       	 return FilePath;
        }

        } catch (Exception e) {
       	 throw new CustomException("Error occured in creating the file" , e);
        }
}*/

}
