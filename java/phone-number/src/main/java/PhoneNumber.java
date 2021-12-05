class PhoneNumber {

    private String phoneNumber;

    PhoneNumber(String phoneNumber) {
        this.phoneNumber = cleanUp(phoneNumber);
    }

    public String getNumber() {
        return phoneNumber.length() == 11 ? phoneNumber.substring(1) : phoneNumber;
    }

    private String cleanUp(String phoneNumber) {
        String s = phoneNumber.replaceAll("[-+().\\s]", "");
        if (s.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (s.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (s.matches(".*[^0-9]+.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        if (s.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (s.length() == 11) {
            if (s.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            isAreaAndExchangeCodeValid(s, 1, "area");
            isAreaAndExchangeCodeValid(s, 4, "exchange");

        }
        if (s.length() == 10) {
            isAreaAndExchangeCodeValid(s, 0, "area");
            isAreaAndExchangeCodeValid(s, 3, "exchange");

        }
        return s;
    }

    private void isAreaAndExchangeCodeValid(String s, int codeIndex, String codeName) {
        if (s.charAt(codeIndex) == '0' || s.charAt(codeIndex) == '1') {
            throw new IllegalArgumentException(
                codeName + " code cannot start with " + (s.charAt(codeIndex) == '0' ? "zero"
                    : "one"));
        }
    }
}
