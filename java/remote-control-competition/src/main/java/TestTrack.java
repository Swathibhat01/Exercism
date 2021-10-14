import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.race();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        List<ProductionRemoteControlCar> rankedCars = new ArrayList<>();
        rankedCars.add(prc1);
        rankedCars.add(prc2);
        Collections.sort(rankedCars);
        return rankedCars;
    }
}
