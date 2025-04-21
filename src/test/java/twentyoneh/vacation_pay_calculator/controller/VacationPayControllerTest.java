package twentyoneh.vacation_pay_calculator.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import twentyoneh.vacation_pay_calculator.model.VacationPayRequest;
import twentyoneh.vacation_pay_calculator.model.VacationPayResponse;
import twentyoneh.vacation_pay_calculator.service.VacationPayService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

//.\mwnw test
class VacationPayControllerTest {

    private final VacationPayService vacationPayService = Mockito.mock(VacationPayService.class);
    private final VacationPayController controller = new VacationPayController(vacationPayService);

    @Test
    void testCalculateWithoutDates() {
        Mockito.when(vacationPayService.calculateVacationPay(any(VacationPayRequest.class)))
                .thenReturn(new VacationPayResponse(28965.52));

        VacationPayResponse response = controller.calculate(60000, 14, null);

        assertEquals(28965.52, response.getTotalPay(), 0.01);
    }

    @Test
    void testCalculateWithHolidays() {
        Mockito.when(vacationPayService.calculateVacationPay(any(VacationPayRequest.class)))
                .thenReturn(new VacationPayResponse(20689.66));

        VacationPayResponse response = controller.calculate(60000, 14, List.of("2024-05-01", "2024-05-02", "2024-05-03"));

        assertEquals(20689.66, response.getTotalPay(), 0.01);
    }
}