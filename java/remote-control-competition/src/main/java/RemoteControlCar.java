public interface RemoteControlCar extends Comparable<RemoteControlCar>{

     void setDistanceTravelled(int distanceTravelled);

     void drive();

     int getDistanceTravelled();

     void race();

     int getNumberOfVictories();

     void setNumberOfVictories(int numberOfVictories);
}
