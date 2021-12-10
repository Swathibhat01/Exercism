import java.util.StringJoiner;
import java.util.stream.IntStream;

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
        IntStream.rangeClosed(0, words.length - 2)
            .mapToObj(i -> String.format(mainLineOfThePoem, words[i], words[i + 1]))
            .forEach(sj::add);
        sj.add(String.format(lastLine, words[0]));
        return String.valueOf(sj);
    }
}