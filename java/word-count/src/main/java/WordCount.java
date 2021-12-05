import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class WordCount {

    public HashMap<String, Integer> phrase(String word) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] splitWord = word.split("[\\s,]+");
        List<String> listOfWords = removeUnnecessaryCharacters(splitWord);
        List<String> finalListOfWords = removeApostropheSurroundingWords(listOfWords);
        finalListOfWords.forEach(
            w -> wordCount.put(w, wordCount.getOrDefault(w, 0) + 1));
        return wordCount;
    }

    private List<String> removeApostropheSurroundingWords(List<String> listOfWords) {
        return listOfWords.stream()
            .map(w -> {
                String finalWord = w;
                if (finalWord.startsWith("'")) {
                    finalWord = finalWord.substring(1);
                }
                if (finalWord.endsWith("'")) {
                    return finalWord.substring(0, finalWord.length() - 1);
                }
                return finalWord;
            }).collect(Collectors.toList());

    }

    private List<String> removeUnnecessaryCharacters(String[] splitWord) {
        return Arrays.stream(splitWord)
            .map(s -> s.replaceAll("[^\\w']", ""))
            .map(String::toLowerCase)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList());
    }

}