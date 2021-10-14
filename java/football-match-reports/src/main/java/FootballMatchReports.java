

public class FootballMatchReports  {
    enum PlayerDescription
    {
        GOALIE("goalie") ,
        LEFT_BACK ("left back"),
        CENTER_BACK ("center back"),
        RIGHT_BACK("right back"),
        MIDFIELDER("midfielder"),
        LEFT_WING("left wing"),
        STRIKER ("striker"),
        RIGHT_WING("right wing");

        public final String label;

        PlayerDescription(String label) {
            this.label = label;
        }
    }





    public static String onField(int shirtNum) throws IllegalArgumentException {
        switch (shirtNum){
            case 1 :
                return PlayerDescription.GOALIE.label ;
            case 2 :
                return PlayerDescription.LEFT_BACK.label;
            case 3 :
            case 4 :
                return PlayerDescription.CENTER_BACK.label;
            case 5 :
                return PlayerDescription.RIGHT_BACK.label;
            case 6 :
            case 7 :
            case 8 :
                return PlayerDescription.MIDFIELDER.label;
            case 9 :
                return PlayerDescription.LEFT_WING.label;
            case 10 :
                return PlayerDescription.STRIKER.label;
            case 11 :
                return PlayerDescription.RIGHT_WING.label;
            default:
                throw new IllegalArgumentException();

        }
    }
}
