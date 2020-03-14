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
* Purpose: The Main class is the driver for the whole Shopping System. It is
* responsible for interacting with the users and processing their requests. It 
* interacts with all the other classes of this program.
*
* Input: N/A
*
* Preconditions/Assumptions: 
* - This application is a text only application (no GUI)
* - verifyUser method only checks for username, not password
* - populateSystem creates a few user accounts to populate the system (this 
* application has no persistent data storage, so this is necessary to perform 
* sorting and functions)
*
* Output: N/A
*
* Algorithm:
* Populate the System
* Sort and Display available accounts
* welcome the user to the Login Screen
* Verify that the User has an account in the system
* Create a new Account for User
* Display Account options to User
* Display Shopping screen to User
* Place Order for User
* Check Order Status for User
* Duplicate Order for User (Clone Object)
* Display Shopping Cart to User
*******************************************************************************/ 

package Wiggins.ui;

import Wiggins.business.Address;
import Wiggins.business.Phone;
import java.util.Scanner;
import java.util.Date;
import java.text.*;
import Wiggins.business.*;
import Wiggins.data.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);
            
    public static void main(String[] args) 
    /**************************************************************************\
    * Purpose: Driver class
    * Parameters: N/A 
    * Action: Starts execution of program
    \**************************************************************************/
    {
        populateSystem();
        welcomeUser();
    }
    
    public static void welcomeUser() 
    /**************************************************************************\
    * Purpose: To welcome and prompt user to Login or Sign up
    * Parameters: N/A
    * Action: Welcomes user and presents them with 
    * - If login: calls verify User method
    * - If signup: calls newCustomer method
    * - if view other users: calls sortAccounts method which uses comparable
    * - if quit: terminates program
    \**************************************************************************/
    {
        // Display a welcome message
        System.out.println("Welcome to the Project 2 Online Shopping System!");
        System.out.println();
        
        String choice = "";
        
        while(!choice.equalsIgnoreCase("c")) {
       
            System.out.println("----- LOGIN SCREEN -----");
            System.out.println("a. Login \nb. Sign up\nc. View other users\nd. Quit");
            choice = sc.nextLine();
                
            if (choice.equalsIgnoreCase("a")) {
                verifyUser();
            }
            else if (choice.equalsIgnoreCase("b")) {
                newCustomer();
            }
            else if (choice.equalsIgnoreCase("c")) {
                System.out.println("Here are all the users who shop with us!");
                sortAccounts();
            }
            else if (choice.equalsIgnoreCase("d"))
                System.exit(0);
                break;
        }
        System.out.println("Thank you for shopping with us, and please come again! :)");
        System.out.println();
    }
    
    public static void verifyUser() 
    /**************************************************************************\
    * Purpose: To verify whether or not user has an Account in database
    * Parameters: N/A
    * Action: Takes the provided login info and checks SystemDB for 
    * an account that matches, If successful, user is logged in and directed to
    * account options menu. If unsuccessful, user is directed to login screen. 
    \**************************************************************************/
    {
            System.out.print("Please enter your login ID: ");
            String loginID = sc.nextLine();
            System.out.print("Please enter your password: ");
            String password = sc.nextLine();
            boolean hasAccount = SystemDB.isNewWebUser(loginID);
            if (hasAccount) {
                System.out.println("You are now logged in!");
                accountOptions(loginID);
            }
            else
                System.out.println("Your account was not found. Please try again or create a new account.");   
    }
    
    public static void newCustomer() 
    /**************************************************************************\
    * Purpose: To create a new Customer, Account, and ShoppingCart for User
    * Parameters: N/A
    * Action: Prompts user for necessary account information and uses it 
    * to create account for user. 
    \**************************************************************************/
    {
        System.out.println("Please enter to following information to set up your account.");
        System.out.print("Please enter a login ID: ");
        String customerID = sc.nextLine();
        System.out.print("Please enter a password: ");
        String password = sc.nextLine();

        WebUser wu = new WebUser(customerID, password); // Create new Web User
        SystemDB.storeWebUser(wu); 
        
        System.out.print("Please enter your full name (middle optional): ");
        String name = sc.nextLine();
        System.out.print("Please enter your street address (no state or zipCode): ");
        String street = sc.nextLine();
        System.out.print("Please enter your city of residence: ");
        String city = sc.nextLine();
        System.out.print("Please enter your state of residence: ");
        String state = sc.nextLine();
        System.out.print("Please enter your zipcode: ");
        String zip = sc.nextLine();           
        Address address = new Address(name, street, city, state, zip);

        System.out.print("Please enter your phone number: ");
        String phoneNum = sc.nextLine();
        Phone phone = new Phone(phoneNum);

        System.out.print("Please enter your email address: ");
        String email = sc.nextLine();

        Customer c = new Customer(customerID, address, phone, email);
        SystemDB.storeCustomer(c);   
        
        // Create a shopping cart for the customer
        Date dateCreated = new Date();
        ShoppingCart sc = new ShoppingCart(dateCreated, customerID);
        SystemDB.storeShoppingCart(sc);

        // Now create a new Account for them, like we promised!
        boolean isClosed = false;
        Date dateOpened = new Date();
        Account account = new Account(customerID, address, isClosed, dateOpened, sc);
        SystemDB.storeAccount(account);
        wu.setState(UserState.ACTIVE);

        System.out.println("\nCongratulations! Your new account with us is now Active.");
        accountOptions(customerID);
    }
    
    public static void accountOptions(String id) 
    /**************************************************************************\
    * Purpose: To Display Account options for user
    * Parameters: String id
    * Action: Displays menu with Account Options 
    * - If View Account Information: Prints out User's account info
    * - If Go Shopping: Takes User's Id and passes it to goShopping()
    * - If Place an Order: Takes User's Id and passes it to placeOrder()
    * - If Check status of Order: Takes User's Id and passes it to checkStatus()
    * - If Order Again: Takes User's Id and passes it to orderAgain()
    * - If View Shopping Cart: Takes User's Id and passes it to viewCart()
    * - If Exit Shopping Application: calls welcomeUser()
    \**************************************************************************/
    {
        String choice = "";
        
        while(!choice.equalsIgnoreCase("r")) {
            System.out.println("\n----- ACCOUNT SCREEN -----");
            System.out.println("Welcome " + id + "!");
            System.out.println("What would you like to do?");
            System.out.println("a. View Account Information");
            System.out.println("b. Go Shopping");
            System.out.println("c. Place an Order");
            System.out.println("d. Check on the status of an Order");
            System.out.println("e. Order again (Duplicate order)");
            System.out.println("f. View Shopping Cart");
            System.out.println("q. Exit the Shopping Application");
            choice = sc.nextLine();
            
            switch(choice) {
                
                case "a":
                    Account account = SystemDB.getUserAccount(id);
                    System.out.println(account);
                    break;
                
                case "b":
                    goShopping(id);
                    break;
                    
                case "c":
                    placeOrder(id);
                    break;
                    
                case "d":
                    checkStatus(id);
                    break;
                    
                case "e":
                    orderAgain(id);
                    break;
                    
                case "f":
                    viewCart(id);
                    break;
                    
                case "q":
                    welcomeUser();
                    break;
                    
                default:
                    System.out.println("Please enter a valid selection.");
                    break;                    
            }         
        }
        System.out.println();
    }
    
    public static void goShopping(String id) 
    /**************************************************************************\
    * Purpose: To display shopping options for user to purchase. When user 
    * selects a product to create an object for that Product and add it to
    * their shopping cart.
    * Parameters: String id
    * Action: Displays Shopping Screen with list of Products avaliable for 
    * purchase. User supplies productID and quantity and the corresponding 
    * Product and LineItem are created and added to their ShoppingCart
    \**************************************************************************/
    {
        String pId = "";
        String choice = "y";
        int quantity = 0;
        
        System.out.println("\n----- SHOPPING SCREEN -----");
        System.out.println("Here are our current available items from this month's featured brands:");

        while (choice.equalsIgnoreCase("y")) {
        
            System.out.println("----------------- LEVI -----------------");
            System.out.println("L1: 711 Skinny Jeans - $59.90");
            System.out.println("L2: 724 High Rise Straight Jeans - $59.90");
            System.out.println("L3: 315 Shaping Boot Cut Jeans - $69.90");
            System.out.println("----------------- NIKE -----------------");
            System.out.println("N1: Kyrie Low Basketball Shoe - $110.00");
            System.out.println("N2: Nike Roshe One Shoe - $75.00");
            System.out.println("N3: Nike Sportswear Swoosh Hoodie - $60.00");
            System.out.println("------------- RALPH LAUREN --------------");
            System.out.println("R1: Cable-Knit Cotton Sweater - $98.50");
            System.out.println("R2: Classic Fit Mesh Polo Shirt - $85.00");
            System.out.println("R3: Cotton Long-Sleeve Shirt - $68.00");
            
            System.out.println("\nPlease enter the ProductID (ex. N2) of the item you would like to add to your Shopping Cart.");
            pId = sc.nextLine();
            System.out.println("How many would you like to purchase? (Please enter a number)");
            quantity = Integer.parseInt(sc.nextLine());
           
            Product product = ProductDB.getProduct(pId);  // Get Product          
            LineItem item = new LineItem(quantity, product); // Create a line item
            SystemDB.addToCart(id, item);  // add item to cart
            
            System.out.println("Here is your current shopping cart:");
            ShoppingCart cart = SystemDB.getShoppingCart(id);
            cart.printCart();
        
            System.out.print("\nWould you like to continue shopping? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }      
    }
    
    public static void placeOrder(String id) 
    /**************************************************************************\
    * Purpose: To allow user to place and make Payment on Order
    * Parameters: String id
    * Action: Uses User's id to get and display their ShopppingCart.
    * - Asks User if they would like to place an order, if so, gets their Account
    * and creates new order object for it. At this time the User is also 
    * provided with the OrderId.
    * - Displays total of all items in Shopping Cart and asks user to confirm 
    * payment by typing in amount. If user does not pay for order at this time, 
    * the status of the order is set to HOLD until they pay. Otherwise the Order
    * will ship.
    * - The Payment made by the User is recorded in their account.
    \**************************************************************************/
    {
        String choice ="y";
        String orderNum = "OD";
        String payId = "P0";
        int orderCount = 1;
        double payment = 0.0;
        double totalDue = 0.0;
        
        System.out.println("\nHere is your current shopping cart: ");
        ShoppingCart cart = SystemDB.getShoppingCart(id);
        cart.printCart();
        totalDue = cart.getTotal();

        while (choice.equalsIgnoreCase("y")) {

            System.out.print("Would you like to place an order with these current items? (y/n):");
            choice = sc.nextLine();
            
            if (choice.equalsIgnoreCase("n")) {
                break;
            }

            // Get Account info and create an order
            Account account = SystemDB.getUserAccount(id);
            Address shipping = account.getBilling_address();
            Date dateOrdered = new Date();
            orderNum += Integer.toString(orderCount);
            Order order = new Order(orderNum, dateOrdered, shipping, totalDue);
            account.newOrder(order);
            orderCount++;
            
            System.out.println("Your order is ID is " + orderNum);
            System.out.println("Please remember to have this handy if you would like to check the status of your order later.");

            System.out.println("Your total is $" + totalDue);
                                    
            while (payment != -1) {

                System.out.println("Please confirm payment of $" + totalDue + " by typing it in below.");
                    System.out.println("NOTE: enter -1 to cancel your payment");
                payment = Double.parseDouble(sc.nextLine());

                if (payment < totalDue) {
                    System.out.println("The amount you entered was less than the total due. Please pay the amount in full.");
                    order.setStatus(OrderStatus.HOLD);
                }
                else if (payment > totalDue) {
                    System.out.println("The amount you entered was more than the total due. Please enter the exact amount.");
                    order.setStatus(OrderStatus.HOLD);
                }
                else if (payment == totalDue) {
                    System.out.println("Thank you for your payment! Your order is shipping now.");
                    payId += Integer.toString(orderCount);
                    Date datePaid = new Date();
                    Payment paid = new Payment(payId, datePaid, totalDue, "Paid in full");
                    account.newPayment(paid);
                    order.setStatus(OrderStatus.SHIPPED);
                    order.setShipped(datePaid);
                    accountOptions(id);
                }
                else if (payment == -1) {
                    break;
                }
            }
        }  
        System.out.println("Please enter a valid payment. Since you do not wish to pay at this time, your order will be placed on hold.");
        accountOptions(id);    
    } 
    
    public static void checkStatus(String id) 
    /**************************************************************************\
    * Purpose: To allow user to check the status of an Order they have placed.
    * Parameters: String id
    * Action: 
    * - Asks User for OrderID number, then uses it to search their account for 
    * an Order with a matching ID number.
    * - If found, the Order information is printed to the screen, else the User
    * is informed that their Order was not found.
    \**************************************************************************/
    {
        String orderID = "";
        
        Account account = SystemDB.getUserAccount(id); // get User Account
        
        System.out.println("Please enter your order ID: ");
        orderID = sc.nextLine();
        
         Order order = account.getOrder(orderID);
         if (order != null) {
         System.out.println(order);  
         }
         else {
             System.out.println("Your order was not found.");
             accountOptions(id);
         }    
    } 
    
    public static void orderAgain(String id) 
    /**************************************************************************\
    * Purpose: To allow user to check the status of an Order they have placed.
    * Parameters: String id
    * Action: 
    * - Asks User for OrderID number, then uses it to search their account for 
    * an Order with a matching ID number.
    * - If found, the Order information is printed to the screen, else the User
    * is informed that their Order was not found.
    \**************************************************************************/
    {
        String orderID = "";
        String payId = "PC1";
        double payment = 0.0;
        double totalDue = 0.0;
        
        Account account = SystemDB.getUserAccount(id); // get User Account
        
        System.out.println("Please enter your order ID: ");
        orderID = sc.nextLine();
        
        ShoppingCart cart = SystemDB.getShoppingCart(id);
        totalDue = cart.getTotal();
        
        Order order = account.getOrder(orderID);
        
        if (order != null) {
        try {
            Date datePaid = new Date();
            Order order2 = (Order) order.clone();
            order2.setNumber("OC1");
            order2.setStatus(OrderStatus.SHIPPED);
            order2.setOrdered(datePaid);
            account.newOrder(order2);
            System.out.println("We have charded your card. Your order is shipping now.");

            Payment paid = new Payment(payId, datePaid, totalDue, "Paid in full");
            account.newPayment(paid);
            order.setShipped(datePaid);
            accountOptions(id);
        } 
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(order);  
        }
        else {
            System.out.println("Your order was not found.");
            accountOptions(id);
        }        
    } 
    
    public static void viewCart(String id) 
    /**************************************************************************\
    * Purpose: To display the contents of the User's Shopping Cart
    * Parameters: String id
    * Action: Use User id to get shopping cart and call Comparator to sort it 
    * by Price and Quantity and display it to the User.
    \**************************************************************************/
    {
        ShoppingCart cart = SystemDB.getShoppingCart(id);
        System.out.println("Here are your Shopping Cart sorted by price the quantity: ");
        // Use Comparator to sort shoppingCart items
         SystemDB.useComparator(cart);
         accountOptions(id);
    }
    
    public static Date parseDate(String date)
    /**************************************************************************\
    * Purpose: To return Date object
    * Parameters: String date
    * Action: Turn String into Date object with yyyy-MM-dd format.
    \**************************************************************************/
    {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }   
        catch (ParseException e) {
                return null;
            }
     } 
      
     public static void sortAccounts() 
    /**************************************************************************\
    * Purpose: To sort the list of User Accounts using Comparable
    * Parameters: N/A
    * Action: Call SystemDB.Comparable() to sort all user accounts by id and 
    * print them.
    \**************************************************************************/
     {
         // Use Comparable to sort the accounts by username (id)
         System.out.println("These Accounts were sorted with Comparable:");
         SystemDB.useComparable();
     }
    
    public static void populateSystem() 
    /**************************************************************************\
    * Purpose: To populate the system with fictional customers for the purpose
    * of sorting and and working with the system
    * Parameters: N/A
    * Action: Create new Accounts with shopping carts and some with orders
    * placed
    \**************************************************************************/
    {
        // Create an account for fictional Lisa Latcher from PA
        Date date1 = parseDate("2014-02-14");
        ShoppingCart sc1 = new ShoppingCart(date1, "LLatcher23");
        SystemDB.storeShoppingCart(sc1);
        WebUser wu = new WebUser("LLatcher23", "1234"); // Create new Web User
        SystemDB.storeWebUser(wu);
        Address address1 = new Address("Lisa Latcher", "9659 Kent St.", "Erie", "PA", "16506");
        Account account1 = new Account("LLatcher23", address1, false, date1, sc1);
        SystemDB.storeAccount(account1);
        
        Product product1 = ProductDB.getProduct("L2");  // Get Product          
        LineItem item1 = new LineItem(2, product1); // Create a line item
        SystemDB.addToCart("LLatcher23", item1);  // add item to cart
        
        Product product2 = ProductDB.getProduct("L3");  // Get Product          
        LineItem item2 = new LineItem(1, product2); // Create a line item
        SystemDB.addToCart("LLatcher23", item2);  // add item to cart
        
        Product product3 = ProductDB.getProduct("R1");  // Get Product          
        LineItem item3 = new LineItem(1, product3); // Create a line item
        SystemDB.addToCart("LLatcher23", item3);  // add item to cart
            
        
        //  Create an account for fictional Nate Nixon from NY
        Date date2 = parseDate("2017-05-15");
        ShoppingCart sc2 = new ShoppingCart(date1, "NNixon92");
        SystemDB.storeShoppingCart(sc2);
        WebUser wu2 = new WebUser("NNixon92", "1234"); // Create new Web User
        SystemDB.storeWebUser(wu2);
        Address address2 = new Address("Nate Nixon", "589 Cherry Hill St.", "Patchogue", "NY", "11772");
        Account account2 = new Account("NNixon92", address2, false, date2, sc2);
        SystemDB.storeAccount(account2);
        
        Product product4 = ProductDB.getProduct("N2");  // Get Product          
        LineItem item4 = new LineItem(1, product4); // Create a line item
        SystemDB.addToCart("NNixon92", item4);  // add item to cart
        
        Product product5 = ProductDB.getProduct("N1");  // Get Product          
        LineItem item5 = new LineItem(1, product5); // Create a line item
        SystemDB.addToCart("NNixon92", item5);  // add item to cart
        
        // Create an Order
        Date datePaid = parseDate("2019-02-20");
        double totalDue = sc2.getTotal();
        Order order2 = new Order("OD24", datePaid, address2, totalDue);
        account2.newOrder(order2);
        Payment paid = new Payment("PO24", datePaid, totalDue, "Paid in full");
        account2.newPayment(paid);
        order2.setStatus(OrderStatus.DELIVERED);
        order2.setShipped(datePaid);
        
        
        // Create an account for fictional Robert Russell from RI
        Date date3 = parseDate("2010-10-02");
        ShoppingCart sc3 = new ShoppingCart(date3, "RRusell52");
        SystemDB.storeShoppingCart(sc3);
        WebUser wu3 = new WebUser("RRusell52", "1234"); // Create new Web User
        SystemDB.storeWebUser(wu3);
        Address address3 = new Address("Robert Russell", "47 Peg Shop Street", "North Kingstown", "RI", "02852");
        Account account3 = new Account("RRusell52", address3, false, date3, sc3);
        SystemDB.storeAccount(account3);
        
        Product product6 = ProductDB.getProduct("R2");  // Get Product          
        LineItem item6 = new LineItem(3, product6); // Create a line item
        SystemDB.addToCart("RRusell52", item6);  // add item to cart
        
        // Create an Order
        Date datePaid2 = parseDate("2019-02-24");
        double totalDue2 = sc3.getTotal();
        Order order3 = new Order("OD14", datePaid2, address3, totalDue2);
        account3.newOrder(order3);
        Payment paid2 = new Payment("PO14", datePaid2, totalDue2, "Paid in full");
        account3.newPayment(paid2);
        order3.setStatus(OrderStatus.SHIPPED);
        order3.setShipped(datePaid2);
        
        
        // Create an account for fictional Carrie Anne from FA
        Date date4 = parseDate("2018-12-28");
        ShoppingCart sc4 = new ShoppingCart(date4, "CAnne97");
        SystemDB.storeShoppingCart(sc4);
        WebUser wu4 = new WebUser("CAnne97", "1234"); // Create new Web User
        SystemDB.storeWebUser(wu4);
        Address address4 = new Address("Carrie Anne", "58 Rock Maple St.", "Cape Coral", "FL", "33904");
        Account account4 = new Account("CAnne97", address4, false, date4, sc4);
        SystemDB.storeAccount(account4);
        
        // Create an account for fictional Pablo Cortez from AZ
        Date date5 = parseDate("2015-06-15");
        ShoppingCart sc5 = new ShoppingCart(date5, "PCortez75");
        SystemDB.storeShoppingCart(sc4);
        WebUser wu5 = new WebUser("PCortez75", "1234"); // Create new Web User
        wu5.setState(UserState.BANNED);
        SystemDB.storeWebUser(wu5);
        Address address5 = new Address("Pablo Cortez", "7774 Argyle Lane", "Glendale", "AZ", "85302");
        Account account5 = new Account("PCortez75", address5, true, date5, sc5);
        SystemDB.storeAccount(account5);   
    } 
}
