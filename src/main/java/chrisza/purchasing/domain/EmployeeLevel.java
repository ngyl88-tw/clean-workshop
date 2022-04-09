package chrisza.purchasing.domain;

public enum EmployeeLevel {
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
