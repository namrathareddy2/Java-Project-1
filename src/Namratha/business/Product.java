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
* Purpose: The Product class creates a product that can be purchased by the User
*
* Input: String id, String name, Supplier supplier, double price
*
* Preconditions/Assumptions: N/A
*
* Output: The constructor returns an Product object
*
* Algorithm:
* Construct Product Object
* Get Product fields
* Set Product fields
* Override .toString() method
* Add New Order to list
* Get existing Order by orderNumber
* Add new Payment to list
*******************************************************************************/ 
package Wiggins.business;

public class Product {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String id;
    private String name;
    private Supplier supplier;
    private double price;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public Product() {
        
        id = "";
        name = "";
        supplier = null;
        price = 0.0;
    }

    public Product(String id, String name, Supplier supplier, double price) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    
    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    public void setPrice(double price) {
        this.price = price;
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
        return "Item: " + name + " | Price: " + price;
    }   
    
}
