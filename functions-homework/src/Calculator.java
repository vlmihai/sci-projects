import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double x=0;
        double y=0;

        try {
            x = Integer.parseInt(JOptionPane.
                    showInputDialog("Please input x: "));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Value must be an integer!");
            }

        try {
            y = Integer.parseInt(JOptionPane.
                    showInputDialog("Please input y: "));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Value must be an integer!");
            }
        double add  = x + y;
        double substract = x - y;
        double multiply = x * y;
        double divide = x / y;


        JOptionPane.showMessageDialog(null, "The results of the operations are: " +
                "\n Adding: " + add +
                "\n Substracting: " + substract +
                "\n Multiplying: " + multiply +
                "\n Deviding: " + divide);

        keyboard.close();
    }
}
