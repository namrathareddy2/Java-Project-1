/***********************************************************************************\
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
* Purpose: The Customer class creates an Customer object whose information is
* then used to create an Account object.
*
* Input: String id, Address address, Phone phone, String email
*
* Preconditions/Assumptions: 
* - The same id that is used for WebUser is used here
*
* Output: The constructor returns an Customer object
*
* Algorithm:
* Construct Customer Object
* Get Customer fields
* Set Customer fields
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;

public class Customer {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the Customer class
    \**************************************************************************/
    
    private String id;
    private Address address;
    private Phone phone;
    private String email;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the Customer class
    \**************************************************************************/
    
    public Customer() {
        id = "";
        address = null;
        phone = null;
        email = "";
    }
    
    public Customer(String id, Address address, Phone phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the Account class
    \**************************************************************************/
    
    public void setId() {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setAddress() {
        this.address = address;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setPhone() {
        this.phone = phone;
    }
    
    public Phone getPhone() {
        return phone;
    }
    
    public void setEmail() {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
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
        return "ID: " + id + "; Email: " + email + "; Phone: " + phone + "; Address: " + address;
    }
}
