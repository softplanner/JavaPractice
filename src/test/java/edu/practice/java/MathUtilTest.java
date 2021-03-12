package edu.practice.java;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("When running MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilTest {

    MathUtil mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This need to run before all.");
    }

    @BeforeEach
    void setup(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtil();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    public void cleanUp(){
        System.out.println("de-allocating resources.");
    }

    @Nested
    @Tag("Math")
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

    @Test
    @DisplayName("Testing divide method using assumption.")
    @Tag("Math")
    void testDivide(){
        boolean isServerUp = true;
        assumeTrue(isServerUp); // if false then ignore the test
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1,0),
                "divide by 0 should throw exception.");
    }

    @Test
    @DisplayName("Testing multiply method.")
    @Tag("Math")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2), "should return the right product."),
                () -> assertEquals(0, mathUtils.multiply(2,0), "should return the right product."),
                () -> assertNotEquals(8, mathUtils.multiply(5,2), "should return the right product.")
        );
    }

    //@Test
    @RepeatedTest(3)
    @DisplayName("Testing method compute circle area.")
    @Tag("Circle")
    void testCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10.0), "should return correct area value");
    }

    @Test
    @Disabled
    @DisplayName("TODO method, should not run.")
    void testSomething(){
        fail("implements late.");
    }
}
