import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

class FoodChain {

    private final String swallowed = "I know an old lady who swallowed a %s.";
    private final String reasoningLine = "She swallowed the %s to catch the %s.";

    private Map<String, String> reason = new LinkedHashMap<>();

    FoodChain() {
        reason.put("fly", "I don't know why she swallowed the fly. Perhaps she'll die.");
        reason.put("spider", "It wriggled and jiggled and tickled inside her.");
        reason.put("bird", "How absurd to swallow a bird!");
        reason.put("cat", "Imagine that, to swallow a cat!");
        reason.put("dog", "What a hog, to swallow a dog!");
        reason.put("goat", "Just opened her throat and swallowed a goat!");
        reason.put("cow", "I don't know how she swallowed a cow!");
        reason.put("horse", "She's dead, of course!");
    }

    public String verse(int verse) {
        StringJoiner sj = new StringJoiner("\n");

        switch (verse) {
            case (1):
                sj.add(String.format(swallowed, "fly")).add(reason.get("fly"));
                return String.valueOf(sj);
            case (2):
                sj.add(String.format(swallowed, "spider"))
                    .add(reason.get("spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                return String.valueOf(sj);
            case (3):
                StringJoiner sj5 = new StringJoiner("\n");
                sj5.add(getReasonLine("bird", "spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                sj.add(String.format(swallowed, "bird"))
                    .add(reason.get("bird"))
                    .add(String.valueOf(sj5));
                return String.valueOf(sj);
            case (4):
                StringJoiner sj4 = new StringJoiner("\n");
                sj4.add(getReasonLine("bird", "spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                sj.add(String.format(swallowed, "cat"))
                    .add(reason.get("cat"))
                    .add(getReasonLine("cat", "bird"))
                    .add(String.valueOf(sj4));
                return String.valueOf(sj);
            case (5):
                StringJoiner sj3 = new StringJoiner("\n");
                sj3.add(getReasonLine("bird", "spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                sj.add(String.format(swallowed, "dog"))
                    .add(reason.get("dog"))
                    .add(getReasonLine("dog", "cat"))
                    .add(getReasonLine("cat", "bird"))
                    .add(String.valueOf(sj3));
                return String.valueOf(sj);
            case (6):
                sj.add(String.format(swallowed, "goat"))
                    .add(reason.get("goat"))
                    .add(getReasonLine("goat", "dog"))
                    .add(getReasonLine("dog", "cat"))
                    .add(getReasonLine("cat", "bird"))
                    .add(getReasonLine("bird", "spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                return String.valueOf(sj);
            case (7):
                sj.add(String.format(swallowed, "cow"))
                    .add(reason.get("cow"))
                    .add(getReasonLine("cow", "goat"))
                    .add(getReasonLine("goat", "dog"))
                    .add(getReasonLine("dog", "cat"))
                    .add(getReasonLine("cat", "bird"))
                    .add(getReasonLine("bird", "spider"))
                    .add(getReasonLine("spider", "fly"))
                    .add(reason.get("fly"));
                return String.valueOf(sj);
            case (8):
                sj.add(String.format(swallowed, "horse"))
                    .add(reason.get("horse"));
                return String.valueOf(sj);
        }
        return null;
    }

    private String getReasonLine(String first, String second) {
        if (second.equals("spider")) {
            return String.format(reasoningLine, first,
                String.format("%s that wriggled and jiggled and tickled inside her", second));
        }
        return String.format(reasoningLine, first, second);
    }

    public String verses(int startVerse, int endVerse) {
        StringJoiner sj = new StringJoiner("\n\n");
        for (int i = startVerse; i <= endVerse; i++) {
            sj.add(verse(i));
        }
        return String.valueOf(sj);
    }


}
