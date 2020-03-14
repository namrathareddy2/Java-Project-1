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
* Purpose: The Phone class creates an phone object that stores the User's 
* phone number
*
* Input: String phone
*
* Preconditions/Assumptions: 
* - The phone number passed is a String
*
* Output: The constructor returns a Phone object
*
* Algorithm:
* Construct Phone Object
* Get Phone fields
* Set Phone fields
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;


public class Phone {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String phone;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public Phone() {
        phone = "";
    }
    
    public Phone(String phone) {
        this.phone = phone;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the Phone class
    \**************************************************************************/

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
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
        return phone;
    }
}
