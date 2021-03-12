package edu.practice.java;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When running MathUtils")
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

    @Nested
    class TestAdd {

        @Test
        @DisplayName("Testing add positive numbers.")
        void testAddPositive(){
            assertEquals(2, mathUtils.add(1,1), "should return the right sum.");
        }

        @Test
        @DisplayName("Testing add negative numbers.")
        void testAddNegative(){
            assertEquals(-2, mathUtils.add(-1,-1), () -> "should return the right sum.");
        }
    }

    //@Test
    @RepeatedTest(3)
    @DisplayName("Testing method compute circle area.")
    void testCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10.0), "should return correct area value");
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
    @DisplayName("Testing multiply method.")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2), "should return the right product."),
                () -> assertEquals(0, mathUtils.multiply(2,0), "should return the right product."),
                () -> assertNotEquals(8, mathUtils.multiply(5,2), "should return the right product.")
        );
    }

    @Test
    @Disabled
    @DisplayName("TODO method, should not run.")
    void testSomething(){
        fail("implements late.");
    }
}
