import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

class Robot {

    private static final Random random = new Random();
    private static Set<String> allNames = new HashSet<>();

    private String name;

    Robot() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        allNames.add(name);
        this.name = name;
    }

    public void reset() {
        Stream.generate(this::generateRobotName)
            .filter(generatedName -> !allNames.contains(generatedName))
            .findFirst().ifPresent(this::setName);
    }

    private String generateRobotName() {
        StringBuilder name = new StringBuilder();
        name.append(randomChar());
        name.append(randomChar());
        name.append(randomInt());
        name.append(randomInt());
        name.append(randomInt());
        return name.toString();
    }

    private int randomInt() {
        return random.nextInt(10);
    }

    private char randomChar() {
        return (char) ('A' + random.nextInt(26));
    }

}
