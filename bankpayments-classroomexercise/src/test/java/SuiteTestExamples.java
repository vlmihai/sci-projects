import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuiteTestExamples {

    @Test
    public void testPrintMessage() {
        int num = 5;
        System.out.println("Executing suite test 1");

        //verify expected, actual
        assertEquals (10, num);
    }

    @Test
    public void testPrintMessage2(){
        String hello = "Hello World";
        System.out.println("suite test2 is executing");
        Assert.assertNotNull(hello);

    }
}
