package com.A.training.B.sinitsynv.lesson03;

import static com.A.training.B.util.Assert.assertEquals;
import static com.A.training.B.util.Assert.fail;

public class DynamicArrayTest {
    private static final String MSG_ASSERTION_ERROR = "AssertionError ";
    private static final String MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = "ArrayIndexOutOfBoundsException";
    private static final Object NUMBER_TWO = 2;
    private static final Object NUMBER_THREE = 3;

    public static void main(String[] args) {
        testBooleanAdd();
        testAddToBegin();
        testAddToMiddle();
        testAddToEnd();
        testSet();
        testGet();
        testRemoveInBegin();
        testRemoveInMiddle();
        testRemoveInEnd();
        testBooleanRemove();
        testSize();
        testIndexOf();
        testContains();
        testToArray();
    }

    private static DynamicArray getNewDynamicArraySizeThree() {
        DynamicArray dynamicArray = new DynamicArray(3);
        for (int i = 0; i < 3; i++) {
            dynamicArray.add(i);
        }
        return dynamicArray;
    }

    private static void testBooleanAdd() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        dynamicArray.add(3);
        Object[] testArray = {0, 1, 2, 3};
        assertEquals("DynamicArrayTest.testBooleanAdd", testArray, dynamicArray.toArray());
    }

    private static void testAddToBegin() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.add(0, 3);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {3, 0, 1, 2};
        assertEquals("DynamicArray.testAddBegin", expected, dynamicArray.toArray());
    }

    private static void testAddToMiddle() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.add(1, 3);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {0, 3, 1, 2};
        assertEquals("DynamicArray.testAddToMiddle", expected, dynamicArray.toArray());
    }

    private static void testAddToEnd() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.add(2, 3);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {0, 1, 3, 2};
        assertEquals("DynamicArray.testAddToEnd", expected, dynamicArray.toArray());
    }

    private static void testSet() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        dynamicArray.set(0, 1);
        Object[] expected = {1, 1, 2};
        assertEquals("DynamicArrayTest.testSet", expected, dynamicArray.toArray());
    }

    private static void testGet() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        assertEquals("DynamicArrayTest.testGet", 2, (int) dynamicArray.get(2));
    }

    private static void testRemoveInBegin() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.remove(0);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {1, 2, null};
        assertEquals("DynamicArray.testRemoveInBegin", expected, dynamicArray.toArray());
    }

    private static void testRemoveInMiddle() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.remove(1);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {0, 2, null};
        assertEquals("DynamicArray.testRemoveInMiddle", expected, dynamicArray.toArray());
    }

    private static void testRemoveInEnd() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        try {
            dynamicArray.remove(2);
            fail(MSG_ASSERTION_ERROR);
        } catch (Exception e) {
            assertEquals(MSG_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, e.getMessage());
        } catch (AssertionError e) {
            assertEquals(MSG_ASSERTION_ERROR, e.getMessage());
        }
        Object[] expected = {0, 1, null};
        assertEquals("DynamicArray.testRemoveInEnd", expected, dynamicArray.toArray());
    }

    private static void testBooleanRemove() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        assertEquals("DynamicArrayTest.testBooleanRemoveTest1", true, dynamicArray.remove(NUMBER_TWO));
        assertEquals("DynamicArrayTest.testBooleanRemoveTest2", false, dynamicArray.remove(NUMBER_THREE));
    }

    private static void testSize() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        assertEquals("DynamicArrayTest.testSize", 3, dynamicArray.size());
    }

    private static void testIndexOf() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        assertEquals("DynamicArrayTest.testIndexOf", 2, dynamicArray.indexOf(NUMBER_TWO));
    }

    private static void testContains() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        assertEquals("DynamicArrayTest.testContainsTest1", true, dynamicArray.contains(NUMBER_TWO));
        assertEquals("DynamicArrayTest.testContainsTest2", false, dynamicArray.contains(NUMBER_THREE));
    }

    private static void testToArray() {
        DynamicArray dynamicArray = getNewDynamicArraySizeThree();
        Object[] expected = {0, 1, 2};
        assertEquals("DynamicArrayTest.testToArray", expected, dynamicArray.toArray());
    }
}
