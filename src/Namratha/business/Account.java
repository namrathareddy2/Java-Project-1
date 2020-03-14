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
* Purpose: The Account class is the entity that allows Customers to utilize the 
* online shopping application. The Account id specified here is used to identify
* the customer and retrieve their information throughout the whole system.
*
* Input: String id, Address billing_address, boolean isClosed, Date open, 
* Date closed, ShoppingCart cart, 
*
* Preconditions/Assumptions: 
* - The same id that is used for WebUser and Customer is used here
* - The customers payments and orders are stored here
*
* Output: The constructor returns an Account object
*
* Algorithm:
* Construct Account Object
* Get Account fields
* Set Account fields
* Override .toString() method
* Add New Order to list
* Get existing Order by orderNumber
* Add new Payment to list
*******************************************************************************/ 

package Wiggins.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

public class Account implements Comparable<Account>{
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private fields of the class
    \**************************************************************************/
    
    private String id;
    private Address billing_address;
    private boolean isClosed;
    private Date open;
    private Date closed;
    private ShoppingCart cart;
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();
    
    /**************************************************************************\
    * CONSTRUCTORS
    * The Default and Parameterized Constructors for the class
    \**************************************************************************/
    
    public Account() {
        
        id = "";
        billing_address = null;
        isClosed = true;
        open = null;
        closed = null;
    }
    
    public Account(String id, Address billing_address, boolean isClosed, Date open, ShoppingCart cart) {
        this.id = id;
        this.billing_address = billing_address;
        this.isClosed = isClosed;
        this.open = open;
        this.cart = cart;
    }
    
    /**************************************************************************\
    * GETTER AND SETTER METHODS
    * These public methods are available to other classes to access and modify 
    * the private instance variables of the class
    \**************************************************************************/

    public String getId() {
        return id;
    }

    public Address getBilling_address() {
        return billing_address;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public Date getOpen() {
        return open;
    }

    public Date getClosed() {
        return closed;
    }
    
    public ShoppingCart getCart() {
        return cart;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBilling_address(Address billing_address) {
        this.billing_address = billing_address;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }
    
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
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
        return "[ID: " + id + "; Billing Address: " + billing_address + "; isClosed: " + isClosed + "; Date Opened: " + open + "; Date Closed: " + closed + "]";
    }

    public void newOrder(Order order) 
    /**************************************************************************\
    * Purpose: To add a new order to this Account list of orders
    * Parameters: An Order object 
    * Action: An Order object is added to the orders ArrayList
    \**************************************************************************/
    {
        orders.add(order);
    }
    
    public Order getOrder(String orderID) 
    /**************************************************************************\
    * Purpose: To get an order from 
    * Parameters: A string that is the orderID
    * Action: The orders ArrayList is searched to see if the number matches the 
    * ID passed into the method. If so, that order is returned to the calling
    * method. If not, a null order is returned;
    \**************************************************************************/
    {
        Order order = null;
        
       for(Order o: orders) {
            if (o.getNumber().equalsIgnoreCase(orderID))
            order = o; 
       }  
        return order;
    }
    
    public void newPayment(Payment pay) 
    /**************************************************************************\
    * Purpose: To record a new payment
    * Parameters: A Payment object
    * Action: A Payment object is added to payments ArrayList
    \**************************************************************************/
    {
        payments.add(pay);
    }
    
    @Override
    public int compareTo(Account other) 
    /**************************************************************************\
    * Purpose: To compare two objects for sorting
    * Parameters: An Account object
    * Action: Compares Account objects by id
    \**************************************************************************/
    {
        return this.id.compareTo(other.id);
    }
      
}
