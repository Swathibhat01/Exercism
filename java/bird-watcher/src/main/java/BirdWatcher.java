import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        int[] lastWeekBirds = getLastWeek();
        if(lastWeekBirds.length==0){
            return 0;
        }
        return lastWeekBirds[lastWeekBirds.length -1];
    }

    public void incrementTodaysCount() {
        
        int[] lastWeekBirds = getLastWeek();
        if(lastWeekBirds.length > 0){
        lastWeekBirds[lastWeekBirds.length -1] +=1; 
            }
        }

    public boolean hasDayWithoutBirds() {
        int[] lastweekBirds = getLastWeek();
         return Arrays.stream(lastweekBirds).anyMatch(s -> s == 0);
        }

    public int getCountForFirstDays(int numberOfDays) {
        
        int[] lastweekBirds = getLastWeek();
        return Arrays.stream(lastweekBirds).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
            int[] lastweekBirds = getLastWeek();
        return (int)Arrays.stream(lastweekBirds).filter(s -> s>4).count();
    }
}
