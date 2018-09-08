package sciprojects.stringutility.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StringUtilityTest {

    @Test
    void sentanceRemove() {
        System.out.println("Sentence remove test is executing");
        StringUtility instance = new StringUtility();
        Sentances sentance = new Sentances("I_s t ar t e d_J A V A_train ing");
        String expResult = "I_started_JAVA_training";
        String result = instance.sentanceRemove(sentance);
        assertNotNull(sentance);
        assertEquals(expResult, result);
    }

    @Test
    void sentanceReplace() {
        System.out.println("Sentence replace test is executing");
        StringUtility instance = new StringUtility();
        Sentances sentance = new Sentances("I just ate two excellent sandwiches");
        String expResult = "I just ate 2 excellent sandwiches";
        String result = instance.sentanceReplace(sentance);
        assertEquals(expResult,result);
    }
}