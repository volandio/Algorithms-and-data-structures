package com.A.training.B.sinitsynv.lesson10;

import java.util.*;

import static com.A.training.B.util.Assert.assertEquals;

public class CollectionsTest {
    public static void main(String[] args) {
        testAddAll();
        testAsLifoQueue();
        testBinarySearch();
        testCheckedCollection();
        testCopy();
        testDisjoint();
        testEmptyEnumeration();
        testEnumeration();
        testFill();
        testFrequency();
        testIndexOfSublist();
        testLastIndexOfSublist();
        testList();
        testMax();
        testMin();
        testNCopies();
        testNewSetFromMap();
        testReplaceAll();
        testReverse();
        testReverseOrder();
        testRotate();
        testShuffle();
        testSingleton();
        testSort();
        testSwap();
        testUnmodifiableCollection();
    }

    private static void testReverseOrder() {
        List<Integer> list = Arrays.asList(5, 1, 3);
        Collections.sort(list, Collections.reverseOrder());
        assertEquals("CollectionsTest.testReverseOrder", "[5, 3, 1]", list.toString());
    }

    private static void testUnmodifiableCollection() {
        Collection<Integer> firstCollection = new ArrayList<>();
        Collection<Integer> secondCollection = Collections.unmodifiableCollection(firstCollection);
        try {
            secondCollection.add(5);
        } catch (UnsupportedOperationException e) {
            assertEquals("CollectionUtilsTest.testUnmodifiableCollection", "UnsupportedOperationException",
                e.getClass().getSimpleName());
        }
    }


    private static void testSwap() {
        List<Integer> list = Arrays.asList(5, 1, 3);
        Collections.swap(list, 1, 2);
        assertEquals("CollectionsTest.testSwap", "[5, 3, 1]", list.toString());
    }

    private static void testSort() {
        List<Integer> list = Arrays.asList(5, 1, 3);
        Collections.sort(list);
        assertEquals("CollectionsTest.testSort", "[1, 3, 5]", list.toString());
    }

    private static void testSingleton() {
        Set<Integer> set = Collections.singleton(5);
        assertEquals("CollectionsTest.testSingleton", "[5]", set.toString());
    }

    private static void testShuffle() {
        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = new ArrayList<>(firstList);
        Collections.shuffle(firstList);
        assertEquals("CollectionsTest.testShuffle", false, firstList.equals(secondList));
    }

    private static void testRotate() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.rotate(list, 1);
        assertEquals("CollectionsTest.testRotate", "[3, 1, 2]", list.toString());
    }

    private static void testReverse() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.reverse(list);
        assertEquals("CollectionsTest.testReverse", "[3, 2, 1]", list.toString());
    }

    private static void testReplaceAll() {
        List<Integer> list = Arrays.asList(1, 2, 3, 1);
        Collections.replaceAll(list, 1, 5);
        assertEquals("CollectionsTest.testReplaceAll", "[5, 2, 3, 5]", list.toString());
    }

    private static void testNewSetFromMap() {
        Map<Integer, Boolean> map = new LinkedHashMap<Integer, Boolean>();
        Set<Integer> set = Collections.newSetFromMap(map);
        map.put(1, true);
        assertEquals("CollectionsTest.testNewSetFromMap", "[1]", set.toString());
    }

    private static void testNCopies() {
        List<Integer> list = Collections.nCopies(5, 1);
        assertEquals("CollectionsTest.testNCopies", "[1, 1, 1, 1, 1]", list.toString());
    }

    private static void testMin() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertEquals("CollectionsTest.testMin", 1, Collections.min(list));
    }

    private static void testMax() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertEquals("CollectionsTest.testMax", 4, Collections.max(list));
    }

    private static void testList() {
        Enumeration<Integer> enumeration = Collections.enumeration(new ArrayList<>(Arrays.asList(5)));
        List<Integer> list = Collections.list(enumeration);
        assertEquals("CollectionsTest.testList", 5, list.get(0));
    }

    private static void testLastIndexOfSublist() {
        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4);
        List<Integer> secondList = Arrays.asList(2, 3, 4);
        assertEquals("CollectionsTest.testLastIndexOfSublist", 5,
            Collections.lastIndexOfSubList(firstList, secondList));
    }

    private static void testIndexOfSublist() {
        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(2, 3, 4);
        assertEquals("CollectionsTest.testIndexOfSublist", 1, Collections.indexOfSubList(firstList, secondList));
    }

    private static void testFrequency() {
        List<Integer> list = Arrays.asList(1, 1, 1);
        assertEquals("CollectionsTest.testFrequency", 3, Collections.frequency(list, 1));
    }

    private static void testFill() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Collections.fill(list, 2);
        assertEquals("CollectionsTest.testFill", 2, list.get(0));
    }

    private static void testEnumeration() {
        List<Integer> firstMyList = new ArrayList<>();
        firstMyList.add(1);
        Enumeration<Integer> enumeration = Collections.enumeration(firstMyList);
        enumeration.hasMoreElements();
        assertEquals("CollectionsTest.testEnumeration", 1, enumeration.nextElement());
    }

    private static void testEmptyEnumeration() {
        Enumeration enumeration = Collections.emptyEnumeration();
        assertEquals("CollectionsTest.testEmptyEnumeration", false, enumeration.hasMoreElements());
    }

    private static void testDisjoint() {
        List<Integer> firstMyList = new ArrayList<>();
        firstMyList.add(1);
        List<Integer> secondMyList = new ArrayList<>();
        secondMyList.add(2);
        assertEquals("CollectionsTest.testDisjointTest1", true, Collections.disjoint(firstMyList, secondMyList));
        secondMyList.add(1);
        assertEquals("CollectionsTest.testDisjointTest2", false, Collections.disjoint(firstMyList, secondMyList));
    }

    private static void testCopy() {
        List<Integer> firstMyList = new ArrayList<>();
        firstMyList.add(1);
        List<Integer> secondMyList = new ArrayList<>();
        secondMyList.add(2);
        Collections.copy(secondMyList, firstMyList);
        assertEquals("CollectionsTest.testCopy", secondMyList, firstMyList);
    }

    private static void testCheckedCollection() {
        List myList = new ArrayList();
        myList.add("one");
        Collection chkList = Collections.checkedCollection(myList, String.class);
        try {
            chkList.add(10);
        } catch (ClassCastException e) {
            assertEquals("CollectionUtilsTest.testCheckedCollection", "ClassCastException",
                e.getClass().getSimpleName());
        }
    }

    private static void testBinarySearch() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals("CollectionsTest.testBinarySearchQueueTest", 2, Collections.binarySearch(list, 3));
    }

    private static void testAsLifoQueue() {
        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Queue<Integer> deque = Collections.asLifoQueue(queue);
        assertEquals("CollectionsTest.testAsLifoQueue", 1, deque.peek());
    }

    private static void testAddAll() {
        Collection<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals("CollectionsTest.testAddAll", true, Collections.addAll(list, 4));
    }
}
