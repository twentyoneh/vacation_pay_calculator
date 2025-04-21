package twentyoneh.vacation_pay_calculator.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class HolidayUtils 
{

    private static final Set<LocalDate> HOLIDAYS = Set.of(  // - Список праздничных дней
        LocalDate.of(2025, 1, 1),
        LocalDate.of(2025, 1, 2),
        LocalDate.of(2025, 1, 3),
        LocalDate.of(2025, 1, 4),
        LocalDate.of(2025, 1, 5),
        LocalDate.of(2025, 1, 6),
        LocalDate.of(2025, 1, 7),
        LocalDate.of(2025, 1, 8),
        LocalDate.of(2025, 2, 23),
        LocalDate.of(2025, 3, 8),
        LocalDate.of(2025, 5, 1),
        LocalDate.of(2025, 5, 9),
        LocalDate.of(2025, 6, 12),
        LocalDate.of(2025, 11, 4) 
    );

    public static int calculateEffectiveVacationDays(List<LocalDate> vacationDates) 
    {
        return (int) vacationDates.stream()
            .filter(date -> !HOLIDAYS.contains(date) && !isWeekend(date))
            .count();
    }

    private static boolean isWeekend(LocalDate date) 
    {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
