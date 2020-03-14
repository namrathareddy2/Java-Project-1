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
* Purpose: The LineItem class creates a LineItem object which is used to store 
* product information in their shopping cart.
*
* Input: int quantity, Product product
*
* Preconditions/Assumptions: 
* - The Product object hold the price information (not LineItem)
*
* Output: The constructor returns a LineItem object
*
* Algorithm:
* Construct LineItem Object
* Get LineItem fields
* Set LineItem fields
* Get LineItem total (price * quantity)
* Override .toString() method
*******************************************************************************/ 

package Wiggins.business;

public class LineItem {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private int quantity;
    private Product product;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
       
    public LineItem() {
        this.quantity = 0;
        this.product = null;
    }

    public LineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product= product;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProdcut() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public double getTotal() 
    /**************************************************************************\
    * Purpose: To calculate the total for the LineItem
    * Parameters: None
    * Action: The quantity and price values are multiplied to produce the total
    \**************************************************************************/
    {
        double total = quantity * product.getPrice();
        return total;
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
        return product + " | Quantity: " + quantity + " | Item Total: " + getTotal();
    }
}
