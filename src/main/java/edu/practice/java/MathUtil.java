package edu.practice.java;

public class MathUtil {

    public int add(int a, int b){
        return a + b;
    }

    public static int addStatic(int a, int b){
        return a + b;
    }

    public double computeCircleArea(double radius){
        return Math.PI * radius * radius;
    }

    public int divide(int numerator, int denominator){
        return numerator/denominator;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
