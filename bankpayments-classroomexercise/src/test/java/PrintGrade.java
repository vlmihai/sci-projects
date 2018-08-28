public class PrintGrade {
    public String print(int grade){
        if (grade > 90) {
            System.out.println("A");
            return "A";
        } else if (grade > 80) {
            System.out.println("B");
            return "B";
        } else if (grade > 70) {
            System.out.println("C");
            return "C";
        }

        return "You need to study more";
        }
    }
