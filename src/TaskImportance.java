public enum TaskImportance {
    LOW(1),
    MEDIUM(2),
    HIGH(3);


    private final int code;

    TaskImportance(int code) {
        this.code = code;
    }

    public int GetCode() {
        return code;
    }

    public static TaskImportance FromCode(int code) {
        for (TaskImportance t : TaskImportance.values()) {
            if (t.code == code) { return t; }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
