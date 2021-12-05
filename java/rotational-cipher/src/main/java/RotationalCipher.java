class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {
        return data.chars()
            .mapToObj(c -> rotateChar((char) c))
            .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append).toString();
    }

    private Character rotateChar(char characterToRotate) {
        if(!Character.isLetter(characterToRotate)){
            return characterToRotate;
        }
        int rotatedChar = characterToRotate + shiftKey;
        if (Character.isUpperCase(characterToRotate) && !Character.isUpperCase(rotatedChar)) {
            rotatedChar = rotatedChar - 26;
        }
        if (Character.isLowerCase(characterToRotate) && !Character.isLowerCase(rotatedChar)) {
            rotatedChar = rotatedChar - 26;
        }
        return (char) rotatedChar;
    }
}

