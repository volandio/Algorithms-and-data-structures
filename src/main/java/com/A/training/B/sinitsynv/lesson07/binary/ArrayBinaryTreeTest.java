package com.A.training.B.sinitsynv.lesson07.binary;

import com.A.training.B.sinitsynv.lesson07.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.A.training.B.util.Assert.assertEquals;

public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        testAddRoot();
        testAdd();
        testAddLeft();
        testAddRight();
        testSet();
        testRemove();
        testLeft();
        testRight();
        testParent();
        testSize();
        testIsEmpty();
        testPreOrder();
        testInOrder();
        testPostOrder();
        testBreadthFirst();
        testSibling();
        testChildren();
        testChildrenNumber();
        testIterator();
    }

    private static ArrayBinaryTree<Integer> getTreeOfNumbers() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(1);
        tree.addLeft(tree.root(), 2);
        tree.addRight(tree.root(), 3);
        tree.addLeft(tree.left(tree.root()), 4);
        tree.addRight(tree.left(tree.root()), 5);
        tree.addLeft(tree.right(tree.root()), 6);
        tree.addRight(tree.right(tree.root()), 7);
        return tree;
    }

    private static void testIterator() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> root = tree.addRoot(1);
        tree.addLeft(root, 2);
        tree.addRight(root, 3);
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(2, 1, 3);
        for (Iterator<Integer> it = tree.iterator(); it.hasNext(); ) {
            actualList.add(it.next());
        }
        assertEquals("ArrayBinaryTreeTest.testIterator", expectedList, actualList);
    }

    private static void testChildrenNumber() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(1);
        tree.addLeft(tree.root(), 2);
        tree.addRight(tree.root(), 3);
        assertEquals("ArrayBinaryTreeTest.testChildrenNumber", 2, tree.childrenNumber(tree.root()));
    }

    private static void testChildren() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(1);
        tree.addLeft(node, 2);
        tree.addRight(node, 3);
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(2, 3);
        for (Node<Integer> a : tree.children(node)) {
            actualList.add(a.getElement());
        }
        assertEquals("ArrayBinaryTreeTest.testChildren", expectedList, actualList);
    }

    private static void testSibling() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(1);
        tree.addLeft(tree.root(), 2);
        tree.addRight(tree.root(), 3);
        assertEquals("ArrayBinaryTreeTest.testSibling", 3, tree.sibling(tree.left(tree.root())).getElement());
    }

    private static void testBreadthFirst() {
        ArrayBinaryTree<Integer> tree = getTreeOfNumbers();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Node<Integer> node : tree.breadthFirst()) {
            actualList.add(node.getElement());
        }
        assertEquals("ArrayBinaryTreeTest.testBreadthFirst", expectedList, actualList);
    }

    private static void testPostOrder() {
        ArrayBinaryTree<Integer> tree = getTreeOfNumbers();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
        for (Node<Integer> node : tree.postOrder()) {
            actualList.add(node.getElement());
        }
        assertEquals("ArrayBinaryTreeTest.testPostOrder", expectedList, actualList);
    }

    private static void testInOrder() {
        ArrayBinaryTree<Integer> tree = getTreeOfNumbers();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        for (Node<Integer> node : tree.inOrder()) {
            actualList.add(node.getElement());
        }
        assertEquals("ArrayBinaryTreeTest.testInOrder", expectedList, actualList);
    }

    private static void testPreOrder() {
        ArrayBinaryTree<Integer> tree = getTreeOfNumbers();
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        for (Node<Integer> node : tree.preOrder()) {
            actualList.add(node.getElement());
        }
        assertEquals("ArrayBinaryTreeTest.testPreOrder", expectedList, actualList);
    }

    private static void testIsEmpty() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        assertEquals("ArrayBinaryTreeTest.testIsEmptyTest1", true, tree.isEmpty());
        tree.addRoot(5);
        assertEquals("ArrayBinaryTreeTest.testIsEmptyTest2", false, tree.isEmpty());
    }

    private static void testSize() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(5);
        tree.add(tree.root(), 6);
        tree.add(tree.root(), 7);
        assertEquals("ArrayBinaryTreeTest.testSize", 3, tree.size());
    }

    private static void testParent() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(5);
        Node<Integer> node = tree.add(tree.root(), 6);
        assertEquals("LinkedBinaryTreeTest.testParent", 5, tree.parent(node).getElement());
    }

    private static void testRight() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(5);
        tree.addRight(tree.root(), 6);
        assertEquals("ArrayBinaryTreeTest.testRight", 6, tree.right(tree.root()).getElement());
    }

    private static void testLeft() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(5);
        tree.addLeft(tree.root(), 6);
        assertEquals("ArrayBinaryTreeTest.testLeft", 6, tree.left(tree.root()).getElement());
    }

    private static void testRemove() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        tree.addRoot(5);
        Node<Integer> addedNode = tree.add(tree.root(), 6);
        assertEquals("ArrayBinaryTreeTest.testRemove", 6, tree.remove(addedNode));
    }

    private static void testSet() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(5);
        tree.set(node, 6);
        assertEquals("ArrayBinaryTreeTest.testSet", 6, node.getElement());
    }

    private static void testAddRight() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(5);
        tree.addRight(node, 6);
        assertEquals("ArrayBinaryTreeTest.testAddRight", 6, tree.right(node).getElement());
    }

    private static void testAddLeft() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(5);
        tree.addLeft(node, 6);
        assertEquals("ArrayBinaryTreeTest.testAddLeft", 6, tree.left(node).getElement());
    }

    private static void testAdd() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(5);
        assertEquals("ArrayBinaryTreeTestTreeTest.testAdd", 6, tree.add(node, 6).getElement());
    }

    private static void testAddRoot() {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();
        Node<Integer> node = tree.addRoot(5);
        assertEquals("ArrayBinaryTreeTest.testAddRoot", 5, node.getElement());
    }
}
