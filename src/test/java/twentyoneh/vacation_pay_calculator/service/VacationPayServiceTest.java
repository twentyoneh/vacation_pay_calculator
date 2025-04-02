package twentyoneh.vacation_pay_calculator.service;

import twentyoneh.vacation_pay_calculator.model.VacationPayRequest;
import twentyoneh.vacation_pay_calculator.model.VacationPayResponse;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class VacationPayServiceTest {

    private final VacationPayService service = new VacationPayService();

    @Test
    void testCalculateVacationPayWithoutDates() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(60000);
        request.setVacationDays(14);

        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(28965.52, response.getTotalPay(), 0.01);
    }

    @Test
    void testCalculateVacationPayWithHolidays() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(60000);
        request.setVacationDays(14);
        
        List<LocalDate> vacationDates = IntStream.range(0, 14)
            .mapToObj(i -> LocalDate.of(2024, 5, 1).plusDays(i))
            .collect(Collectors.toList());
        request.setVacationDates(vacationDates);
        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(20689.66, response.getTotalPay(), 0.01);
    }

    @Test
    void testCalculateVacationPayWithZeroDays() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(60000);
        request.setVacationDays(0);

        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(0.0, response.getTotalPay(), 0.01);
    }

    @Test
    void testCalculateVacationPayWithNegativeSalary() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(-50000);
        request.setVacationDays(10);

        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(0.0, response.getTotalPay(), 0.01, "Negative salary should result in zero pay.");
    }

    @Test
    void testCalculateVacationPayWithPartialDays() {
        VacationPayRequest request = new VacationPayRequest();
        request.setAverageSalary(60000);
        request.setVacationDays(7);

        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(14482.76, response.getTotalPay(), 0.01);
    }
}