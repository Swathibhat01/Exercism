
import java.util.Arrays;

public class CarsAssemble {
private static final int numberOfCarsProducedAtLowestSpeed = 221;

    private enum Speeds {
        LOW(100, 1, 4),
        MEDIUM(90, 5, 8),
        HIGH(80, 9, 9),
        HIGHEST(77, 10, 10);

        private int successRate;
        private int minSpeed;
        private int maxSpeed;

        Speeds(int successRate, int minSpeed, int maxSpeed) {
            this.successRate = successRate;
            this.minSpeed = minSpeed;
            this.maxSpeed = maxSpeed;
        }

        static Speeds calculateSuccessRatePerSpeed(int speed) {
            return Arrays.stream(Speeds.values())
                .filter(s -> speed >= s.minSpeed && speed <= s.maxSpeed)
                .findFirst()
                .orElse(Speeds.LOW);        
            }
    }

    public double productionRatePerHour(int speed) {
        Speeds speeds = Speeds.calculateSuccessRatePerSpeed(speed);
        return speed * numberOfCarsProducedAtLowestSpeed * speeds.successRate / 100.0;

    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
