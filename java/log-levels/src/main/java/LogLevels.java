import java.util.Arrays;

public class LogLevels {
  private enum LevelsOfLog {
        INFO,
        WARNING,
        ERROR
    }

    public static String message(String logLine) {
        String level = parseLogLevel(logLine).name() ;
        String stringToReplace = "[" + level + "]:" ;
        return logLine.replace(stringToReplace , "").trim();
    }

    public static LevelsOfLog parseLogLevel(String logLine) {
        return Arrays.stream(LevelsOfLog.values())
                .filter(l->logLine.contains(l.name()))
                .findFirst().orElse(null);

    }

    public static String logLevel(String logLine) {
        return parseLogLevel(logLine).name().toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }

}
 