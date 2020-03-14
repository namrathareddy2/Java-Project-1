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
* Purpose: The WebUser class holds the information of a User's web account. It 
* is used to authenticate the User into the Shopping System
*
* Input: String id, String password, UserState state
*
* Preconditions/Assumptions:
* - The id created here is used throughout the program to authenticate the user 
* and keep track of their associated objects (Account, ShopppingCart, Orders,
* Payments, and etc.
*
* Output: The constructor returns an ShoppingCart object
*
* Algorithm:
* Construct WebUser Object
* Get WebUser fields
* Set WebUser fields
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;

public class WebUser {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String id;
    private String password;
    private UserState state;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public WebUser() {
        
        id = "";
        password = "";
        state = null;
    }

    public WebUser(String id, String password) {
        this.id = id;
        this.password = password;
        state = UserState.NEW;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserState getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(UserState state) {
        this.state = state;
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
        return "[ID: " + id + ", Password: " + password + ", State: " + state + "]";
    }
    
    
    
}
