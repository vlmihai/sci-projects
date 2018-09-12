import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * Imports Employees.csv file
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File f = new File("Employees.csv");
        if (!f.exists()) {
            System.out.println("File " + f.getName() + " does not exist.");
        }
    /**
     * Sorts Employee list based on seniority and name.
     * Prints to console employees without parking space.
     */

        FileReader fr = new FileReader(f);
        List<Employee> employees = new EmployeeReader(fr).getEmployees();
        employees.sort(Employee.seniorityComparator.thenComparing(Employee::getName));
        for (Employee employee : employees) {
            if(employee.hasParkingspace().equals("no")) {
                System.out.println(employee);
            }
        }

        /**
         * Creates individual lists based on position.
         */

        List<Employee> businessdevelopment = employees.stream()
                .filter(employee -> employee.getPosition().equals("Business Development"))
                .collect(Collectors.toList());
                System.out.println("\nBusiness Development: " + businessdevelopment);

        List<Employee> businessassociate = employees.stream()
                .filter(employee -> employee.getPosition().equals("Business Associate"))
                .collect(Collectors.toList());
                System.out.println("\nBusiness Associate: " + businessassociate);
    }

}
