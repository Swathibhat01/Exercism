import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String phraseWithoutHyphensAndSpace = phrase.replaceAll("[\\s-]+", "");
        System.out.println(phraseWithoutHyphensAndSpace);
        return isIsogramHelperWithSets(phraseWithoutHyphensAndSpace);
    }

    private boolean isIsogramHelperWithSets(String phrase) {
        Set setOfUniqueCharInPhrase = new HashSet();
        for (int i = 0; i < phrase.length(); i++) {
            boolean add = setOfUniqueCharInPhrase.add(phrase.toUpperCase().charAt(i));
            if (!add) {
                return false;
            }
        }
        return true;
    }


}
