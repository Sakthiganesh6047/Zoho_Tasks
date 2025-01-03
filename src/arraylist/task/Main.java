package arraylist.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
		private static List<String> studentList;
		    public static void main(String[] args) {
		        String [] students = new String[] {"Sakthi","Ganesh", "Prabhakaran"};
		        addStudents(students);
		        students = new String[] {"Rohit", "Belci"};
		        addStudents(students);
		        System.out.print(studentList);
		    }
		    private static void addStudents(String[] students) {
		        if (studentList == null) {
		            studentList = new ArrayList<> (Arrays.asList(students));
		        }
		        else {
		            studentList.addAll(Arrays.asList(students));
		        }
		    }	    
}
