import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    
    private final List<String> languages = new ArrayList<>();
    private static final String JAVA = "Java";
    private static final String KOTLIN = "Kotlin";

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public String firstLanguage() {
        return isEmpty() ? null : languages.get(0);
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        return containsLanguage(JAVA) || containsLanguage(KOTLIN) ;
    }
}
