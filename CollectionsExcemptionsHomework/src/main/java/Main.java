import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

        FileReader fr = new FileReader(f);
        EmployeeSorter employeeSorter = new EmployeeSorter();
        List<Employee> employees = new EmployeeReader(fr).getEmployees();
        employeeSorter.employeeSorter(employees);
        employeeSorter.employeeList(employees);

    }
}
