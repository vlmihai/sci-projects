import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

class EmployeeReader {

    /**
     * Creates an EmployeeReader method which reads the information from a csv file.
     * The method reads line by line and and creates new employees for each line.
     */

    private Reader reader;

    EmployeeReader(Reader reader) { this.reader = reader; }

    List<Employee> getEmployees() throws IOException {
        BufferedReader br = new BufferedReader(reader);
        List<Employee> employees = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            employees.add(parsePlayer(line));
            line = br.readLine();
        }
        System.out.println(employees);
        return employees;
    }

    /**
     * This method gets employees and based on a separator splits the information in:
     * name, position, seniority and parking space.
     */

    private Employee parsePlayer(String line) {
        String[] tokens = line.split(",");
        return new Employee (tokens[0], tokens[1], Double.parseDouble(tokens[2]),tokens[3]);
    }
}
