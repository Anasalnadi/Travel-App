package anas.com.nado.travelapp.model;

public class Customer {
   private int id;
   private String firstName;
   private String lastName;
   private String email;
   private String avatare;
   private String address;
   private String phoneNumber;
   private int age;

    public Customer(int id, String firstName, String lastName, String email, String avatare, String address, String phoneNumber, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatare = avatare;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatare() {
        return avatare;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAvatare(String avatare) {
        this.avatare = avatare;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
