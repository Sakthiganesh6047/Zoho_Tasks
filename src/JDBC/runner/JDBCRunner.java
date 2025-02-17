package JDBC.runner;

import java.util.ArrayList;
import java.util.List;
import JDBC.employee.EmployeeDBO;
import JDBC.employee.Dependent;
import JDBC.employee.Employee;
import util.CustomException;
import util.UtilGetInput;
import util.UtilPrintOutput;
import org.json.JSONArray;
import org.json.JSONObject;

public class JDBCRunner {
	
	String url = "jdbc:mysql://localhost:3306/incubationDB";
    String user = "root";
    String password;
    
    EmployeeDBO employeeDBO = new EmployeeDBO();

    public static void main(String[] args) {
    	JDBCRunner runner = new JDBCRunner();
    	runner.runOperations();
    	}
    
    private void setPassword() {
    	String password = UtilGetInput.getStringInput("Enter the Password for SQL Database to access it: ");
    	this.password = password;
    }
    	
    private void runOperations() {
    	
    	try {
    		
	    	setPassword();
	    	EmployeeDBO.prepareConnectionPool(url, user, password);
	    	
	    	int enteredChoice = 0;
	    		
			do {
				
				try {
				
					System.out.println("1. Create a Employee Table");
					System.out.println("2. Enter data into Employee Table");
					System.out.println("3. Fetch Employee using Employee Name");
					System.out.println("4. Update values in the Empolyee Table");
					System.out.println("5. Delete the record based on EmployeeId");
					System.out.println("6. Accessing Employee POJO");
					System.out.println("7. Create a Employee Dependent Table");
					System.out.println("8. Add data to Employee Dependent Table");
					System.out.println("9. Fetching Dependencies using Empolyee_ID");
					System.out.println("10. n Records of joined Tables");
					System.out.println("0. Terminate Program");
					enteredChoice = UtilGetInput.getIntInput("Enter the choice of operation: ");
					
					 if (enteredChoice < 0 || enteredChoice > 10) {
						 System.out.println("Invalid Choice, Enter a choice from 0 to 10");
					 }
					
					switch(enteredChoice) {
					case 1:
						exercise1();
						break;
						
					case 2:
						exercise2();
						break;
						
					case 3:
						exercise3();
						break;
						
					case 4:
						exercise4();
						break;
						
					case 5:
						exercise7();
						break;
						
					case 6:
						exercise8();
						break;
						
					case 7:
						exercise9();
						break;
						
					case 8:
						exercise10();
						break;
						
					case 9:
						exercise11();
						break;
						
					case 10:
						exercise12();
						break;
						
					case 11:
						exercise2_1();
						break;
						
					case 12:
						exercise2_2();
						break;
						
					case 0:
						System.out.println("Terminated Successfully!");
						break;
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			while (enteredChoice != 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EmployeeDBO.closePool();
		}
    }
    	
    private void exercise1() throws CustomException {
    	String msg = employeeDBO.createTable();
    	UtilPrintOutput.printOutput(msg);
	}
    	
	private void exercise2() throws CustomException {
		
		int employeecount = UtilGetInput.getIntInput("Enter the No. of employee details you want to add: ");

        for (int i = 1; i <= employeecount; i++) {
            System.out.println("\n🔹 Enter details for Employee #" + i);
            //int employeeID = UtilGetInput.getIntInput("Enter Employee ID: ");
            String name = UtilGetInput.getStringInput("Enter Name: ");
            String mobile = UtilGetInput.getStringInput("Enter Mobile Number: ");
            String email = UtilGetInput.getStringInput("Enter Email ID: ");
            String department = UtilGetInput.getStringInput("Enter Department: ");
            boolean status = employeeDBO.addEmployeeDetail(name, mobile, email, department);;
            if (!status) {
            	System.out.println(" Employee #" + i + " added successfully!");
            } else {
            	System.out.println("An error occurred while adding Employee #" + i );
            }
        }
    }
	
	private void exercise2_1() throws CustomException {
        
        int count = UtilGetInput.getIntInput("Enter number of employees to insert: ");
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            String name = UtilGetInput.getStringInput("Name: ");
            String mobile = UtilGetInput.getStringInput("Mobile: ");
            String email = UtilGetInput.getStringInput("Email: ");
            String department = UtilGetInput.getStringInput("Department: ");
            employeeList.add(new Employee(name, mobile, email, department));
        }
		int[] rowsInserted = employeeDBO.addNEmployeeDetails(employeeList);
		System.out.println("Batch insert successful. Rows inserted: " + rowsInserted.length);
	}
	
	private void exercise2_2() throws CustomException {
		String jsonInput = createJson();
		System.out.println(jsonInput);
		int[] rowsInserted = employeeDBO.addEmployeesFromJson(jsonInput);
		System.out.println("Batch insert successful. Rows inserted: " + rowsInserted.length);
	}
	
	private String createJson() throws CustomException {
		
        JSONArray userArray = new JSONArray();
        int count = UtilGetInput.getIntInput("Enter the number of users: ");

        for (int i = 1; i <= count; i++) {
            JSONObject user = new JSONObject();
            System.out.println("\nEnter details for User " + i + ":");
            String name = UtilGetInput.getStringInput("Name: ");
            String mobile = UtilGetInput.getStringInput("Mobile: ");
            String email = UtilGetInput.getStringInput("Email: ");
            String department = UtilGetInput.getStringInput("Department: ");
            user.put("name", name);
            user.put("mobile", mobile);
            user.put("email", email);
            user.put("department", department);
            userArray.put(user);
        }

        return userArray.toString();
    }

	private void exercise3() throws CustomException {
	    String searchName = UtilGetInput.getStringInput("Enter employee name to search: ");
	    List<Employee> employees = employeeDBO.fetchEmployeeByName(searchName);
	    
	    if (employees.isEmpty()) {
	    	System.out.println("No employees found in the name " + searchName);
	    }

	    for (Employee emp : employees) {
	        System.out.println("Employee Name: " + emp.getName());
	        System.out.println("Dependent ID: " + emp.getMobile());
	        System.out.println("Dependent Name: " + emp.getEmail());
	        System.out.println("Relationship: " + emp.getDepartment());
	        System.out.println("--------------------------------------");
	    }
	}
        
    private void exercise4() throws CustomException {
   
        int employeeId = UtilGetInput.getIntInput("Enter Employee ID to update: ");
        
        System.out.println("\nSelect the field to update:");
        System.out.println("1. Department");
        System.out.println("2. Mobile");
        System.out.println("3. Email");
        
        int choice = UtilGetInput.getIntInput("Enter your choice (1-3): ");

        String columnToUpdate = null;
        String newValue = null;

        switch (choice) {
            case 1:
                columnToUpdate = "DEPARTMENT";
                newValue = UtilGetInput.getStringInput("Enter new Department: ");
                break;
            case 2:
                columnToUpdate = "MOBILE";
                newValue = UtilGetInput.getStringInput("Enter new Mobile number: ");
                break;
            case 3:
                columnToUpdate = "EMAIL";
                newValue = UtilGetInput.getStringInput("Enter new Email: ");
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                return;
        }
        
        int rowsAffected = employeeDBO.updateDetails(employeeId, columnToUpdate, newValue);
        
        if (rowsAffected > 0) {
            System.out.println(" Employee details updated successfully!");
        } else {
            System.out.println(" No employee found with ID: " + employeeId);
        }
 
    }
    
    private void exercise7() throws CustomException {
        int employeeId = UtilGetInput.getIntInput("Enter Employee ID to delete: ");
        
        boolean isDeleted = employeeDBO.deleteEmployeeById(employeeId);
        
        if (isDeleted) {
            System.out.println("Employee with ID " + employeeId + " deleted successfully.");
        } else {
            System.out.println("No employee found with ID " + employeeId + ".");
        }
    }

    	
    private void exercise8() throws CustomException {
    	
    	EmployeeDBO employeeDBO = new EmployeeDBO();

        System.out.println("Enter Employee Details:");
        String name = UtilGetInput.getStringInput("Name: ");
        String mobile = UtilGetInput.getStringInput("Mobile Number: ");
        String email = UtilGetInput.getStringInput("Email Id: ");
        String department = UtilGetInput.getStringInput("Department: ");

        Employee newEmployee = new Employee(name, mobile, email, department);
        String msg = employeeDBO.insertEmployee(newEmployee);
        System.out.println(msg);

        int empId = UtilGetInput.getIntInput("\nEnter Employee ID to Fetch Details: ");
        Employee fetchedEmployee = employeeDBO.getEmployeeById(empId);
        if (fetchedEmployee != null) {
            System.out.println("\nRetrieved Employee Details:");
            System.out.println(fetchedEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        int count1 = UtilGetInput.getIntInput("\nEnter number of employees to fetch:");
        List<Employee> employees1 = employeeDBO.getFirstNEmployees(count1);
        System.out.println("\nFirst " + count1 + " Employees:");
        for (Employee emp : employees1) {
            System.out.println(emp);
        }
        
        int count2 = UtilGetInput.getIntInput("\nEnter number of employees to fetch in Ascending Order: ");
        List<Employee> employees2 = employeeDBO.getFirstNEmployeesInAsc(count2);
        System.out.println("\nFirst " + count2 + " Employees in Ascending Order: ");
        for (Employee emp : employees2) {
            System.out.println(emp);
        }
    	
    }
    
    private void exercise9() throws CustomException {
    	String msg = employeeDBO.createDependentTable();
    	UtilPrintOutput.printOutput(msg);
	}
    
    private void exercise10() throws CustomException {
        int employeeId = UtilGetInput.getIntInput("Enter Employee ID to add dependents: ");
        int count = UtilGetInput.getIntInput("Enter the no. of Dependents to add: ");
        
        for (int i = 1; i <= count; i++) {
            System.out.println("Enter details for Dependent " + i + ":");
            String depName = UtilGetInput.getStringInput("Enter Dependent Name: ");
	        String relationship = UtilGetInput.getStringInput("Enter Relationship: ");
	        int age = UtilGetInput.getIntInput("Enter Dependent age: ");
	        int rowsAffected = employeeDBO.insertDependentDetails(employeeId, depName, relationship, age);
	        if (rowsAffected > 0) {
	        	System.out.println("Dependents added successfully for Employee ID: " + employeeId);
	        } else {
	            System.out.println(" No employee found with ID: " + employeeId);
	        }
        }
    }

        
    private void exercise11() throws CustomException {
    	
	    int empId = UtilGetInput.getIntInput("Enter Employee ID: ");
	    List<Dependent> dependents = employeeDBO.getDependenciesWithEmpId(empId);

	    if (dependents.isEmpty()) {
	        System.out.println("No dependents found for Employee ID: " + empId);
	    } else {
	        for (Dependent dep : dependents) {
	            System.out.println("Employee ID: " + dep.getEmployeeId());
	            System.out.println("Employee Name: " + dep.getEmployeeName());
	            System.out.println("Dependent ID: " + dep.getDependentId());
	            System.out.println("Dependent Name: " + dep.getDependentName());
	            System.out.println("Relationship: " + dep.getRelationship());
	            System.out.println("--------------------------------------");
	        }
	    }
	}
     
    private void exercise12() throws CustomException {
    	
    	int count = UtilGetInput.getIntInput("Enter the No. of Employee details to fetch in ascending order: ");
    	List<Dependent> dependents = employeeDBO.getnEntriesInAsc(count);
    	
    	if (dependents.isEmpty()) {
	        System.out.println("No dependents found for the specified limit");
	    } else {
	        for (Dependent dep : dependents) {
	            System.out.println("Employee ID: " + dep.getEmployeeId());
	            System.out.println("Employee Name: " + dep.getEmployeeName());
	            System.out.println("Dependent ID: " + dep.getDependentId());
	            System.out.println("Dependent Name: " + dep.getDependentName());
	            System.out.println("Relationship: " + dep.getRelationship());
	            System.out.println("--------------------------------------");
	        }
	    }
    }
}
