import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String finalString = stringToVerify.replaceAll("-", "");
        int length = finalString.length();
        if( length != 10 ){
            return false;
        }
        boolean lastCharIsNotX = Character.isLetter(finalString.charAt(length - 1))
            && finalString.charAt(length - 1) != 'X';
        if ( lastCharIsNotX) {
            return false;
        }
        int isbnTotal = IntStream.range(0, 9)
            .map(i -> (Character.getNumericValue(finalString.charAt(i)) * (10 - i)))
            .sum();
        isbnTotal = (finalString.charAt(9) == 'X') ? isbnTotal + 10
            : isbnTotal + Character.getNumericValue(finalString.charAt(9));
        return isbnTotal % 11 == 0;
    }
}
