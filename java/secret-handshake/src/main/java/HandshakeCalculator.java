import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HandshakeCalculator {

    private Map<Integer, Signal> indexSignalMap = Map
        .of(0, Signal.WINK, 1, Signal.DOUBLE_BLINK, 2, Signal.CLOSE_YOUR_EYES, 3,
            Signal.JUMP);

    List<Signal> calculateHandshake(int number) {
        List<Signal> listOfSignals = new ArrayList<>();
        String binaryString = convertFromDecimalToReversedBinary(number);

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (i == 4) {
                    Collections.reverse(listOfSignals);
                }
                if (indexSignalMap.containsKey(i)) {
                    listOfSignals.add(indexSignalMap.get(i));
                }
            }
        }

        return listOfSignals;

    }

    String convertFromDecimalToReversedBinary(int number) {
        List<Integer> binaryNumber = new ArrayList<>();
        int numberToAdd;
        while (number > 1) {
            numberToAdd = number % 2;
            number = number / 2;
            binaryNumber.add(numberToAdd);
        }
        binaryNumber.add(number);
        return binaryNumber.stream().map(Object::toString).collect(Collectors.joining());
    }
}
