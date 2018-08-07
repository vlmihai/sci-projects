import java.util.*;

public class Main {
    public static void main(String arg[]) {
        List<Person> unsortedList = new ArrayList<>();
        unsortedList.add(new Person("Robert", "Anderson", 37));
        unsortedList.add(new Person("Robert", "Stalling", 22));
        unsortedList.add(new Person("Andrew", "Anderson", 19));
        unsortedList.add(new Person("Harish", "Samtani", 45));

        for(Person employee : unsortedList){
            System.out.println("firstname:"+ employee.getFirstname() + " lastname:" + employee.getLastname()+ " age:" + employee.getAge());
        }

        System.out.println("\nSorting starts now \n");

        PersonSorter sortedList = new PersonSorter();

        sortedList.bubbleSort(unsortedList);

        for(Person employee : unsortedList){
            System.out.println("firstname:"+ employee.getFirstname() + " lastname:" + employee.getLastname()+ " age:" + employee.getAge());
        }

    }
}