package basicprogramming.task;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import util.CustomException;

public class BasicProgrammingTask {
	
	 private BasicProgrammingTask() {}

	 private static class FileHandlingTaskHolder {
		 private static final BasicProgrammingTask INSTANCE = new BasicProgrammingTask();
	 }

	 public static BasicProgrammingTask getInstance() {
		 return FileHandlingTaskHolder.INSTANCE;
	 }
    
    public <T> String writeToFile(String fileName , String[] inputArray)  throws CustomException {
    	try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : inputArray) {
                writer.write(line + System.lineSeparator());
            }
            return ("File '" + fileName + " created and content written successfully!");
        } catch (Exception e) {
            throw new CustomException("Error writing to file: " , e);
        }
    }
    
    public Path createFileInDir(String dirName, String fileName) throws CustomException {
        try {
            Path dirPath = Paths.get(dirName);

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
}
