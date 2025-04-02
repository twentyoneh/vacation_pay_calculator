package twentyoneh.vacation_pay_calculator.service;

import twentyoneh.vacation_pay_calculator.model.VacationPayRequest;
import twentyoneh.vacation_pay_calculator.model.VacationPayResponse;
import twentyoneh.vacation_pay_calculator.utils.HolidayUtils;
import org.springframework.stereotype.Service;

@Service
public class VacationPayService {

    private static final int WORKING_DAYS_IN_MONTH = 29;

    public VacationPayResponse calculateVacationPay(VacationPayRequest request) {
        if(request.getAverageSalary()<= 0)
        {
            return new VacationPayResponse(0.0);
        }
        double dailyRate = request.getAverageSalary() / WORKING_DAYS_IN_MONTH;
        int vacationDays = request.getVacationDays();
        
        if (request.getVacationDates() != null && !request.getVacationDates().isEmpty()) {
            vacationDays = HolidayUtils.calculateEffectiveVacationDays(request.getVacationDates());
        }

        double totalPay = dailyRate * vacationDays;
        return new VacationPayResponse(totalPay);
    }
}
