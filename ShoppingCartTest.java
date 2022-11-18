/*
 * TCSS 305 Autumn 2022 
 * Assignment 2
 * 
 * This is the Shopping Cart Test Class.
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import model.Item;  // we need to import Item class, since we have to calculate the total.
import model.ShoppingCart; // we also need to import Shopping class.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This is the test class for Shopping Cart.
 * 
 * @author  Khin Win
 * @version 21 Oct 2022
 *
 */
public class ShoppingCartTest {
    
    /** creating a default item for Object. */
    private final Item myDefaultItem1 = new Item("Silly Putty", 
            BigDecimal.valueOf(1.45), 5, BigDecimal.valueOf(5.00));
    
    /** creating a default item that doesn't have bulk price. */
    private final Item myDefaultItem3 = new Item("Pen", 
            BigDecimal.valueOf(3.00), 1, BigDecimal.valueOf(0));
    
    /** A map that will use in this test. */
    private ShoppingCart myShoppingCart;
    
    /**
     * Set an empty map before each test.
     */
    @BeforeEach
    // This method runs before EACH test method.
    public void setUp() { // no need to throw any exceptions!
        myShoppingCart = new ShoppingCart();
       
    }

    /**
     * Test method for Default Constructor.
     * {@link model.ShoppingCart#ShoppingCart()}.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals("Silly Putty", myDefaultItem1.getName());
        assertEquals(BigDecimal.valueOf(1.45), myDefaultItem1.getPrice());
        assertEquals(5.0, myDefaultItem1.getBulkQuantity());
        assertEquals(new BigDecimal("5.0"), myDefaultItem1.getBulkPrice());
        
    }
    
    /**
     * Test method for add.
     * {@link model.ShoppingCart#add(model.Item, int)}.
     */
    @Test
    public void testAdd() {
        myShoppingCart.add(myDefaultItem1, 6);
        assertEquals(BigDecimal.valueOf(6.45), myShoppingCart.calculateTotal());
    }

    /**
     * Test method for {@link model.ShoppingCart#setMembership(boolean)}.
     */
    @Test
    public void testSetMembership() {
        myShoppingCart.setMembership(true);
        
        final Item defaultItem2 = new Item("Java Pen", 
                BigDecimal.valueOf(2.00), 4, BigDecimal.valueOf(6.00));
        myShoppingCart.add(defaultItem2, 20);
        assertEquals(new BigDecimal("27.00"), myShoppingCart.calculateTotal());
        
    }
    
    /**
     * Test method for Bulk Items.
     * {@link model.ShoppingCart#calculateTotal()}.
     */
    @Test
    public void testCalculateBulkTotal() {
        myShoppingCart.add(myDefaultItem1, 5);
        assertEquals(new BigDecimal("5.00"), myShoppingCart.calculateTotal());
    }    
  
    /**
     * Test method for Single Item.
     * {@link model.ShoppingCart#calculateTotal()}.
     */
    @Test
    public void testCalculateSingleTotal() {
        myShoppingCart.add(myDefaultItem3, 4);
        assertEquals(new BigDecimal("12.00"), myShoppingCart.calculateTotal());
    }

    /**
     * Test method for {@link model.ShoppingCart#clear()}.
     */
    @Test
    void testClear() {
        myShoppingCart.setMembership(true);
        myShoppingCart.add(myDefaultItem1, 1);
        myShoppingCart.add(myDefaultItem3, 2);
        myShoppingCart.clear();
        assertEquals(new BigDecimal("0.00"), myShoppingCart.calculateTotal());
        
    }

}
