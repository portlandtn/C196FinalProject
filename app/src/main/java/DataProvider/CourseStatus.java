package DataProvider;

public enum CourseStatus {
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    DROPPED("Dropped"),
    PLAN_TO_TAKE("Plan to take");

    private String status;

    CourseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
