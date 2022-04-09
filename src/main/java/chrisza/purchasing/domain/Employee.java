package chrisza.purchasing.domain;

public class Employee {
    private String EmailAddress;
    private EmployeeLevel level;

    public Employee(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public boolean isHigherLevelThan(Employee employee) {
        return this.level.getHierarchy() > employee.getLevel().getHierarchy();
    }

    public boolean isSeniorManagement() {
        return EmployeeLevel.SENIOR.equals(this.level);
    }

    public boolean isManagement() {
        return EmployeeLevel.MID.equals(this.level) || EmployeeLevel.SENIOR.equals(this.level);
    }

    /* Setters and Getters */

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public void setLevel(EmployeeLevel level) {
        this.level = level;
    }
}
