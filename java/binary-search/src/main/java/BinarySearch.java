import java.util.List;

class BinarySearch {

    private final List<Integer> sortedList;

    BinarySearch(List<Integer> listOfIntegers) {
        this.sortedList = listOfIntegers;
    }

    public int indexOf(int number) throws ValueNotFoundException {
        return binarySearchHelper(number, sortedList, 0, sortedList.size() - 1);
    }

    private int binarySearchHelper(int number, List<Integer> list, int low, int high)
        throws ValueNotFoundException {
        int mid = (high + low) / 2;
        if (low > high) {
            throw new ValueNotFoundException("Value not in array");
        }
        if (number == sortedList.get(mid)) {
            return mid;
        } else if (number > sortedList.get(mid)) {
            return binarySearchHelper(number, list, mid + 1, high);
        } else {
            return binarySearchHelper(number, list, low, mid - 1);
        }
    }

}
