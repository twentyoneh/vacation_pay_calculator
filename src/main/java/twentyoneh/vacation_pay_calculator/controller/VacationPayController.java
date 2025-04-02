package twentyoneh.vacation_pay_calculator.controller;

import twentyoneh.vacation_pay_calculator.model.VacationPayRequest;
import twentyoneh.vacation_pay_calculator.model.VacationPayResponse;
import twentyoneh.vacation_pay_calculator.service.VacationPayService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class VacationPayController {

    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping
    public VacationPayResponse calculate(
        @RequestParam double averageSalary,
        @RequestParam int vacationDays,
        @RequestParam(required = false) List<String> vacationDates) 
    {
        List<LocalDate> dates = vacationDates != null ?
            vacationDates.stream().map(LocalDate::parse).collect(Collectors.toList()) :
            null;

        return vacationPayService.calculateVacationPay(new VacationPayRequest(averageSalary, vacationDays, dates));
    }
}
