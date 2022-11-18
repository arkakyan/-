/*
 * TCSS 305 Autumn 2022 
 * Assignment 2
 * 
 * This is the Shopping Cart Class.
 */
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * This shopping cart contains the Item, Quantity, and Total Price.
 * 
 * @author  Khin Win
 * @version 15 Oct 2022
 * 
 */

public class ShoppingCart {

    /** creating a constant membership discount amount. */
    private static final BigDecimal MEMBER_DISCOUNT = new BigDecimal("0.1");

    /** Initialize the Map. */
    private final Map<Object, Integer> myCart;

    /** This is boolean variable. */
    private boolean myMemberShip;

    /** This constructor creates an empty shopping cart. */
    public ShoppingCart() {
        // create a map for shopping cart.
        myCart = new HashMap<Object, Integer>();

    }
    // Adding new order and old order.
    public void add(final Item theItem, final int theQuantity) {
        myCart.put(theItem, theQuantity);
    }

    /**
     * This method checks whether customer has membership or not.
     * 
     * @param theMembership returns true if the customer has membership.
     */

    public void setMembership(final boolean theMembership) {
        myMemberShip = theMembership;
    }

    /**
     * This method calculates the total amount of cart.
     * 
     * @return The total amount of the order.
     */
    public BigDecimal calculateTotal() {
        // Initialize the orderTotalAmount.
        BigDecimal orderTotalAmount = BigDecimal.ZERO;
        // Check items that stores in the map.
        for (final Object item : myCart.keySet()) {
            // Check it has bulk quantity or not, and return the total price.
            if (((Item) item).isBulk()) {
                orderTotalAmount = orderTotalAmount.add(BigDecimal.valueOf(myCart.get(item)
                        / ((Item) item).getBulkQuantity()).multiply(((Item) item).
                                getBulkPrice()));
                orderTotalAmount = orderTotalAmount.add(BigDecimal.valueOf(myCart.get(item) 
                        % ((Item) item).getBulkQuantity()).multiply(((Item) item).getPrice()));
            } else { 
                // if it doesn't have bulk quantity returns single item.
                orderTotalAmount = orderTotalAmount.add(BigDecimal.valueOf(myCart.get(item)).
                        multiply(((Item) item).getPrice()));
            }
        }
        /**
         *  If customer has membership and they buy more than $15, then it will apply
         *  membership discount.
         */
        if (myMemberShip && orderTotalAmount.compareTo(new BigDecimal("15")) == 1) {
            // finding a discount amount that will apply to original price.
            final BigDecimal discountAmount = MEMBER_DISCOUNT.multiply(orderTotalAmount);
            // return the orderTotal
            orderTotalAmount = orderTotalAmount.subtract(discountAmount);
        }
        
        return orderTotalAmount.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * This method remove the order from the cart.
     */
    public void clear() {
        myCart.clear();
    }

}
