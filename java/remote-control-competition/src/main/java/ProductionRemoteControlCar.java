class ProductionRemoteControlCar implements RemoteControlCar{
    private int distanceTravelled;
    private int numberOfVictories;

    @Override
    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled=distanceTravelled ;
    }

    public void drive() {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.drive() method");
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    @Override
    public void race() {
        distanceTravelled+=10;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberofVictories) {
        this.numberOfVictories = numberofVictories;
    }

    @Override
    public int compareTo(RemoteControlCar o) {
        return this.getNumberOfVictories()-o.getNumberOfVictories();
    }
}
