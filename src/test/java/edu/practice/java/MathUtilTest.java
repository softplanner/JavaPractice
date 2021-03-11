package edu.practice.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.lang.Exception.*;

public class MathUtilTest {

    MathUtil mathUtils;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This need to run before all.");
    }

    @BeforeEach
    void setup(){
        mathUtils = new MathUtil();
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("de-allocating resources.");
    }

    @Test
    void testAdd(){
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    void testCircleArea(){
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10.0),
                "should return correct area value");
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1,0),
                "divide by 0 should throw exception.");
    }

    // assumption example
    @Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), MathUtilTest::message);
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }
}
