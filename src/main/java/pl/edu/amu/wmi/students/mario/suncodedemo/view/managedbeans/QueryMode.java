package pl.edu.amu.wmi.students.mario.suncodedemo.view.managedbeans;

public enum QueryMode {
    DUPLICATE("Wiersze zduplikowane"), UNIQUE("Wiersze unikalne");

    private String displayName;

    QueryMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
