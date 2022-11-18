/*
 * TCSS 305 Autumn 2022 
 * Assignment 2
 * 
 * This is the Item Class.
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * This class stores the individual informations about items.
 * 
 * @author  Khin Win
 * @version 15 Oct 2022
 *
 */

public final class Item {

    
    /**A default BigDecimal value for my bulk quantity. */
    private static final BigDecimal BULKPRICE_DEFAULT = BigDecimal.ZERO;
    
    /** A default value for the bulk quantity. */
    private static final int BULKQUANTITY_DEFAULT = 1;

    /** The name of the product. */
    private final String myProductName;

    /** The product price for individual quantity. */
    private final BigDecimal myPrice;

    /** The product price for bulk quantity. */
    private final BigDecimal myBulkPrice;

    /** The bulk quantity. */
    private final int myBulkQuantity;
    
   

    /**
     * Constructs a product Item with the name and price.
     * 
     * @param theName  The name to assign to this item.
     * @param thePrice The price to assign to this item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        myProductName = theName;
        myPrice = thePrice;
        myBulkPrice = BULKPRICE_DEFAULT;
        myBulkQuantity = BULKQUANTITY_DEFAULT;

    }

    /**
     * Constructs bulk items with give name, price, bulk price, and bulk quantity.
     * 
     * @param theName         The name to assign to this item.
     * @param thePrice        The price assign to this item.
     * @param theBulkQuantity The bulk Quantity assign to this item.
     * @param theBulkPrice    The Bulk Price assign to this item.
     * 
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
            final BigDecimal theBulkPrice) {
        myProductName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;

    }

    public String getName() {

        return myProductName;
    }

    public BigDecimal getPrice() {

        return myPrice;
    }

    public int getBulkQuantity() {

        return myBulkQuantity;
    }

    public BigDecimal getBulkPrice() {
       
        return myBulkPrice;
    }
    /**
     * If Bulk Quantity is greater than 1, it will return true; otherwise, false.
     * 
     * @return boolean value.
     */
    public boolean isBulk() {
        if (myBulkQuantity > 1) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * The String representation of this Item will be formated as follows: 
     * <br> Xbox One X, $ 620.00 
     * <br> Silly Putty, $1.45 (5 for $5.00)
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        builder.append(myProductName);
        builder.append(", ");
        builder.append(nf.format(myPrice));

        /**
         * If myBulkQuatity value is Bulk, it will add the following values.
         * 
         */
        if (isBulk()) {
            builder.append(" (");
            builder.append(myBulkQuantity);
            builder.append(" for ");
            builder.append(nf.format(myBulkPrice));
            builder.append(")");
        }
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     * 
     * This method compares the name, the price, the bulk quantity, and the bulk
     * price to determine the equality of Item objects.
     */

    @Override
    public boolean equals(final Object theOther) {

        // return true if identical objects are same in the memory address
        if (this == theOther) {
            return true;
        }

        // return false if the parameter is null
        if (theOther == null) {
            return false;
        }

        // return false if the classes don't match, they can't be equal
        if (getClass() != theOther.getClass()) {
            return false;
        }
        // We know otherItem is a non-null items.
        final Item otherItem = (Item) theOther;

        /**
         * Test whether the fields have identical values. Check for bulk items if not
         * return single item.
         */
        if (isBulk()) {
            return myProductName.equals(otherItem.myProductName) 
                    && myPrice.equals(otherItem.myPrice)
                    && myBulkQuantity == otherItem.myBulkQuantity 
                    && myBulkPrice.equals(otherItem.myBulkPrice);
        } else {
            return myProductName.equals(otherItem.myProductName) 
                    && myPrice.equals(otherItem.myPrice);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(myProductName, myPrice, myBulkQuantity, myBulkPrice);

    }

}
