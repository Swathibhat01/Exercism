import java.util.StringJoiner;

class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        String mainLineOfThePoem = "For want of a %s the %s was lost.";
        String lastLine = "And all for the want of a %s.";
        if (words.length == 0) {
            return "";
        }
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i <= words.length - 2; i++) {
            sj.add(String.format(mainLineOfThePoem, words[i], words[i + 1]));
        }
        sj.add(String.format(lastLine, words[0]));
        return String.valueOf(sj);
    }
}