package twentyoneh.vacation_pay_calculator.service;

import twentyoneh.vacation_pay_calculator.model.VacationPayRequest;
import twentyoneh.vacation_pay_calculator.model.VacationPayResponse;
import org.junit.jupiter.api.Test;
import java.util.List;
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
        request.setVacationDates(List.of(
            LocalDate.of(2024, 5, 1), 
            LocalDate.of(2024, 5, 2),
            LocalDate.of(2024, 5, 3)
        ));

        VacationPayResponse response = service.calculateVacationPay(request);

        assertEquals(20689.66, response.getTotalPay(), 0.01);
    }
}
