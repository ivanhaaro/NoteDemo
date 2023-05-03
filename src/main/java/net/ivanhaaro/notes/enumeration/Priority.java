package net.ivanhaaro.notes.enumeration;

public enum Priority {
    HIGH_PRIOR("HIGH_PRIOR"),
    MID_PRIOR("MID_PRIOR"),
    LOW_PRIOR("LOW_PRIOR");

    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
