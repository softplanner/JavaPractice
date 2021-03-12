package edu.practice.java;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    @DisplayName("Testing add method.")
    void testAdd(){
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method compute circle area.")
    void testCircleArea(){
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10.0),
                "should return correct area value");
    }

    @Test
    @DisplayName("Testing divide method using assumption.")
    void testDivide(){
        boolean isServerUp = true;
        assumeTrue(isServerUp); // if false then ignore the test
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1,0),
                "divide by 0 should throw exception.");
    }

    @Test
    @Disabled
    @DisplayName("TODO method, should not run.")
    void testSomething(){
        fail("implements late.");
    }
}
