public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven(){
        return 40 ;
    }

    // TODO: define the 'remainingMinutesInOven()' method
     public int remainingMinutesInOven(int actualMinutes){
         int remainingMinutes = expectedMinutesInOven() - actualMinutes;
         return remainingMinutes < 0 ? 0 : remainingMinutes;
     }
    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int numberOfLayers){
        return numberOfLayers *2 ;
    }


    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int numberOfLayers , int numberOfMinutesInOven){
        return preparationTimeInMinutes(numberOfLayers) + numberOfMinutesInOven ;
    }
}
