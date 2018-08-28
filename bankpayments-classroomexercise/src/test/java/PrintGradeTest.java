import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintGradeTest {
    private PrintGrade printGrade;

    @Before
    public void setUp() {
        printGrade = new PrintGrade();
    }

    @Test
    public void print_B_whenInputisNegativeValue() {
        //given
        int grade = -91;
        String result = " ";
        //on
        result = printGrade.print(93);
        //then
        assertEquals("B", result);
    }
}