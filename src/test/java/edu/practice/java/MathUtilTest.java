package edu.practice.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilTest {

    @Test
    public void addTest(){
        MathUtil mathUtils = new MathUtil();
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    public void circleAreaTest(){
        MathUtil mathUtils = new MathUtil();
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10.0),
                "should return correct area value");
    }
}
