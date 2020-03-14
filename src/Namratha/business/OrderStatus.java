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
* Purpose: The OrderStatus enumeration holds the status of orders
*
* Input: N/A
*
* Preconditions/Assumptions: N/A
*
* Output: N/A
*
* Algorithm:
* Create OrderStatus enumeration
*******************************************************************************/ 
package Wiggins.business;

public enum OrderStatus {
    
    NEW,
    HOLD,
    SHIPPED,
    DELIVERED,
    CLOSED;
    
    @Override
    public String toString() 
    /**************************************************************************\
    * Purpose: To Override the object's default toString() method to return 
    * a more readable representation of the object
    * Parameters: N/A
    * Action: Returns a string representation of the object
    \**************************************************************************/
    {
        String s = "";
        
        if (ordinal() == 0) {
            s = "New";
        } 
        else if (ordinal() == 1) {
            s = "Hold";
        } 
        else if (ordinal() == 2) {
            s = "Shipped";
        }
        else if (ordinal() == 3) {
            s = "Delivered";
        }
        else if (ordinal() == 4) {
            s = "Closed";
        }
        return s;
    } 
}
