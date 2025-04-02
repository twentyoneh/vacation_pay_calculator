package twentyoneh.vacation_pay_calculator.model;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class VacationPayRequest {

    private double averageSalary; // Средняя зарплата за 12 месяцев
    private int vacationDays; // Количество дней отпуска
    private List<LocalDate> vacationDates; // Даты отпуска (необязательно)

    public VacationPayRequest(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
        this.vacationDates = vacationDates;
    }
    public VacationPayRequest() {}
}
