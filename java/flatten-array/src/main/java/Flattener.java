import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Flattener<T> {

    public List<T> flatten(List<T> list){
        List<T> flattenedList = new ArrayList<>();
        flattenHelper(list , flattenedList);
        return flattenedList;

    }

    private void flattenHelper(List<T> list, List<T> flattenedList) {
        for(Object l : list){
            if(l!=null){
                if(l instanceof List){
                    flattenHelper((List<T>) l ,flattenedList);
                }
                else
                    flattenedList.add((T) l);

            }
        }
    }


}

