import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Robot {
    private String name;
    private Set<String> allRobotNameInFactory = new HashSet<>();

    Robot(){
        reset();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reset(){
        String allowedAlphabet =  "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
        String allowedDigits = "0123456789";

        StringBuilder robotName;
        do{
            robotName =generateRobotName(allowedAlphabet,allowedDigits);
        }while (allRobotNameInFactory.contains(robotName.toString()));
        setName(robotName.toString());





    }
    private StringBuilder generateRobotName(String alphabet ,String digits){
        StringBuilder name = new StringBuilder();
        Random randomNumber = new Random();
        getRandomCharFromPattern(alphabet, name, randomNumber);
        getRandomCharFromPattern(alphabet, name, randomNumber);
        getRandomCharFromPattern(digits, name, randomNumber);
        getRandomCharFromPattern(digits, name, randomNumber);
        getRandomCharFromPattern(digits, name, randomNumber);
        return name;
    }

    private void getRandomCharFromPattern(String allowedAlphabet, StringBuilder stringBuilder,
        Random random) {
        stringBuilder.append(allowedAlphabet.charAt((random.nextInt(allowedAlphabet.length()))));
    }
}
