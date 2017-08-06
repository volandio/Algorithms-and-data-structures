package com.A.training.B.sinitsynv.lesson09.balanced;

import static com.A.training.B.util.Assert.assertEquals;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        testAdd();
        testRemove();
    }

    private static void testRemove() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.addRoot(5);
        tree.add(tree.root(), 4);
        tree.add(tree.root(), 3);
        tree.remove(tree.root());
        assertEquals("RedBlackTreeTest.testRemove", "(5(3))", tree.toString());
    }

    private static void testAdd() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.addRoot(5);
        tree.add(tree.root(), 4);
        tree.add(tree.root(), 3);
        assertEquals("RedBlackTreeTest.testAdd", "(4(3)(5))", tree.toString());
    }
}
