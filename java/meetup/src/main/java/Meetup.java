import java.time.DayOfWeek;
import java.time.LocalDate;

class Meetup {

    private int year;
    private int month;
    private LocalDate localDate;


    Meetup(int month, int year) {
        this.month = month;
        this.year = year;
        this.localDate = LocalDate.of(year, month, 1);
    }

    LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        switch (meetupSchedule) {
            case FIRST:
            case TEENTH:
            case LAST:
                return LocalDate.of(year, month, findDayOfTheWeek(dayOfWeek, meetupSchedule));
            case SECOND:
                return LocalDate.of(year, month, findDayOfTheWeek(dayOfWeek, meetupSchedule) + 7);
            case THIRD:
                return LocalDate.of(year, month, findDayOfTheWeek(dayOfWeek, meetupSchedule) + 14);
            case FOURTH:
                return LocalDate.of(year, month, findDayOfTheWeek(dayOfWeek, meetupSchedule) + 21);
        }
        return null;
    }

    private int findDayOfTheWeek(DayOfWeek dayOfWeekTofind, MeetupSchedule meetupSchedule) {
        int day = 1;
        DayOfWeek start = localDate.getDayOfWeek();
        if (meetupSchedule.name().equals("LAST")) {
            day = localDate.lengthOfMonth() - 6;
            start = LocalDate.of(year, month, localDate.lengthOfMonth() - 6).getDayOfWeek();
        }
        if (meetupSchedule.name().equals("TEENTH")) {
            day = 13;
            start = LocalDate.of(year, month, 13).getDayOfWeek();
        }
        for (int i = day; i < day + 7; i++) {
            if (dayOfWeekTofind.compareTo(start) == 0) {
                return i;
            }
            start = start.plus(1);
        }
        return 1;
    }
}
