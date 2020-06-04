package sample;

import javafx.beans.property.SimpleStringProperty;

public class Score {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;

    Score(String fName, String lName) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
}
