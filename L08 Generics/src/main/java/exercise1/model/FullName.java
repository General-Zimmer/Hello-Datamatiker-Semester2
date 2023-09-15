package exercise1.model;

import org.jetbrains.annotations.NotNull;

public class FullName implements Comparable<FullName>{
    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public int compareTo(@NotNull FullName o) {
        if (this.firstName.compareTo(o.firstName) == 0) {
            return this.lastName.compareTo(o.lastName);
        }
        return this.firstName.compareTo(o.firstName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
