import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Allergies {

    private List<Allergen> allergiesList;

    Allergies(int allergenScore) {
        allergiesList = Arrays.stream(Allergen.values())
            .filter(a -> (a.getScore() & allergenScore) > 0).collect(
                Collectors.toList());
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergiesList.contains(allergen);
    }

    List<Allergen> getList() {
        return allergiesList;
    }
}
