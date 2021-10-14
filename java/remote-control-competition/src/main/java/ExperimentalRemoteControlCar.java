public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled = 0;
    private int numberOfVictories =0;

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    @Override
    public void race() {
        distanceTravelled+=20;
    }

    @Override
    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public void drive() {
        throw new UnsupportedOperationException("Please implement the ExperimentalRemoteControlCar.drive() method");
    }


    @Override
    public int compareTo(RemoteControlCar o) {
        return getNumberOfVictories()-o.getNumberOfVictories();
    }

    @Override
    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    @Override
    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
}
