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
* Purpose: The ProductDB class simulates a Product Database that would be used
* in a more realistic shopping application. Products are created and retrieved
* from this class upon request by the User
*
* Input: The product code
*
* Preconditions/Assumptions: Only positive integers are input
*
* Output: A Product object corresponding to the received product code
*
* Algorithm:
* Create and store Suppliers
* get Product that matched received Product code
*******************************************************************************/ 
package Wiggins.data;

import Wiggins.business.Supplier;
import Wiggins.business.*;

public class ProductDB {
    
    private static Supplier[] suppliers = new Supplier[3];

    public static void createSuppliers() 
    /**************************************************************************\
    * Purpose: To create and store the Supplier objects
    * Parameters: N/A
    * Action: Creates and stores 3 Supplier objects
    \**************************************************************************/
    {    
        // create the Suppliers
        suppliers[0] = new Supplier("Levi");
        suppliers[1] = new Supplier("Nike");
        suppliers[2] = new Supplier("Ralph Lauren");  
    }
    
    public static Product getProduct(String pID) 
    /**************************************************************************\
    * Purpose: To create and return the Product corresponding with the 
    * product code provided from the Main class
    * Parameters: String pID
    * Action: Creates a product object and sets its attributes according to
    * which product code was received, then returns the product.
    \**************************************************************************/
    {     
    // Create a Product Object
    Product product = new Product();
    
    if (pID.equalsIgnoreCase("L1")) {
        product.setId("L1");
        product.setName("711 Skinny Jeans");
        product.setSupplier(suppliers[0]);
        product.setPrice(59.50);
    }
    else if (pID.equalsIgnoreCase("L2")) {
        product.setId("L2");
        product.setName("724 High Rise Straight Jeans");
        product.setSupplier(suppliers[0]);
        product.setPrice(59.50);
    }
    else if (pID.equalsIgnoreCase("L3")) {
        product.setId("L3");
        product.setName("315 Shaping Boot Cut Jeans");
        product.setSupplier(suppliers[0]);
        product.setPrice(69.50);
    }
    else if (pID.equalsIgnoreCase("N1")) {
        product.setId("N1");
        product.setName("Kyrie Low Basketball Shoe");
        product.setSupplier(suppliers[1]);
        product.setPrice(110.00);
    }
    else if (pID.equalsIgnoreCase("N2")) {
        product.setId("N2");
        product.setName("Nike Roshe One Shoe");
        product.setSupplier(suppliers[1]);
        product.setPrice(75.00);
    }
    else if (pID.equalsIgnoreCase("N3")) {
        product.setId("N3");
        product.setName("Nike Sportswear Swoosh Hoodie");
        product.setSupplier(suppliers[1]);
        product.setPrice(60.00);
    }
    else if (pID.equalsIgnoreCase("R1")) {
        product.setId("R1");
        product.setName("Cable-Knit Cotton Sweater");
        product.setSupplier(suppliers[2]);
        product.setPrice(98.50);
    }
    else if (pID.equalsIgnoreCase("R2")) {
        product.setId("R2");
        product.setName("Classic Fit Mesh Polo Shirt");
        product.setSupplier(suppliers[2]);
        product.setPrice(85.00);
    }
    else if (pID.equalsIgnoreCase("R3")) {
        product.setId("R3");
        product.setName("Cotton Long-Sleeve Shirt");
        product.setSupplier(suppliers[2]);
        product.setPrice(68.00);
    }  
    return product;
    }
    
}
