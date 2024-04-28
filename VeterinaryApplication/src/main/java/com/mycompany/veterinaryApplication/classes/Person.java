package com.mycompany.veterinaryApplication.classes;

/**
 *
 * @author markc
 */
public abstract class Person {
    private String name; 
    private int age; 
    private int phoneNumber;
    private String addressLineOne;
    private String postcode;
    
    public void getName() {
        System.out.println(this.name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void getAge() {
        System.out.println(this.age);
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void getPhoneNumber() {
        System.out.println(this.phoneNumber);
    }
    
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    public void getAddressLineOne() {
        System.out.println(this.addressLineOne);
    }
    
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }
    
    public void getPostcode() {
        System.out.println(this.postcode);
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
}
