class MicroBlog {

    public String truncate(String input) {
        int[] ints = input.codePoints().limit(5).toArray();
        return new String(ints, 0, ints.length);
    }
}
