package exercise1.model;

import org.jetbrains.annotations.NotNull;

public class Person<T> implements Comparable<Person<T>>{
    private T name;

    public Person(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Person<T> o) {
        return this.name.toString().compareTo(o.getName().toString());
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
