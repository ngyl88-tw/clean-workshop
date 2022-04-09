package chrisza.purchasing.domain;

public class Employee {
    private final String EmailAddress;
    private final EmployeeLevel employeeLevel;

    public Employee(String emailAddress) {
        EmailAddress = emailAddress;

        switch (emailAddress) {
            case "steve@microapplesoft.com":
                employeeLevel = EmployeeLevel.SENIOR;
                break;
            case "mark@microapplesoft.com":
                employeeLevel = EmployeeLevel.MID;
                break;
            default:
                employeeLevel = EmployeeLevel.ORDINARY;
        }
    }

    public boolean isManagedUnder(Employee other) {
        return other.employeeLevel.getHierarchy() > this.employeeLevel.getHierarchy();
    }

    public boolean isSeniorManagement() {
        return EmployeeLevel.SENIOR.equals(this.employeeLevel);
    }

    public boolean isManagement() {
        return isSeniorManagement() || EmployeeLevel.MID.equals(this.employeeLevel);
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

}
