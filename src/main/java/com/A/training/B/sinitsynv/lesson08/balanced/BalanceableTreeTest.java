package com.A.training.B.sinitsynv.lesson08.balanced;

import static com.A.training.B.util.Assert.assertEquals;

public class BalanceableTreeTest {
    public static void main(String[] args) {
        testReduceSubtreeHeight();
    }

    private static void testReduceSubtreeHeight() {
        BalanceableTree<Integer> firstTree = new BalanceableTree<>();
        firstTree.addRoot(5);
        firstTree.add(firstTree.root(), 4);
        firstTree.add(firstTree.root(), 3);
        firstTree.reduceSubtreeHeight(firstTree.treeSearch(firstTree.root(), 3));
        assertEquals("BalanceableTreeTest.testReduceSubtreeHeightTest1", "(4(3)(5))", firstTree.toString());
        BalanceableTree<Integer> secondTree = new BalanceableTree<>();
        secondTree.addRoot(5);
        secondTree.add(secondTree.root(), 7);
        secondTree.add(secondTree.root(), 8);
        secondTree.reduceSubtreeHeight(secondTree.treeSearch(secondTree.root(), 8));
        assertEquals("BalanceableTreeTest.testReduceSubtreeHeightTest2", "(7(5)(8))", secondTree.toString());
        BalanceableTree<Integer> thirdTree = new BalanceableTree<>();
        thirdTree.addRoot(5);
        thirdTree.add(thirdTree.root(), 3);
        thirdTree.add(thirdTree.root(), 4);
        thirdTree.reduceSubtreeHeight(thirdTree.treeSearch(thirdTree.root(), 4));
        assertEquals("BalanceableTreeTest.testReduceSubtreeHeightTest3", "(4(3)(5))", thirdTree.toString());
        BalanceableTree<Integer> fourthTree = new BalanceableTree<>();
        fourthTree.addRoot(5);
        fourthTree.add(fourthTree.root(), 7);
        fourthTree.add(fourthTree.root(), 6);
        fourthTree.reduceSubtreeHeight(fourthTree.treeSearch(fourthTree.root(), 6));
        assertEquals("BalanceableTreeTest.testReduceSubtreeHeightTest4", "(6(5)(7))", fourthTree.toString());
    }
}
