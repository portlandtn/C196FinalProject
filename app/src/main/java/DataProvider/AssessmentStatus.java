package DataProvider;

public enum AssessmentStatus {
    PASSED("Passed"),
    PLANNED("Planned"),
    FAILED("Failed");

    private String status;

    AssessmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
