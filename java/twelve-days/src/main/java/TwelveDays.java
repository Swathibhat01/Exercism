import java.util.StringJoiner;

class TwelveDays {

    private String[] lines;
    private String[] days;

    TwelveDays() {
        lines = new String[]{"a Partridge in a Pear Tree.", "two Turtle Doves", "three French Hens",
            "four Calling Birds", "five Gold Rings", "six Geese-a-Laying", "seven Swans-a-Swimming",
            "eight Maids-a-Milking", "nine Ladies Dancing", "ten Lords-a-Leaping",
            "eleven Pipers Piping", "twelve Drummers Drumming"};

        days = new String[]{"first" , "second", "third","fourth","fifth","sixth","seventh","eighth","ninth",
                           "tenth","eleventh","twelfth"};

    }

    String verse(int verseNumber) {
        String mainLine = "On the %s day of Christmas my true love gave to me: ";
        StringJoiner sj = new StringJoiner(", ");
        if (verseNumber > 1) {
            for (int i = verseNumber - 1; i >= 1; i--) {
                sj.add(lines[i]);
            }
            sj.add("and ");
        }
        return String.format(mainLine, days[verseNumber-1]) + (sj) + lines[0] + "\n";
    }

    String verses(int startVerse, int endVerse) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = startVerse; i <= endVerse; i++) {
            sj.add(verse(i));
        }
        return String.valueOf(sj);
    }

    String sing() {
        return verses(1, 12);
    }
}
