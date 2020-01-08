package pl.itacademy.immutability;

import java.util.Objects;

public final class Person {
    private final String firstName;
    private final String lastName;
    private final Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = addressCopy(address);
    }

    public static Person createPerson(String firstName, String lastName, Address address) {
        return new Person(firstName, lastName, address);
    }

    private Address addressCopy(Address address) {
        return new Address(address.getCity(), address.getStreet());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return addressCopy(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
