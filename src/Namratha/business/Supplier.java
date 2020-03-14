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
* Purpose: The Supplier class specifies the Supplier name from which the Product
* is being provided
*
* Input: String name
*
* Preconditions/Assumptions:
* - The Supplier is the Brand name of the clothing product
* - For this program, the only three suppliers are: Ralph Lauren, Levi, and Nike
*
* Output: The constructor returns an Supplier object
*
* Algorithm:
* Construct Supplier Object
* Get Supplier name
* Set Supplier name
* Override .toString() method
*******************************************************************************/

package Wiggins.business;

public class Supplier {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String name;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public Supplier() {
        name = "";
    }

    public Supplier(String name) {
        this.name = name;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Name: " + name;
    }
}


