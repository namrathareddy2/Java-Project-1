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
* Purpose: The LineItemComparator class uses a Comparator to sort a list of 
* LineItems (basically a Shopping Cart first by Price, then by Quantity.
*
* Input: N/A
*
* Preconditions/Assumptions: 
* - The list of LineItems belongs to a User's shopping cart
*
* Output: Sorted list of LineItem Objects
*
* Algorithm:
* compare LineItems
*******************************************************************************/ 

package Wiggins.business;

import java.util.Comparator;


public class LineItemComparator implements Comparator<LineItem>
    /**************************************************************************\
    * Purpose: To use comparator to sort ArrayList of LineItems
    * Parameters: Two LineItem objects
    * Action: Compares two LineItem objects in order to sort them
    \**************************************************************************/
{ 
    @Override
        public int compare(LineItem item1, LineItem item2) {
            
            int quantityCompare = item1.getQuantity()-(item2.getQuantity());         

            if (item1.getProdcut().getPrice() < item2.getProdcut().getPrice())
                return -1;
            else if (item1.getProdcut().getPrice() > item2.getProdcut().getPrice())
                return 1;
            else
                return quantityCompare;
        } // end of compare()
}
