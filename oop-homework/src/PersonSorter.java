import java.util.List;

public class PersonSorter {
    public static void bubbleSort(List<Person> personList) {
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < personList.size() - 1; i++) {
                Person forSwapPerson = personList.get(i);
                if (personList.get(i).getAge() > personList.get(i + 1).getAge()) {
                    personList.set(i, personList.get(i + 1));
                    personList.set(i + 1, forSwapPerson);
                    flag = true;
                }
            }
        }
    }
}
