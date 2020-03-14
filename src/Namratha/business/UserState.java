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
* Purpose: The UserState enumeration holds the state of a User's web account
*
* Input: N/A
*
* Preconditions/Assumptions: N/A
*
* Output: N/A
*
* Algorithm:
* Create UserState enumeration
*******************************************************************************/   
package Wiggins.business;

public enum UserState {
    
    NEW,
    ACTIVE,
    BLOCKED,
    BANNED;
    
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
            s = "Active";
        } 
        else if (ordinal() == 2) {
            s = "Blocked";
        }
        else if (ordinal() == 2) {
            s = "Banned";
        }
        return s;
    }
    
}
