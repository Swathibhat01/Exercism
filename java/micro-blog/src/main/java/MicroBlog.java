class MicroBlog {

    public String truncate(String input) {
            int[] inputCodePoints = input.codePoints().toArray();
            if (inputCodePoints.length < 6) {
            } else {
                return new String(inputCodePoints, 0, 5);
            }
            return input;
    }
}
