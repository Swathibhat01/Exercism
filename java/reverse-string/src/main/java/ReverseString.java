class ReverseString {

    String reverse(String inputString) {
        if(inputString.isEmpty()){
            return inputString;
        }
        char[] arrayOfResultingString = new char[inputString.length()];
        for(int i =inputString.length()-1 ,j=0;i>=0;i--,j++){
            arrayOfResultingString[j]= inputString.charAt(i);
        }
        return String.valueOf(arrayOfResultingString);
    }
}
