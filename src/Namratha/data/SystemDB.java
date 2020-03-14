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
* Files Included: Account.java; Address.java; Customer.java; Main.java; 
* Order.java; OrderStatus.java; Payment.java; Product.java; ShoppingCart.java; 
* Supplier.java; SystemDB.java; UserState.java; WebUser.java
*
********************************************************************************
* 
* Purpose: The SystemDB class simulates the System Database that would be used
* in a more realistic application. It holds important non-Product data objects
* such as WebUser, Customer, and Account accounts, as well as their
* Shopping Carts. It also handles operations that need to be done on these 
* objects such as storing, returning, sorting, and printing.
*
* Input: N/A
*
* Preconditions/Assumptions: 
* - The ArrayLists resemble the tables of a database and they are all linked by 
* the Primary Key of userId
*
* Output: N/A
*
* Algorithm:
* Store WebUser
* Authenticate WebUSer
* Activate account of WebUser
* Store Customer
* Store Account
* Get Account
* Store ShoppingCart
* Get ShoppingCart
* Add item to ShoppingCart
* Use Comparable to Sort all Accounts
* Use Comparator to Sort LineItems in ShoppingCart
* Generically print any Collection
*******************************************************************************/ 
package Wiggins.data;

import Wiggins.business.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SystemDB {
    
    /**************************************************************************\
    * INSTANCE VARIABLES
    * The private ArrayLists of the class
    \**************************************************************************/
    
    private static ArrayList<WebUser> usersList = new ArrayList<>();
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static ArrayList<Account> accountsList = new ArrayList<>();
    private static ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>(); 
       
    public static void storeWebUser(WebUser wu) 
    /**************************************************************************\
    * Purpose: To store a newly created WebUser
    * Parameters: WebUser wu
    * Action: Adds WebUser to usersList
    \**************************************************************************/
    {  
        usersList.add(wu);
        
    } 

    public static boolean isNewWebUser(String id)
    /**************************************************************************\
    * Purpose: To verify if User has an Account
    * Parameters: String id
    * Action: Iterates through usersList comparing provided id with those in 
    * the list to see if a WebUser with the same id exist.
    \**************************************************************************/
    {
        boolean hasAccount = false;   
        for (WebUser wu: usersList) {
            if (wu.getId().equalsIgnoreCase(id)) {
                hasAccount = true;
                return hasAccount;
            }
            else
                hasAccount = false;
        }
        return hasAccount;
    }
    
    public static void activateUser(String id) 
    /**************************************************************************\
    * Purpose: To activate a User's account once they start shopping
    * Parameters: String id
    * Action: Finds the User Account with the same id as the one provided
    * and sets their state to ACTIVE
    \**************************************************************************/
    {
        for (WebUser wu: usersList) {
            if (wu.getId().equalsIgnoreCase(id))
                wu.setState(UserState.ACTIVE);
        }
    } 
    
    public static void storeCustomer(Customer nc) 
    /**************************************************************************\
    * Purpose: To store a newly created Customer
    * Parameters: Customer nc
    * Action: Adds Customer to customerList
    \**************************************************************************/
    {
        customerList.add(nc);
    } 
    
    public static void storeAccount(Account a) 
    /**************************************************************************\
    * Purpose: To store a newly created Account
    * Parameters: Account a
    * Action: Adds Account to accountsList
    \**************************************************************************/
    { 
        accountsList.add(a);
    } 
    
    public static Account getUserAccount(String id) 
    /**************************************************************************\
    * Purpose: To retrieve a User's account by id
    * Parameters: String id
    * Action: Returns the User Account with the same id as the one provided
    \**************************************************************************/
    {
        Account account = null;
        for(Account a: accountsList) {
            if (a.getId().equalsIgnoreCase(id))
                account = a;       
        }
        return account;
    } 
    
    public static void storeShoppingCart(ShoppingCart nsc) 
    /**************************************************************************\
    * Purpose: To store a newly created ShoppingCart
    * Parameters: ShoppingCart nsc
    * Action: Adds ShoppingCart to shoppingCarts
    \**************************************************************************/
    {
        shoppingCarts.add(nsc);
    } 
    
    public static ShoppingCart getShoppingCart(String id) 
    /**************************************************************************\
    * Purpose: To retrieve a User's ShoppingCart by id
    * Parameters: String id
    * Action: Returns the ShoppingCart with the same id (owner) as the one 
    * provided
    \**************************************************************************/
    {   
        ShoppingCart cart = null;
        for(ShoppingCart sc: shoppingCarts) {
            if (sc.getOwner().equalsIgnoreCase(id))
                cart = sc;       
        }
        return cart;
    } 
    
    public static void addToCart(String id, LineItem item) 
    /**************************************************************************\
    * Purpose: To add a LineItem to a User's ShoppingCart
    * Parameters: String id, LineItem item
    * Action: Retrieves the User's ShoppingCart with their ID, then adds the 
    * provided lineItem to that cart
    \**************************************************************************/
    {  
        ShoppingCart cart = getShoppingCart(id);
        cart.addToCart(item);
    } 
    
    public static void useComparable () 
    /**************************************************************************\
    * Purpose: To use Comparable to sort all the Accounts of the shopping system
    * by their id
    * Parameters: N/A
    * Action: Uses the compareTo method implemented in the Account class to 
    * sort the accountsList by id
    \**************************************************************************/
    {
        Collections.sort(accountsList);
        for (Account a: accountsList) {
            System.out.println(a);
        }
    } 
    
    public static void useComparator (ShoppingCart sc)
    /**************************************************************************\
    * Purpose: To use the LineItemComparator class to sort the items in a User's
    * shopping cart by price, then by quantity
    * Parameters: ShoppingCart sc
    * Action: Creates a new LineItemComparator and sorts the LineItems of the
    * ShoppingCart by price, then quantity
    \**************************************************************************/
    {
        Collections.sort(sc.getLineItems(), new LineItemComparator());
        printCollection(sc.getLineItems());
    } 
    
    public static void printCollection( Collection <?> c )
    /**************************************************************************\
    * Purpose: To use a Generic wildcard method to print any ArrayList by line
    * Parameters: Any type of Collection (ArrayList in this case)
    * Action: Prints each object of the provided ArrayList on a new line
    \**************************************************************************/
    {
        for (Object o : c){
            System.out.println(o);
        }
    } 
    
}
