import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class BinaryTreeTest {

    static class Person implements Comparable<Person> {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String getName() {
            return name;
        }

        private int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Person o) { return name.compareTo(o.getName()); }
        //public int compareTo(Person o) { return o.getAge() - age; }


        Comparator<Person> byName = (n1, n2) -> {
            String Name1 = n1.getName();
            String Name2 = n2.getName();
            return Name2.compareTo(Name1);
        };

    }

    private List<String> stringList = new ArrayList<>();
    private List<Integer> intList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    private BinaryTree<String> stringBinaryTree = new BinaryTree<>();
    private BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
    private BinaryTree<Person> personBinaryTree = new BinaryTree<>();

    @BeforeEach
    void setUp() {

        String [] strings = {"apple","olives","lemon","papaya","orange","grape","banana"};
            for (String string : strings){
                stringBinaryTree.add(string);
            }
            stringList.addAll(Arrays.asList("apple","banana","grape","lemon","olives","orange","papaya"));

        int[] arr = { 32,11,65,20,7,19,87 };
            for (int anArr : arr) {
                integerBinaryTree.add(anArr);
            }
            intList.addAll(Arrays.asList(7,11,19,20,32,65,87));

        Person [] persons = {(new Person("Lucian",36)),new Person("Alexandru",30),
                            new Person("Dan",60),new Person("Cristina",32),
                            new Person("Robert",34),new Person("Dragos",18),
                            new Person("Bogdan",22)};
            for (Person person : persons){
                personBinaryTree.add(person);
            }
            personList.addAll(Arrays.asList(persons));
    }

    @AfterEach
    void tearDown() {
        stringList.clear();
        intList.clear();
        personList.clear();
    }

    @Test
    void add() {
        BinaryTree instance = new BinaryTree();
        List<String> stringOrderList = new ArrayList<>();
        List<String> stringExpected = stringList;
        List<String> stringActual = instance.traverseInOrder(stringBinaryTree.getRoot(),stringOrderList);
        Assertions.assertEquals(stringExpected,stringActual);
        System.out.println(stringActual);

        List<Integer> intOrderList = new ArrayList<>();
        List<Integer> intExpected = intList; //this line can be removed
        List<Integer> intActual = instance.traverseInOrder(integerBinaryTree.getRoot(),intOrderList);
        Assertions.assertEquals(intExpected,intActual);
        System.out.println(intActual);

        List<Person> personOrderList = new ArrayList<>();
        List<Person> personExpected = personList; //this line can be removed
        Collections.sort(personList);
        List<Person> personActual = instance.traverseInOrder(personBinaryTree.getRoot(),personOrderList);
        Assertions.assertEquals(personExpected,personActual);
        System.out.println(personActual);
    }
}