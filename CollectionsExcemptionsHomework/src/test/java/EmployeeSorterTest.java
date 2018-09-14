import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSorterTest {

    private List<Employee> employees = new ArrayList<>();

    @BeforeEach
    void setUp() {
        employees.add(new Employee("A", "Position1", 1, "yes"));
        employees.add(new Employee("B", "Position2", 2, "yes"));
        employees.add(new Employee("C", "Position3", 3, "no"));
        employees.add(new Employee("D", "Position2", 2, "no"));
        employees.add(new Employee("E", "Position3", 1, "yes"));
    }

    @AfterEach
    void tearDown() {
        employees.clear();
    }


    @Test
    void employeeSorter() {
        System.out.println("employeeSorterTest is executing");
        List<Employee> sortedList = Arrays.asList(employees.get(2), employees.get(1), employees.get(3), employees.get(0), employees.get(4));
        EmployeeSorter instance = new EmployeeSorter();
        instance.employeeSorter(employees);
        assertEquals(employees, sortedList);
    }

 @Test
    void employeeList() {
      System.out.println("employeeListTest is executing");
      Map<String, List<Employee>> employeesByPosition = employees.stream().collect(Collectors.groupingBy(Employee::getPosition));
      TreeMap<String,List<Employee>> treeMap = new TreeMap<>(employeesByPosition);
      EmployeeSorter instance = new EmployeeSorter();
      TreeMap result = new TreeMap<>(instance.employeeList(employees));
      assertEquals(treeMap, result);
  }
}