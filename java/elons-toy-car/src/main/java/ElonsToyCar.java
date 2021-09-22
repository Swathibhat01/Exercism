public class ElonsToyCar {
    private  int totalDistanceDriven =0  ;
    private  int remainingBatteryCharge =100 ;

    ElonsToyCar(){
    }


    ElonsToyCar(int totalDistanceDriven , int remainingBatteryCharge){
        this.totalDistanceDriven = totalDistanceDriven;
        this.remainingBatteryCharge = remainingBatteryCharge;
    }


    public static ElonsToyCar buy() {
        return new ElonsToyCar(0,100);
    }

    public String distanceDisplay() {
        return String.format("%s %s %s" , "Driven" , totalDistanceDriven , "meters");
    }

    public String batteryDisplay() {
        if(remainingBatteryCharge==0){
            return "Battery empty";
        }
      return   String.format("%s %s %s%s","Battery", "at" ,remainingBatteryCharge , "%");
    }

    public void drive() {
        if (remainingBatteryCharge>0) {
            totalDistanceDriven = totalDistanceDriven + 20;
            remainingBatteryCharge = remainingBatteryCharge - 1;
        }
    }
}
