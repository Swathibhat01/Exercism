import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class WordCount {

    public HashMap<String, Integer> phrase(String word) {

        HashMap<String,Integer> wordCount = new HashMap<>();

        String[] splitWord = word.split("[\\s,]+");
        List<String> listOfWords = removeUnnecessaryCharacters(splitWord);

        List<String> finalListOfWords = removeApostropheSorroundingWords(listOfWords);


         wordCount.put(finalListOfWords.get(0),0);
         finalListOfWords.forEach(s ->
         {
             if(wordCount.containsKey(s)){
                 wordCount.put(s,wordCount.get(s)+1);
             }
             else
             {
                 wordCount.put(s,1);
             }
         });
        return wordCount;
    }

    private List<String> removeApostropheSorroundingWords(List<String> listOfWords) {
        for(int j =0 ; j<listOfWords.size();j++){
            if (listOfWords.get(j).charAt(0)=='\''){
                String replaceApostrophe = listOfWords.get(j)
                    .replace(String.valueOf(listOfWords.get(j).charAt(0)), "");
            listOfWords.set(j,replaceApostrophe);
            }

            if (listOfWords.get(j).charAt(listOfWords.get(j).length()-1)=='\''){
                String replaceApostrophe = listOfWords.get(j)
                    .replace(String.valueOf(listOfWords.get(j).charAt(listOfWords.get(j).length()-1)), "");
                listOfWords.set(j,replaceApostrophe);
            }
        }
        return listOfWords;
    }

    private List<String> removeUnnecessaryCharacters(String[] splitWord) {
        return Arrays.stream(splitWord)
                .map(s -> s.replaceAll("[^\\w']", ""))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

}