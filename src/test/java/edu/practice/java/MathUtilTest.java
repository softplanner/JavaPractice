package edu.practice.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.Exception.*;

public class MathUtilTest {

    MathUtil mathUtils;

    @BeforeEach
    public void init(){
        mathUtils = new MathUtil();
    }

    @Test
    public void testAdd(){
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    public void testCircleArea(){
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10.0),
                "should return correct area value");
    }

    @Test
    public void testDivide(){
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1,0),
                "divide by 0 should throw exception.");
    }
}
