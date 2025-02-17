package JDBC.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import util.CustomException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDBO {
	
	private static HikariDataSource dataSource;
    
    public static void prepareConnectionPool(String url, String user, String password) {
    	 HikariConfig config = new HikariConfig();
         config.setJdbcUrl(url);
         config.setUsername(user);
         config.setPassword(password);
         config.setMaximumPoolSize(10);
         dataSource = new HikariDataSource(config);
    }
    
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    public static void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

	public String createTable() throws CustomException {
		
		String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" 
        		+ "EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT, "
                + "NAME VARCHAR(100) NOT NULL, "
                + "MOBILE VARCHAR(15) NOT NULL UNIQUE, "
                + "EMAIL VARCHAR(100) NOT NULL UNIQUE, "
                + "DEPARTMENT VARCHAR(50) NOT NULL"
                + ");";

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement()) {
        	statement.executeUpdate(createTableSQL);
            return ("Employee table created successfully!");

        } catch (SQLException e) {
        	throw new CustomException("Error while creating table", e);
        }
	}
	
	public boolean addEmployeeDetail(String name, String mobile, String email, String department) throws CustomException {
		
		String insertSQL = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = getConnection();
	             PreparedStatement prepStatement = conn.prepareStatement(insertSQL)) {
			 
             prepStatement.setString(1, name);
             prepStatement.setString(2, mobile);
             prepStatement.setString(3, email);
             prepStatement.setString(4, department);
             return prepStatement.execute();
			 
		 } catch (SQLException e) {
	        	throw new CustomException("Error occured while adding employee details", e);
	        }     
	}
	
	public int[] addNEmployeeDetails(List<Employee> employeeList) throws CustomException {
		
	    String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";

	    Connection conn = null;
	    PreparedStatement stmt = null;
	    SQLException stmtException = null;
		SQLException connException = null;

	    try {
	        conn = getConnection();
	        conn.setAutoCommit(false);
	        stmt = conn.prepareStatement(sql);

	        for (Employee emp : employeeList) {
	            stmt.setString(1, emp.getName());
	            stmt.setString(2, emp.getMobile());
	            stmt.setString(3, emp.getEmail());
	            stmt.setString(4, emp.getDepartment());
	            stmt.addBatch();
	        }

	        int[] rowsInserted = stmt.executeBatch();
	        conn.commit();
	        return rowsInserted;

	    } catch (SQLException e) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException rollbackEx) {
	                throw new CustomException("Error in rolling back to the older state", rollbackEx);
	            }
	        }
	        throw new CustomException("Error while inserting employee records", e);
	    } finally {
	    	try {
                if (stmt != null) {
                	stmt.close();
                }
            } catch (SQLException e) {
                stmtException = e;
            }

            try {
                if (conn != null) {
                	conn.close();
                }
            } catch (SQLException e) {
                connException = e;
            }

            if (stmtException != null) {
                throw new CustomException("Error closing statement", stmtException);
            }
            if (connException != null) {
                throw new CustomException("Error closing connection", connException);
            }
	    }
	}
	
	public int[] addEmployeesFromJson(String json) throws CustomException {
		
		try {
		
			String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
			Connection conn = getConnection();
	
			try (conn; PreparedStatement stmt = conn.prepareStatement(sql);){
				List<Employee> employeeList = parseJsonToList(json);
	
				conn.setAutoCommit(false);
	
				for (Employee emp : employeeList) {
	                stmt.setString(1, emp.getName());
	                stmt.setString(2, emp.getMobile());
	                stmt.setString(3, emp.getEmail());
	                stmt.setString(4, emp.getDepartment());
	                stmt.addBatch();
	            }
	
	            int[] rowsInserted = stmt.executeBatch();
	            conn.commit();
	            return rowsInserted;
	
	        } catch (Exception e) {
	            if (conn != null) {
	                try {
	                    conn.rollback();
	                } catch (SQLException rollbackEx) {
	                    throw new CustomException("Error while rolling back to the older state", rollbackEx);
	                }
	            }
	            throw new CustomException("Error while inserting employee records", e);
	        }
		} catch(SQLException e) {
			throw new CustomException("Error while creating connection", e);
		}
	}
	
	public static List<Employee> parseJsonToList(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<List<Employee>>() {});
    }
	
	public List<Employee> fetchEmployeeByName(String searchName) throws CustomException {
	    String searchQuery = "SELECT * FROM Employee WHERE NAME LIKE ?";
	    List<Employee> employees = new ArrayList<>();

	    try (Connection conn = getConnection();
	         PreparedStatement prepStatement = conn.prepareStatement(searchQuery)) {
	        
	        prepStatement.setString(1, "%" + searchName + "%");
	        try (ResultSet resultSet = prepStatement.executeQuery()) {
	            while (resultSet.next()) {
	                Employee emp = new Employee();
	                emp.setName(resultSet.getString("NAME"));
	                emp.setMobile(resultSet.getString("MOBILE"));
	                emp.setEmail(resultSet.getString("EMAIL"));
	                emp.setDepartment(resultSet.getString("DEPARTMENT"));
	                employees.add(emp);
	            }
	        }
	    } catch (SQLException e) {
	        throw new CustomException("Error while fetching employee details", e);
	    }
	    return employees;
	}
	
	public int updateDetails(int employeeId, String columnToUpdate, String newValue) throws CustomException {
		String updateSQL = "UPDATE Employee SET " + columnToUpdate + " = ? WHERE EMPLOYEE_ID = ?";

        try (Connection conn = getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(updateSQL)) {

        	prepStatement.setString(1, newValue);
        	prepStatement.setInt(2, employeeId);
            return prepStatement.executeUpdate();

        } catch (SQLException e) {
        	throw new CustomException("Error while updating employee details", e);
        }
	}
	
	public boolean deleteEmployeeById(int employeeId) throws CustomException {
	    String deleteQuery = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
	    
	    try (Connection conn = getConnection();
	         PreparedStatement prepStatement = conn.prepareStatement(deleteQuery)) {
	        
	        prepStatement.setInt(1, employeeId);
	        int rowsAffected = prepStatement.executeUpdate();
	        
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        throw new CustomException("Error while deleting employee with ID: " + employeeId, e);
	    }
	}

	public int insertDependentDetails(int employeeId, String depName, String relationship, int age) throws CustomException {
	    String insertQuery = "INSERT INTO EmployeeDependent (EMPLOYEE_ID, NAME, RELATIONSHIP, AGE) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = getConnection();
	         PreparedStatement prepStatement = conn.prepareStatement(insertQuery)) {

	            prepStatement.setInt(1, employeeId);
	            prepStatement.setString(2, depName);
	            prepStatement.setString(3, relationship);
	            prepStatement.setInt(4, age);
	            return prepStatement.executeUpdate();

	    } catch (SQLException e) {
	        throw new CustomException("Error while inserting dependent details", e);
	    }
	}

    public String insertEmployee(Employee employee) throws CustomException {
    	
    	String sql = "INSERT INTO Employee (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?)";
    	
        try (Connection conn = getConnection();
        	PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getMobile());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getDepartment());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return ("Employee added successfully!");
            } else {
            	return ("Failed to add Employee");
            }
        } catch (Exception e) {
        	throw new CustomException("Error while inserting employee record", e);
        }
    }
    
    public Employee getEmployeeById(int empId) throws CustomException {
        Employee employee = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE EMPLOYEE_ID = ?")) {

            stmt.setInt(1, empId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("NAME"),
                        rs.getString("MOBILE"),
                        rs.getString("EMAIL"),
                        rs.getString("DEPARTMENT")
                    );
                }
            }
        } catch (Exception e) {
            throw new CustomException("Error while getting employee record", e);
        }
        return employee;
    }


    public List<Employee> getFirstNEmployees(int n) throws CustomException {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee ORDER BY EMPLOYEE_ID LIMIT ?")) {

            stmt.setInt(1, n);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("NAME"),
                        rs.getString("MOBILE"),
                        rs.getString("EMAIL"),
                        rs.getString("DEPARTMENT")
                    );
                    employeeList.add(employee);
                }
            }
        } catch (Exception e) {
            throw new CustomException("Error while getting " + n + " records", e);
        }
        return employeeList;
    }

    
    public List<Employee> getFirstNEmployeesInAsc(int n) throws CustomException {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee ORDER BY EMPLOYEE_ID ASC LIMIT ?")) {

            stmt.setInt(1, n);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee(
                        rs.getInt("EMPLOYEE_ID"),
                        rs.getString("NAME"),
                        rs.getString("MOBILE"),
                        rs.getString("EMAIL"),
                        rs.getString("DEPARTMENT")
                    );
                    employeeList.add(employee);
                }
            }
        } catch (Exception e) {
            throw new CustomException("Error while getting " + n + " records in Ascending order", e);
        }
        return employeeList;
    }

    
    public String createDependentTable() throws CustomException {
		
		String createTableSQL = "CREATE TABLE IF NOT EXISTS EmployeeDependent (" 
        		+ "DEPENDENT_ID INT PRIMARY KEY AUTO_INCREMENT, "
                + "EMPLOYEE_ID INT,"
                + "NAME VARCHAR(100) NOT NULL, "
                + "AGE INT NOT NULL,"
                + "RELATIONSHIP VARCHAR(50) NOT NULL, "
                + "FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE"
                + ");";

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement()) {
        	statement.executeUpdate(createTableSQL);
            return ("Employee table created successfully!");

        } catch (SQLException e) {
        	throw new CustomException("Error while creating dependent table", e);
        }
	}
    
    public List<Dependent> getDependenciesWithEmpId(int empID) throws CustomException {
        String sql = "SELECT e.EMPLOYEE_ID, e.NAME AS EMPLOYEE_NAME, " +
                     "d.DEPENDENT_ID, d.NAME AS DEPENDENT_NAME, d.RELATIONSHIP " +
                     "FROM EmployeeDependent d " +
                     "JOIN Employee e ON d.EMPLOYEE_ID = e.EMPLOYEE_ID " +
                     "WHERE e.EMPLOYEE_ID = ?";
        
        List<Dependent> dependents = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, empID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Dependent dependent = new Dependent();
                    dependent.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                    dependent.setEmployeeName(resultSet.getString("EMPLOYEE_NAME"));
                    dependent.setDependentId(resultSet.getInt("DEPENDENT_ID"));
                    dependent.setDependentName(resultSet.getString("DEPENDENT_NAME"));
                    dependent.setRelationship(resultSet.getString("RELATIONSHIP"));
                    dependents.add(dependent);
                }
            }
        } catch (SQLException e) {
            throw new CustomException("Error occurred while getting dependencies", e);
        }

        return dependents;
    }
    
    public List<Dependent> getnEntriesInAsc(int count) throws CustomException {
        String sql = "SELECT e.EMPLOYEE_ID, e.NAME AS EMPLOYEE_NAME, " +
                     "d.DEPENDENT_ID, d.NAME AS DEPENDENT_NAME, d.RELATIONSHIP " +
                     "FROM EmployeeDependent d " +
                     "JOIN Employee e ON d.EMPLOYEE_ID = e.EMPLOYEE_ID " +
                     "ORDER BY e.NAME ASC LIMIT ?";

        List<Dependent> dependents = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, count);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Dependent dependent = new Dependent();
                    dependent.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                    dependent.setEmployeeName(resultSet.getString("EMPLOYEE_NAME"));
                    dependent.setDependentId(resultSet.getInt("DEPENDENT_ID"));
                    dependent.setDependentName(resultSet.getString("DEPENDENT_NAME"));
                    dependent.setRelationship(resultSet.getString("RELATIONSHIP"));
                    dependents.add(dependent);
                }
            }
        } catch (SQLException e) {
            throw new CustomException("Error while executing Exercise 12", e);
        }

        return dependents;
    }
}

