package enums;

public enum EmployeeStatus {

    ACTIVE(1),
    PAUSED(0),
    NOT_ACTIVE(-1)  ;

    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
