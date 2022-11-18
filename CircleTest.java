/*
 * TCSS 305 Autumn 2022 
 * Assignment 1
 * 
 * This is the test class for Circle class.
 */

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;
import java.awt.geom.Point2D;
import model.Circle; //Since the Circle class is not in the same package, we need to import it.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of the Circle class.
 * 
 * @author  Khin Win
 * @version 09 October 2022
 */
class CircleTest {

    /**
     * This double Tolerance value checks whether actual and expected values are
     * very close each other or not.
     */
    private static final double TOLERANCE = .000001;

    /** This is a valid input radius value for testing. */
    private static final double VALID_RADIUS = 2.0;

    /** This is a valid input point that for testing. */
    private static final Point2D VALID_CENTER = new Point2D.Double(2, 2);

    /** This is an input Color for testing. */
    private static final Color VALID_COLOR = Color.BLUE;

    /** This is an input invalid radius value for testing. */
    private static final double INVALID_RADIUS = -1;

    /** This is an invalid null point for testing. */
    private static final Point2D INVALID_CENTER = null;

    /** This is an invalid null color for testing. */
    private static final Color INVALID_COLOR = null;

    /**
     * Create a circle point that will use in this test class.
     */
    private Circle myCircle;

    /**
     * This method runs before each test methods.
     */
    @BeforeEach
    public void setUp() {
        myCircle = new Circle();
    }

    /**
     * Test for Overloaded Constructor.
     */
    @Test
    public void testValidCircle() {
        final Circle c1 = new Circle(VALID_RADIUS, VALID_CENTER, VALID_COLOR);
        assertEquals(VALID_RADIUS, c1.getRadius(), TOLERANCE);
        assertEquals(VALID_CENTER.getX(), c1.getCenter().getX(), TOLERANCE);
        assertEquals(VALID_CENTER.getY(), c1.getCenter().getY(), TOLERANCE);
        assertEquals(VALID_COLOR, c1.getColor());
    }

    /**
     * This method tests when Radius has an invalid value, it throws Illegal
     * Argument Exception or not.
     */
    @Test
    public void testInvalidRadiusNull() {
        assertThrows(IllegalArgumentException.class,
                     () -> new Circle(INVALID_RADIUS, VALID_CENTER, VALID_COLOR));
    }

    /**
     * This method tests when Center is null, it throws Illegal Argument
     * Exception or not.
     */
    @Test
    public void testInvalidCenterPointNull() {
        assertThrows(NullPointerException.class,
                     () -> new Circle(VALID_RADIUS, INVALID_CENTER, VALID_COLOR));
    }

    /**
     * This method tests when Color has a invalid input, it throws Illegal
     * Argument Exception or not.
     */
    @Test
    public void testInvalidColorNull() {
        assertThrows(NullPointerException.class,
                     () -> new Circle(VALID_RADIUS, VALID_CENTER, INVALID_COLOR));
    }

    /**
     * Test method for the Default Constructor.
     */
    @Test
    public void testDefaultCircle() {
        assertEquals(1, myCircle.getRadius(), TOLERANCE);
        assertEquals(0, myCircle.getCenter().getX());
        assertEquals(0, myCircle.getCenter().getY());
        assertEquals(Color.BLACK, myCircle.getColor());
    }

    /**
     * Test method for {@link model.Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(VALID_RADIUS);

        /**
         * This equal method test whether actual radius and expected radius are
         * are equal or not.
         */
        assertEquals(myCircle.getRadius(), VALID_RADIUS, TOLERANCE);
    }

    /**
     * Test for the radius and see if throws exception or not when radius value
     * is not valid.
     */
    @Test
    public void testSetInvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            myCircle.setRadius(INVALID_RADIUS);
        });
    }

    /**
     * Test method for {@link model.Circle #setCenter(java.awt.geom.Point2D)}.
     * 
     */
    @Test
    public void testSetCenter() {
        myCircle.setCenter(VALID_CENTER);
        assertEquals(myCircle.getCenter(), VALID_CENTER);
    }

    /**
     * This method tests that it throws exception or not when Center has null
     * value.
     */
    @Test
    public void testSetCenterNull() {
        assertThrows(NullPointerException.class,
                     () -> new Circle(VALID_RADIUS, INVALID_CENTER, VALID_COLOR));
    }

    /**
     * Test method for {@link model.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(VALID_COLOR);
        assertEquals(myCircle.getColor(), VALID_COLOR);
    }

    /**
     * This method tests that it throws exception or not when Color has null
     * value.
     */
    @Test
    public void testSetColorNull() {
        assertThrows(NullPointerException.class,
                     () -> new Circle(VALID_RADIUS, VALID_CENTER, INVALID_COLOR));
    }

    /**
     * Test method for {@link model.Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        assertEquals(2, myCircle.calculateDiameter(), TOLERANCE);

    }

    /**
     * Test method for {@link model.Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        final double testCircumference = myCircle.calculateDiameter() * Math.PI;
        assertEquals(testCircumference, myCircle.calculateCircumference(), TOLERANCE);
    }

    /**
     * Test method for {@link model.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {
        final double testArea = myCircle.getRadius() * myCircle.getRadius() * Math.PI;
        assertEquals(testArea, myCircle.calculateArea(), TOLERANCE);
    }

    /**
     * Test method for {@link model.Circle#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Circle [radius=1.00, center=Point2D.Double[0.0, 0.0],"
                     + " color=java.awt.Color[r=0,g=0,b=0]]", myCircle.toString());
    }

}
