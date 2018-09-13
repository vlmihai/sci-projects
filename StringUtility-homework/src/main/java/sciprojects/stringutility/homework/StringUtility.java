package sciprojects.stringutility.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringUtility {

    /**
     * Method that removes all whitespaces(space,tab,new-line) from a String
     */

    String sentanceRemove (Sentances sentance){
        String sentance1 = sentance.getSentance().replaceAll("\\s", "");
        System.out.println("Arranged sentance: " + sentance1);
        return sentance1;
    }

    /**
     * Method that replaces al numbers that are present as words, for numbers between 0 and 9.
     * This applies only where words are not part of a larger word.
     * The method works with both Upper and Lower Case letters.
     */

    String sentanceReplace (Sentances sentance) {
        String sentance1 = sentance.getSentance().replaceAll("\\s(?i)one", " 1").
                replaceAll("\\s(?i)two", " 2").replaceAll("\\s(?i)three", " 3").
                replaceAll("\\s(?i)four", " 4").replaceAll("\\s(?i)five", "5").
                replaceAll("\\s(?i)six", " 6").replaceAll("\\s(?i)seven", " 7").
                replaceAll("\\s(?i)eight", " 8").replaceAll("\\s(?i)nine", " 9");
        System.out.println("\nArranged sentance: " + sentance1);
        return sentance1;
    }
}

