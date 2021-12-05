import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class House {

    private String[] listOfString = new String[]{
        "the house that Jack built.",
        "the malt that lay in ",
        "the rat that ate ",
        "the cat that killed ",
        "the dog that worried ",
        "the cow with the crumpled horn that tossed ",
        "the maiden all forlorn that milked ",
        "the man all tattered and torn that kissed ",
        "the priest all shaven and shorn that married ",
        "the rooster that crowed in the morn that woke ",
        "the farmer sowing his corn that kept ",
        "the horse and the hound and the horn that belonged to "
    };

    public String sing() {
        return verses(1, listOfString.length);
    }

    public String verses(int startVerse, int endVerse) {
        return IntStream.range(startVerse, endVerse + 1).mapToObj(this::verse)
            .collect(Collectors.joining("\n"));
    }

    public String verse(int verseNumber) {
        return IntStream.iterate(verseNumber, value -> value >= 1, operand -> operand - 1)
            .mapToObj(i -> listOfString[i - 1])
            .collect(Collectors.joining("","This is ",""));
    }
}
