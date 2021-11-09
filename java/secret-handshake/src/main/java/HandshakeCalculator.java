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

//        if (binaryString.equals("0")) {
//            return listOfSignals;
//        }
//
//        if (binaryString.charAt(0) == '1') {
//            listOfSignals.add(Signal.WINK);
//            if (binaryString.length() <= 1) {
//                return listOfSignals;
//            }
//        }
//        if (binaryString.charAt(1) == '1') {
//            listOfSignals.add(Signal.DOUBLE_BLINK);
//            if (binaryString.length() <= 2) {
//                return listOfSignals;
//            }
//        }
//        if (binaryString.charAt(2) == '1') {
//            listOfSignals.add(Signal.CLOSE_YOUR_EYES);
//            if (binaryString.length() <= 3) {
//                return listOfSignals;
//            }
//        }
//        if (binaryString.charAt(3) == '1') {
//            listOfSignals.add(Signal.JUMP);
//            if (binaryString.length() <= 4) {
//                return listOfSignals;
//            }
//        }
//        if (binaryString.charAt(4) == '1') {
//            Collections.reverse(listOfSignals);
//        }
//
//        return listOfSignals;
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
