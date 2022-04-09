package chrisza.purchasing.domain;

import static chrisza.purchasing.domain.Employee.EmployeeLevel.MID;
import static chrisza.purchasing.domain.Employee.EmployeeLevel.SENIOR;

public class Employee {
    private String EmailAddress;
    private EmployeeLevel employeeLevel;

    public Employee(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public boolean isHigherLevelThan(Employee employee) {
        return this.employeeLevel.getHierarchy() > employee.getLevel().getHierarchy();
    }

    public boolean isSeniorManagement() {
        return SENIOR.equals(this.employeeLevel);
    }

    public boolean isManagement() {
        return MID.equals(this.employeeLevel) || SENIOR.equals(this.employeeLevel);
    }

    /* Employee Information */

    enum EmployeeLevel {
        SENIOR(2),
        MID(1),
        ORDINARY(0);

        private final int hierarchy;

        EmployeeLevel(int hierarchy) {
            this.hierarchy = hierarchy;
        }

        public int getHierarchy() {
            return hierarchy;
        }
    }

    /* Setters and Getters */

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }

    public EmployeeLevel getLevel() {
        return employeeLevel;
    }

    public void setLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
    }
}
