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
* Purpose: The ShoppingCart class creates a shopping cart object for the User 
* that stores the lineItems they choose while shopping
*
* Input: Date created, String owner, ArrayList lineItems
*
* Preconditions/Assumptions:
* - uses owner field to keep track the owner of shopping cart
* - has arrayList to hold lineItems
* - uses Generics to print ArrayList of LineItems
*
* Output: The constructor returns an ShoppingCart object
*
* Algorithm:
* Construct ShoppingCart Object
* Get ShoppingCart fields
* Set ShoppingCart fields
* print LineItems
* Override .toString() method
* Add New item to cart
* Get total of all items in cart
*******************************************************************************/ 
package Wiggins.business;

import Wiggins.data.SystemDB;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private Date created;
    private String owner;
    private ArrayList<LineItem> lineItems = new ArrayList<>();
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public ShoppingCart() {
        created = null;
        owner = "";
    }

    public ShoppingCart(Date created, String owner) {
        this.created = created;
        this.owner = owner;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public ArrayList getLineItems() {
        return lineItems;
    }
    
    public void printCart() 
    /**************************************************************************\
    * Purpose: To display the LineItems of the Cart on separate lines
    * Parameters: N/A
    * Action: Calls the a Generic method from the SystemDB class that prints
    * the lineItems ArrayList with each item on a line
    \**************************************************************************/
    {
        SystemDB.printCollection(lineItems);
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
        return "Owner: " + owner + "; Date Created: " + created + ";\n Items: " + lineItems;
    }
    
    public void addToCart(LineItem item) 
    /**************************************************************************\
    * Purpose: To store a new line item in the Shopping Cart
    * Parameters: LineItem
    * Action: Adds a LineItem to the end of the lineItems ArrayList
    \**************************************************************************/
    {
        lineItems.add(item); 
    }
    
    public double getTotal() 
    /**************************************************************************\
    * Purpose: To get the total value of all the lineItems in the cart
    * Parameters: N/A
    * Action: Iterates through the lineItems ArrayLists adding the price and
    * quantity of each lineItem and then returns the total
    \**************************************************************************/
    {
        double totalDue = 0;
        
        for (LineItem item: lineItems) {
            totalDue += item.getTotal();
        }
        return totalDue;   
    }    
}
