import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Class which sorts Employees based on seniority and last name.
 * Prints to console employees without parking space.
 * Class that creates lists based on position within the company.
 */

class EmployeeSorter {

    void employeeSorter (List<Employee> sortedList) {
        sortedList.sort(Employee.seniorityComparator.thenComparing(Employee::getName));
        for (Employee employee : sortedList) {
            if(employee.hasParkingspace().equals("no")) {
                System.out.println(employee);
            }
        }
    }

    // creates map based on position within the company
    Map<String, List<Employee>> employeeList (List<Employee> employeesByPosition) {
        Map<String,List<Employee>> map = employeesByPosition.stream().collect(Collectors.groupingBy(Employee::getPosition));
        TreeMap<String,List<Employee>> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);
        return map;
    }


}

