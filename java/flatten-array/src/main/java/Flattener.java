import java.util.ArrayList;
import java.util.List;

class Flattener<T> {

    public List<T> flatten(List<T> list) {
        List<T> flattenedList = new ArrayList<>();
        flattenHelper(list, flattenedList);
        return flattenedList;

    }

    private void flattenHelper(List<T> list, List<T> flattenedList) {
        for (T l : list) {
            if (l == null) {
                continue;
            }
            if (!(l instanceof List)) {
                flattenedList.add(l);
                continue;
            }

            flattenHelper((List<T>) l, flattenedList);
        }
    }
}






