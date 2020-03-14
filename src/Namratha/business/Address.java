/******************************************************************************\
* Programmer: Naomi Wiggins
*
* Course: CSCI 4391.05
*
* Date: February 27, 2019
*
* Assignment: Project 2: Java Generics and Comparator
*
* Environment: Java with NetBeans IDE
*
* Files Included: Account.java; Address.java; Customer.java; LineItem.java;
* LineItemComparator.java; Main.java; Order.java; OrderStatus.java; 
* Payment.java; Product.java; ProductDB.java; ShoppingCart.java; Supplier.java; 
* SystemDB.java; UserState.java; WebUser.java
* 
********************************************************************************
*
* Purpose: The Address class creates an address object that is used by the 
* Customer, Account, and Order classes
*
* Input: String name, String street, string city, String state, String zipCode
*
* Preconditions/Assumptions: All variables in the constructor will be passed
* in one by one (no string splitting here).
*
* Output: The constructor returns an Address object
*
* Algorithm:
* Construct Address Object
* Get Address fields
* Set Address fields
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;

public class Address {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    public Address() {
        name = "";
        street = "";
        city = "";
        state = "";
        zipCode = "";
    }

    public Address(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    /**************************************************************************\
    * GETTER METHODS
    * These public methods are available to other classes to access the private
    * instance variables of the class
    \**************************************************************************/
    
     public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
    
    /**************************************************************************\
    * SETTERS
    * These public setter methods allow other classes to modify the values of 
    * the instance variable of the class
    \**************************************************************************/
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public String toString() 
    /**************************************************************************\
    * Purpose: To Override the object's default toString() method to return 
    * a more readable representation of the object
    * Parameters: N/A
    * Action: Returns a string representation of the object
    \**************************************************************************/
    {
        return name + ", " + street + " " + city + ", " + state + " " +  zipCode;      
    }
}
