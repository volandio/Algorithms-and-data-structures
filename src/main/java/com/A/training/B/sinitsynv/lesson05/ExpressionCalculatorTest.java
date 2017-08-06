package com.A.training.B.sinitsynv.lesson05;

import static com.A.training.B.util.Assert.assertEquals;

public class ExpressionCalculatorTest {
    public static void main(String[] args) {
        testDoTrans();
    }

    private static void testDoTrans() {
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        String test = "2*(3+5)";
        assertEquals("ExpressionCalculatorTest.testDoTrans", "235+*", expressionCalculator.doTrans(test));
    }
}
