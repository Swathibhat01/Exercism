class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {
        char[] dataArray = data.toCharArray();
        char[] rotatedArray = new char[dataArray.length];

        for (int i = 0; i < dataArray.length; i++) {
            if (!Character.isLetter(dataArray[i])) {
                rotatedArray[i] = dataArray[i];
                continue;
            }

            int rotatedChar = dataArray[i] + shiftKey;
            if (Character.isUpperCase(dataArray[i]) && !Character.isUpperCase(rotatedChar)) {
                rotatedChar = rotatedChar - 26;
            }
            if (Character.isLowerCase(dataArray[i]) && !Character.isLowerCase(rotatedChar)) {
                rotatedChar = rotatedChar - 26;
            }

            rotatedArray[i] = (char) rotatedChar;
        }

        return String.valueOf(rotatedArray);
    }

}

