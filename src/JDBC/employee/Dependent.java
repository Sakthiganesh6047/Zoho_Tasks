package JDBC.employee;

public class Dependent {
    private int employeeId;
    private String employeeName;
    private int dependentId;
    private String dependentName;
    private String relationship;


    public int getEmployeeId() { 
    	return employeeId; 
    }
    public void setEmployeeId(int employeeId) { 
    	this.employeeId = employeeId; 
    }

    public String getEmployeeName() { 
    	return employeeName; 
    }
    public void setEmployeeName(String employeeName) { 
    	this.employeeName = employeeName; 
    }

    public int getDependentId() { 
    	return dependentId; 
    }
    
    public void setDependentId(int dependentId) { 
    	this.dependentId = dependentId; 
    }

    public String getDependentName() { 
    	return dependentName; 
    }
    
    public void setDependentName(String dependentName) { 
    	this.dependentName = dependentName; 
    }

    public String getRelationship() { 
    	return relationship; 
    }
    public void setRelationship(String relationship) { 
    	this.relationship = relationship; 
    }
}

