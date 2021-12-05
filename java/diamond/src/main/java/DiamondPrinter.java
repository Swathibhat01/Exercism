import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> diamond = new ArrayList<>();
        int index = (a - 'A') + 1;
        int numberOfColumns = (index * 2) - 1;
        int topIndexOfDiamond = numberOfColumns / 2;
        int first = topIndexOfDiamond;
        int last = topIndexOfDiamond;
        for (int i = 0; i < index; i++) {
            String line = makeLine((char) ('A'+i), first, last, numberOfColumns);
            diamond.add(i, line);
            first = first - 1;
            last = last + 1;
        }
        for (int i = index - 2; i >= 0; i--) {
            diamond.add(diamond.get(i));
        }
        return diamond;
    }

    private String makeLine(char c, int first, int last, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i == first || i == last ? c : ' ');
        }
        return sb.toString();
    }

}
