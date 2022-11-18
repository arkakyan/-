/*
 * TCSS 305 Autumn 2022 
 * Assignment 2
 * 
 * This is the Item Test Class.
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is the test class for Item.
 * 
 * @author  Khin Win
 * @version 21 Oct 2022
 *
 */
public class ItemTest {
    
    /**A default BigDecimal value for this test. */
    private static final BigDecimal BULKPRICE_DEFAULT = new BigDecimal("10.00");
    
    /** A default value for this test. */
    private static final int BULKQUANTITY_DEFAULT = 4;
    
    /** An Item to use in the tests. */
    private Item myItem;

    @BeforeEach
    // This method runs before EACH test method.
    public void setUp() { // no need to throw any exceptions!
        myItem = new Item("Silly Putty", new BigDecimal("1.45"), 4, new BigDecimal("10.00"));
    }
    
    /**
     * Test method for OverLoadConstructor for Name and Price
     * 
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    public void testConstructor() {
        final Item item1 = new Item("Silly Putty", new BigDecimal("1.45"), 
                BULKQUANTITY_DEFAULT, BULKPRICE_DEFAULT);
        
        assertEquals(item1.getName(), myItem.getName());
        assertEquals(item1.getPrice(), myItem.getPrice());
        assertEquals(item1.getBulkQuantity(), myItem.getBulkQuantity());
        assertEquals(item1.getBulkPrice(), myItem.getBulkPrice());
    }
    
    /**
     * Test method for Name, Price, BulkQuantity, and BulkPrice.
     *
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal,
     * int, java.math.BigDecimal)}.
     */
    @Test
    public void testOverloadedConstructor() {
        
        new Item("Silly Putty", new BigDecimal("1.45"), 4, new BigDecimal("10.00"));
        assertEquals("Silly Putty" , myItem.getName());
        assertEquals(new BigDecimal("1.45"), myItem.getPrice());
        assertEquals(4, myItem.getBulkQuantity());
        assertEquals(new BigDecimal("10.00"), myItem.getBulkPrice());
       
    }
    /**
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        final Item item1 = new Item("Silly Putty", new BigDecimal("1.45"),
                4, new BigDecimal("10.00"));
        assertEquals(myItem.hashCode(), item1.hashCode());
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        final Item item2 = new Item("Iphone", new BigDecimal("1200.00"),
                2, new BigDecimal("2000.00"));
        assertTrue(item2.isBulk());
        final Item item3 = new Item("Iphone", new BigDecimal("1200.00"),
                1, new BigDecimal("2000.00"));
        assertFalse(item3.isBulk());
        
    }
  
    /**
     * Test method for toString.
     * {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        
        assertEquals("Silly Putty, $1.45 (4 for $10.00)", myItem.toString());
        assertNotEquals("Pencil, $1.10)", myItem.toString());
    }
    
    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        final Item item4 = new Item("Photo", new BigDecimal("12.00"),
                5, new BigDecimal("55.00"));
        final Item item5 = new Item("Silly Putty", new BigDecimal("1.45"),
                5, new BigDecimal("10.00"));
        final Item item6 = new Item("Silly Putty", new BigDecimal("1.45"),
                4, new BigDecimal("11.00"));
        final Item item7 = new Item("Photo", new BigDecimal("1.45"));
        final Item item8 = new Item("Photo", new BigDecimal("1.45"));
        assertNotEquals(myItem, item5);
        assertNotEquals(myItem, item6);
        assertNotEquals(myItem, item7);
        assertNotEquals(myItem, item8);
        assertEquals(item7, item8);
        assertEquals(item4, item4);
        assertNotEquals(myItem, null);
        assertNotEquals(myItem, new Item("Phone", new BigDecimal("1000.00")
                , 2, new BigDecimal("1700")));
    }
  

}
