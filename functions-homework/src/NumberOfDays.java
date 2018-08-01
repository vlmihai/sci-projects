import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Scanner;

public class NumberOfDays {
    private static int calMonth;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int year = 0;
        int month = 0;

        try {
            year = Integer.parseInt(JOptionPane.
                    showInputDialog("Please input year: "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Value must be an integer!");
        }
        try {
            month = Integer.parseInt(JOptionPane.
                    showInputDialog("Please input month (number from 1 to 12): "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Value must be an integer!");
        }

        int days = 0;
        switch (month) {
            case 1:
                calMonth = Calendar.JANUARY;
                days = 31;
                break;
            case 2:
                calMonth = Calendar.FEBRUARY;
                if ((year % 4 == 0) && year % 100 != 0) {
                    days = 29;
                } else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 3:
                calMonth = Calendar.MARCH;
                days = 31;
                break;
            case 4:
                calMonth = Calendar.APRIL;
                days = 30;
                break;
            case 5:
                calMonth = Calendar.MAY;
                days = 31;
                break;
            case 6:
                calMonth = Calendar.JUNE;
                days = 30;
                break;
            case 7:
                calMonth = Calendar.JULY;
                days = 31;
                break;
            case 8:
                calMonth = Calendar.AUGUST;
                days = 31;
                break;
            case 9:
                calMonth = Calendar.SEPTEMBER;
                days = 30;
                break;
            case 10:
                calMonth = Calendar.OCTOBER;
                days = 31;
                break;
            case 11:
                calMonth = Calendar.NOVEMBER;
                days = 30;
                break;
            case 12:
                calMonth = Calendar.DECEMBER;
                days = 31;
                break;
        }
                JOptionPane.showMessageDialog(null, "There are " + days + " days in month " + month +
                        " of year " + year);

                keyboard.close();
    }
}
