package com.A.training.B.sinitsynv.lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.A.training.B.sinitsynv.lesson05.CollectionUtils.*;
import static com.A.training.B.util.Assert.assertEquals;

public class CollectionUtilsTest {
    public static void main(String[] args) {
        testFilter();
        testTransformList();
        testTransformThroughElements();
        testForAllDo();
        testUnmodifiableCollection();
    }

    private static List<Employee> initEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Petr", 25000));
        employees.add(new Employee("Katya", 20000));
        employees.add(new Employee("Sergey", 30000));
        return employees;
    }

    private static void testUnmodifiableCollection() {
        List<Employee> employees = initEmployeeList();
        UnmodifiableCollection<Employee> collection = unmodifiableCollection(employees);
        try {
            collection.remove(1);
        } catch (Exception e) {
            assertEquals("CollectionUtilsTest.testUnmodifiableCollection", "UnsupportedOperationException",
                e.getClass().getSimpleName());
        }
    }

    private static void testForAllDo() {
        List<Employee> employees = initEmployeeList();
        CollectionLogic<Employee> collectionLogic = new CollectionLogic<Employee>() {
            @Override
            public Employee doLogic(Employee employee) {
                employee.setSalary(employee.getSalary() * 2);
                return employee;
            }
        };
        List<String> list = Arrays.asList("Petr 50000", "Katya 40000", "Sergey 60000");
        assertEquals("CollectionUtilsTest.testForAllDo", list.toString(),
            forAllDo(employees, collectionLogic).toString());
    }

    private static void testTransformThroughElements() {
        List<Employee> employees = initEmployeeList();
        CollectionTransformElement<Employee, String> collectionTransformList =
            new CollectionTransformElement<Employee, String>() {
                @Override
                public String change(Employee employee) {
                    return employee.getName();
                }
            };
        List<String> names = Arrays.asList("Petr", "Katya", "Sergey");
        assertEquals("CollectionUtilsTest.testTransformThroughElements", names,
            transform(employees, collectionTransformList));
    }

    private static void testTransformList() {
        List<Employee> employees = initEmployeeList();
        CollectionTransformList<Employee, String> collectionTransformList =
            new CollectionTransformList<Employee, String>() {
                @Override
                public List<String> change(List<Employee> l) {
                    List<String> temp = (List<String>) (Object) l;
                    return temp;
                }
            };
        List<String> names = new ArrayList<>();
        for (Employee e : employees) {
            names.add(e.toString());
        }
        assertEquals("CollectionUtilsTest.testTransformList", names, transform(employees, collectionTransformList));
    }

    private static void testFilter() {
        List<Employee> employees = initEmployeeList();
        CollectionFilter collectionFilter = new CollectionFilter() {
            @Override
            public boolean check(Object o) {
                return ((Employee) o).getName().toLowerCase().contains("petr");
            }
        };
        List<Employee> list = filter(employees, collectionFilter);
        StringBuilder names = new StringBuilder();
        for (Employee e : list) {
            names.append(e.getName()).append(" ");
        }
        assertEquals("CollectionUtilsTest.testFilter", names.toString(), "Petr ");
    }

    static class Employee {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " " + salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
    }
}
