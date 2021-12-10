import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumerals {

    private int number;
    private Map<Integer, String> romanNumeralsMap = new LinkedHashMap<>();


    RomanNumerals(int number) {
        this.number = number;
        romanNumeralsMap.put(1, "I");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(1000, "M");
    }


    String getRomanNumeral() {
        return getVal1(number);
//        StringBuilder sb = new StringBuilder();
//        if (number >= 1000) {
//            double floorOfNumber = Math.floor(number);
//            double v = floorOfNumber / 1000;
//            for (int i = 0; i < (int) v; i++) {
//                sb.append(getRomanValue(1000));
//            }
//            number = number % 1000;
//        }
//        if (number >= 900) {
//            sb.append(getRomanValue(900));
//            number = number % 100;
//
//        }
//        if (number >= 400) {
//            double floorOfNumber = Math.floor(number - number % 100);
//            if (floorOfNumber >= 500) {
//                sb.append(getRomanValue(500));
//                for (int i = 600; i <= floorOfNumber; i = i + 100) {
//                    sb.append(getRomanValue(100));
//                }
//            } else {
//                sb.append(getRomanValue((int) floorOfNumber));
//            }
//            number = number % 100;
//        }
//        if (number >= 100) {
//            double floorOfNumber = Math.floor(number - number % 100);
//            double v = floorOfNumber / 100;
//            for (int i = 0; i < (int) v; i++) {
//                sb.append(getRomanValue(100));
//            }
//            number = number % 100;
//        }
//        if (number >= 90) {
//            sb.append(getRomanValue(90));
//            number = number % 10;
//        }
//        if (number >= 40) {
//            double floorOfNumber = Math.floor(number - number % 10);
//            if (floorOfNumber >= 50) {
//                sb.append(getRomanValue(50));
//                for (int i = 60; i <= floorOfNumber; i = i + 10) {
//                    sb.append(getRomanValue(10));
//                }
//            } else {
//                sb.append(getRomanValue((int) floorOfNumber));
//            }
//            number = number % 10;
//
//        }
//        if (number >= 10) {
//            double floorOfNumber = Math.floor(number - number % 10);
//            double v = floorOfNumber / 10;
//            for (int i = 0; i < (int) v; i++) {
//                sb.append(getRomanValue(10));
//            }
//            number = number % 10;
//        }
//        if (number >= 1) {
//            sb.append(getRomanValue(number));
//        }
//        return String.valueOf(sb);
    }

    private String getRomanValue(int i) {
        if (romanNumeralsMap.containsKey(i)) {
            return romanNumeralsMap.get(i);
        }
        if (i == 2) {
            return "I" + "I";

        }
        if (i == 3) {
            return "I" + "I" + "I";
        }
        if (i == 6) {
            return romanNumeralsMap.get(5) + romanNumeralsMap.get(1);
        }
        if (i == 7) {
            return romanNumeralsMap.get(5) + romanNumeralsMap.get(1) + romanNumeralsMap.get(1);

        }
        if (i == 8) {
            return romanNumeralsMap.get(5) + romanNumeralsMap.get(1) + romanNumeralsMap.get(1)
                + romanNumeralsMap.get(1);
        }
        if (i % 9 == 0) {
            return (romanNumeralsMap.get((i / 9 + i) - i) + romanNumeralsMap.get(i / 9 + i));
        }
        if (i % 4 == 0) {
            return (romanNumeralsMap.get((i / 4 + i) - i) + romanNumeralsMap.get(i / 4 + i));
        }
        return "";
    }

    private String getVal(int number) {
        if (number >= 1000) {
            return "M" + getVal(number - 1000);
        }
        if (number >= 900) {
            return "CM" + getVal(number - 900);
        }
        if (number >= 500) {
            return "D" + getVal(number - 500);

        }
        if (number >= 400) {
            return "CD" + getVal(number - 400);

        }
        if (number >= 100) {
            return "C" + getVal(number - 100);
        }
        if (number >= 90) {
            return "XC" + getVal(number - 90);
        }
        if (number >= 50) {
            return "L" + getVal(number - 50);
        }
        if (number >= 40) {
            return "XL" + getVal(number - 40);
        }
        if (number >= 10) {
            return "X" + getVal(number - 10);
        }
        if (number >= 9) {
            return "IX" + getVal(number - 9);
        }
        if (number >= 5) {
            return "V" + getVal(number - 5);
        }
        if (number >= 4) {
            return "IV" + getVal(number - 4);
        }
        if (number >= 1) {
            return "I" + getVal(number - 1);
        }
        return "";
    }

    private String getVal1(int num) {
        Map<Integer, String> romanNumeralsMap2 = new LinkedHashMap<>();
        romanNumeralsMap2.put(1000, "M");
        romanNumeralsMap2.put(900, "CM");
        romanNumeralsMap2.put(500, "D");
        romanNumeralsMap2.put(400, "CD");
        romanNumeralsMap2.put(100, "C");
        romanNumeralsMap2.put(90, "XC");
        romanNumeralsMap2.put(50, "L");
        romanNumeralsMap2.put(40, "XL");
        romanNumeralsMap2.put(10, "X");
        romanNumeralsMap2.put(9, "IX");
        romanNumeralsMap2.put(5, "V");
        romanNumeralsMap2.put(4, "IV");
        romanNumeralsMap2.put(1, "I");
        int numbr = num;
        StringBuilder stringBuilder = new StringBuilder();
        for (int key : romanNumeralsMap2.keySet()) {
            while (numbr >= key) {
                stringBuilder.append(romanNumeralsMap2.get(key));
                numbr = numbr - key;
            }
        }
        return String.valueOf(stringBuilder);
    }


}