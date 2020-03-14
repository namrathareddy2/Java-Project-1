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
* Purpose: The Payment Object holds information on the User's payments
* regarding Order objects
*
* Input: String id, Date ordered, Date paid, double total, String details 
*
* Preconditions/Assumptions: 
* - All payments must be paid in full
*
* Output: The constructor returns an Payment object
*
* Algorithm:
* Construct Payment Object
* Get Payment fields
* Set Payment fields
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;

import java.util.Date;

public class Payment {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String id;
    private Date paid;
    private double total;
    private String details;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public Payment(String id, Date paid, double total, String details) {
        this.id = id;
        this.paid = paid;
        this.total = total;
        this.details = details;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the Payment class
    \**************************************************************************/
    
    public void setId() {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setPaid() {
        this.paid = paid;
    }
    
    public Date getPaid() {
        return paid;
    }
    
    public void setTotal() {
        this.total = total;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setDetails() {
        this.details = details;
    }
    
    public String getDetails() {
        return details;
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
        return "Payment{" + "id=" + id + ", paid=" + paid + ", total=" + total + ", details=" + details + '}';
    }   
}
