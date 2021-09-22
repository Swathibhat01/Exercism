class NeedForSpeed {

    private int speedOfTheCarInMeters;
    private int batteryDrainPercentage;
    private int distanceCovered;
    private int batteryPercentage ;

    NeedForSpeed(int speedOfTheCarInMeters , int batteryDrainPercentage){

        this.speedOfTheCarInMeters = speedOfTheCarInMeters;
        this.batteryDrainPercentage = batteryDrainPercentage;
        this.distanceCovered =0;
        this.batteryPercentage=100;
    }


    public boolean batteryDrained() {
        return batteryPercentage==0;
    }

    public int distanceDriven() {
      return distanceCovered;
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceCovered = distanceCovered + speedOfTheCarInMeters;
            batteryPercentage = batteryPercentage - batteryDrainPercentage;

        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {

    private int distanceInMeters;

    RaceTrack(int distanceInMeters){

        this.distanceInMeters = distanceInMeters;
    }
    public boolean carCanFinish(NeedForSpeed car) {
      while(!car.batteryDrained() && car.distanceDriven() <distanceInMeters){
            car.drive();
        }

      return car.distanceDriven() >= distanceInMeters;
        
    }
}
