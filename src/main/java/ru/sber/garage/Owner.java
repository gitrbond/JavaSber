package ru.sber.garage;

import java.util.Objects;

public class Owner {
    private final int ownerId;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner(int ownerId, String name, String lastName, int age) {
        this.ownerId = ownerId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Owner(int ownerId) {
        this.ownerId = ownerId;
        this.name = "";
        this.lastName = "";
        this.age = 0;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("oID:" + ownerId + " " + name + " " + lastName + " age:" + age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return ownerId == owner.ownerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId);
    }
}