import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeReaderTest {

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
    void getEmployees() throws IOException {
        File f = new File("Test.csv");
        FileReader fr = new FileReader(f);
        System.out.println("Test is executing");
        EmployeeReader instance = new EmployeeReader(fr);
        List<Employee> result = instance.getEmployees();
        assertNotNull(employees);
        assertEquals(employees,result);
    }
}