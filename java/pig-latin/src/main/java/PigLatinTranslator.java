import java.util.StringJoiner;

public class PigLatinTranslator {

    String translate(String word) {
        String[] split = word.split("\\s");
        StringJoiner sj = new StringJoiner(" ");
        if (split.length > 1) {
            for (String s : split) {
                String s1 = translateHelper(s);
                sj.add(s1);
            }
            return String.valueOf(sj);
        } else {
            return translateHelper(word);
        }
    }

    private String translateHelper(String word) {
        StringBuilder sb = new StringBuilder();
        String vowels = "AEIOU";
        for (int i = 0; i < vowels.length(); i++) {
            if (Character.toUpperCase(word.charAt(0)) == vowels.charAt(i)) {
                return String.valueOf(sb.append(word).append("ay"));
            }
        }
        if (word.startsWith("yt") || (word.startsWith("xr"))) {
            return String.valueOf(sb.append(word).append("ay"));
        }

        if (word.contains("qu")) {
            int qu = word.indexOf("qu");
            System.out.println(qu);
            return String.valueOf(
                sb.append(word.substring(qu + 2)).append(word.substring(0, qu + 2)).append("ay"));
        }

        for (int j = 1; j < word.length(); j++) {
            int midVowelIndex = 0;
            for (int i = 0; i < vowels.length(); i++) {
                if (Character.toUpperCase(word.charAt(j)) == vowels.charAt(i)) {
                    midVowelIndex = j;
                    break;
                }
            }
            if (midVowelIndex > 0) {
                return String.valueOf(sb.append(word.substring(midVowelIndex))
                    .append(word.substring(0, midVowelIndex)).append("ay"));
            }
        }

        if (word.contains("y")) {
            int y = word.indexOf("y");
            return String.valueOf(sb.append(word.substring(y)).append(word, 0, y).append("ay"));
        }
        return String.valueOf(sb);

    }

}