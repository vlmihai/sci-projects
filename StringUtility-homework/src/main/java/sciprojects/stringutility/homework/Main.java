package sciprojects.stringutility.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Sentances> sentanceList = new ArrayList<>();
        sentanceList.add(new Sentances("I_s t ar t e d_J A V A_train ing"));
        sentanceList.add(new Sentances("I have four apples"));
        sentanceList.add(new Sentances("I want twenty-nine dollars"));
        sentanceList.add(new Sentances("I want twenty nine dollars"));
        sentanceList.add(new Sentances("Five six SEVEN eiGHt!!"));
        sentanceList.add(new Sentances("Yesterday I bought FIVE pencils"));

        StringUtility stringUtility = new StringUtility();
        stringUtility.sentanceRemove(sentanceList.get(0));
        stringUtility.sentanceReplace(sentanceList.get(1));
    }
}
