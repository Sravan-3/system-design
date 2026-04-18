public class EmployeeData {
    
    int primaryKey;
    String employeeName;
    String employeeID;
    String projectName;
    String employeeAddress;
    double employeeSalary;

    public EmployeeData(int primaryKey, String employeeName, String employeeID, String projectName,
            String employeeAddress, double employeeSalary) {

        this.primaryKey = primaryKey;
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.projectName = projectName;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
    return "EmployeeData{" +
            "primaryKey=" + primaryKey +
            ", employeeName='" + employeeName + '\'' +
            ", employeeID='" + employeeID + '\'' +
            ", projectName='" + projectName + '\'' +
            ", employeeAddress='" + employeeAddress + '\'' +
            ", employeeSalary=" + employeeSalary +
            '}';
    }
    
}
