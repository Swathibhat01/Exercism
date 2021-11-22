import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class IsogramChecker {

    boolean isIsogram(String phrase) {
        Set<Character> setOfUniqueCharInPhrase = new HashSet<>();
        return phrase.replaceAll("[\\s-]+","").chars()
            .mapToObj(c->(char)c)
            .map(Character::toLowerCase)
            .allMatch(setOfUniqueCharInPhrase::add);

//        String phraseWithoutHyphensAndSpace =phrase.replaceAll("[\\s-]+" ,"");
//        return isIsogramHelperWithoutExtraSpace(phraseWithoutHyphensAndSpace.toLowerCase());
}

    private boolean isIsogramHelperWithSets(String phrase) {
        int lengthOfPhrase = phrase.length();
        Set setOfUniqueCharInPhrase = new HashSet();
        for(int i = 0 ; i<phrase.length();i++){
            boolean add = setOfUniqueCharInPhrase.add(phrase.charAt(i));
            if(!add){
                return false;
            }
        }
        return true;
    }

    private boolean isIsogramHelperWithArray(String phrase){
        int[] arrayOfAlphabetScore = new int[26];
        for(int i =0 ; i<phrase.length();i++){
         if(arrayOfAlphabetScore[phrase.charAt(i)-'a'] == 0) {
             arrayOfAlphabetScore[phrase.charAt(i) - 'a']++ ;

         }
         else
             return false;
             }
        return true;
        }

    private boolean isIsogramHelperWithoutExtraSpace(String phrase){
     char[] charArrayOfPhrase = phrase.toCharArray();
        Arrays.sort(charArrayOfPhrase);
        for(int i = 0 ; i < charArrayOfPhrase.length-1;i++){
            if (charArrayOfPhrase[i]==charArrayOfPhrase[i+1]){
                return false;
            }
        }
        return true;

    }



    }




