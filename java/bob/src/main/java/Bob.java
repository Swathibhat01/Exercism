class Bob {
    public String hey(String string){

        if(string.matches(".*\\?\\s*")){
            if(isYelling(string)){
                return "Calm down, I know what I'm doing!";
            }
            return "Sure.";
        }
        if(isYelling(string)){
            return "Whoa, chill out!";
        }
        if(string.matches("\\s*")){
            return "Fine. Be that way!";
        }
        return "Whatever.";
    }

    private boolean isYelling(String string) {
        return string.matches(".*[a-zA-z].*") && string.toUpperCase().equals(string);
    }


}