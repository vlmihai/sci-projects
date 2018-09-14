import java.util.Comparator;
import java.util.Objects;

public class Employee {
    private String name;
    private String position;
    private double seniority;
    private String parkingspace;

    Employee(String name, String position, double seniority, String parkingspace) {
        this.name = name;
        this.position = position;
        this.seniority = seniority;
        this.parkingspace = parkingspace;
    }

    String getName() { return name; }

    String getPosition() { return position; }

    private double getSeniority() { return seniority; }

    String hasParkingspace() { return parkingspace; }

    /**
     * Comparator which sorts employees after seniority
     */

    static Comparator<Employee> seniorityComparator = (s1, s2) -> {
        Double Seniority1 = s1.getSeniority();
        Double Seniority2 = s2.getSeniority();
        //descending order
        return Seniority2.compareTo(Seniority1);
    };

    /**
     * Comparator which sorts employees after name
     */

    static Comparator<Employee> nameComparator = (s1, s2) -> {
        String Name1 = s1.getName();
        String Name2 = s2.getName();
        //ascending order
        return Name1.compareTo(Name2);
    };

    static Comparator<Employee> positionComparator = (s1, s2) -> {
        String Position1 = s1.getPosition();
        String Position2 = s2.getPosition();
        //ascending order
        return Position1.compareTo(Position2);
    };


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", seniority=" + seniority +
                ", parkingspace=" + parkingspace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return seniority == employee.seniority &&
                parkingspace.equals(employee.parkingspace) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, seniority, parkingspace);
    }
}
