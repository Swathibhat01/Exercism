class ReverseString {

    String reverse(String inputString) {
        if (inputString.isEmpty()) {
            return inputString;
        }
        char[] chars = inputString.toCharArray();
        char temp ;
        int length = chars.length;
        for(int i =0 ; i<length/2;i++){
            temp =chars[i];
            chars[i]=chars[length-1-i];
            chars[length-1-i] = temp;
        }
        return String.valueOf(chars);


//        StringBuilder sb = new StringBuilder();
//        for (int i = inputString.length() - 1; i >= 0; i--) {
//            sb.append(inputString.charAt(i));
//        }
//        return String.valueOf(sb);

    }
}
