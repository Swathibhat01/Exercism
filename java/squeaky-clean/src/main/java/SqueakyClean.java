class SqueakyClean {

    static String clean(String identifier) {
        StringBuilder identifierInStringBuilder = new StringBuilder();
        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (c == ' ') {
                identifierInStringBuilder.append("_");
            }
            if (Character.isISOControl(c)) {
                identifierInStringBuilder.append("CTRL");
            }
            if (Character.isLetter(c) && (c < 945 || c > 969)) {
                identifierInStringBuilder.append(c);
            }
            if (c == '-' && (i + 1) < identifier.length()) {
                identifierInStringBuilder.append(Character.toUpperCase(identifier.charAt(++i)));
            }
        }
        return identifierInStringBuilder.toString();
    }
}

