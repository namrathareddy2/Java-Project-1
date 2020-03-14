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
* Purpose: The order class creates an order object that stores the User's order
* information. This class also implements cloneable so that a User may reorder
* a specific order as long as they provide the Order number.
*
* Input: String number, Date ordered, Date shipped, Address ship_to, 
* OrderStatus status, double total
*
* Preconditions/Assumptions: 
* - The total is a double
* - The shipped date is not initialized with the constructor but it is set later
* when the Customer pays the order
* - Implements cloneable 
*
* Output: The constructor returns an Order object
*
* Algorithm:
* Construct Order Object
* Get Order fields
* Set Order fields
* Implement .clone method
* Override .toString() method
*******************************************************************************/ 
package Wiggins.business;
 
import java.util.Date;

public class Order implements Cloneable{
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String number;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private double total;
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/

    public Order() {
        number = "";
        ordered = null;
        ship_to = null;
        status = null;
        total = 0.0;
    }
    
    public Order(String number, Date ordered, Address ship_to, double total) {
        this.number = number;
        this.ordered = ordered;
        this.ship_to = ship_to;
        status = OrderStatus.NEW;
        this.total = total;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the Order class
    \**************************************************************************/

    public String getNumber() {
        return number;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    /**************************************************************************\
    * Purpose: To clone an Order object
    * Parameters: N/A
    * Action: Returns a duplicate order object of the calling object
    \**************************************************************************/
    {  
        return (Order)super.clone();  
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
        return "ID: " + number + " | Ordered: " + ordered + " | Shipped: " + shipped + " | Shipping To: " + ship_to + " | Status: " + status + " | Total: " + total;
    }
    
}


