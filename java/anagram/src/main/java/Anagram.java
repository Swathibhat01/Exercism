import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Anagram {

    private String word;
    Anagram(String word) {
        this.word = word;
    }

    List<String> match(List<String> listOfStrings) {
        char[] wordCharArray = word.toLowerCase().toCharArray();
        Arrays.sort(wordCharArray);

        List<String> detectedAnagrams = new ArrayList<>();
        for (String string : listOfStrings) {
            if ((string.toLowerCase()).equals(word.toLowerCase())) {
                continue;
            }
            String lowerCaseString = string.toLowerCase();
            char[] chars = lowerCaseString.toCharArray();
            Arrays.sort(chars);
            if (String.valueOf(chars).equals(String.valueOf(wordCharArray))) {
                detectedAnagrams.add(string);
            }
        }
        return detectedAnagrams;
    }
}
