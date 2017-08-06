package com.A.training.B.sinitsynv.lesson08;

import com.A.training.B.sinitsynv.lesson07.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        testRemove();
        testAdd();
        testAddLeft();
        testAddRight();
        testTreeSearch();
        testToString();
        testCompare();
    }

    private static void testCompare() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        assertEquals("BinarySearchTreeTest.testCompareTest1", true, tree.compare(3, 1) > 0);
        assertEquals("BinarySearchTreeTest.testCompareTest2", false, tree.compare(1, 3) > 0);
    }

    private static void testToString() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addRoot(10);
        tree.add(tree.root(), 5);
        tree.add(tree.root(), 13);
        tree.add(tree.root(), 3);
        tree.add(tree.root(), 7);
        tree.add(tree.root(), 11);
        tree.add(tree.root(), 15);
        assertEquals("BinarySearchTreeTest.testToString", "(10(5(3)(7))(13(11)(15)))", tree.toString());
    }

    private static void testTreeSearch() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addRoot(10);
        tree.add(tree.root(), 5);
        tree.add(tree.root(), 3);
        assertEquals("BinarySearchTreeTest.testTreeSearch", 3, tree.treeSearch(tree.root(), 3).getElement());
    }

    private static void testRemove() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Node<Integer> root = tree.addRoot(5);
        tree.add(tree.root(), 3);
        tree.add(tree.root(), 2);
        tree.add(tree.root(), 4);
        tree.add(tree.root(), 7);
        tree.add(tree.root(), 6);
        tree.add(tree.root(), 8);
        tree.remove(tree.treeSearch(root, 6));
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(5, 3, 7, 2, 4, 8);
        for (Node<Integer> node : tree.breadthFirst()) {
            actualList.add(node.getElement());
        }
        assertEquals("LinkedBinaryTreeTest.testRemove", expectedList, actualList);
    }

    private static void testAdd() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addRoot(5);
        tree.add(tree.root(), 3);
        tree.add(tree.root(), 2);
        tree.add(tree.root(), 4);
        tree.add(tree.root(), 7);
        tree.add(tree.root(), 6);
        tree.add(tree.root(), 8);
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(5, 3, 7, 2, 4, 6, 8);
        for (Node<Integer> node : tree.breadthFirst()) {
            actualList.add(node.getElement());
        }
        assertEquals("LinkedBinaryTreeTest.testAdd", expectedList, actualList);
    }

    private static void testAddRight() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Node<Integer> node = tree.addRoot(5);
        tree.addRight(node, 6);
        assertEquals("BinarySearchTreeTest.testAddRight", 6, tree.right(node).getElement());
    }

    private static void testAddLeft() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Node<Integer> node = tree.addRoot(5);
        tree.addLeft(node, 4);
        assertEquals("BinarySearchTreeTest.testAddLeft", 4, tree.left(node).getElement());
    }
}
