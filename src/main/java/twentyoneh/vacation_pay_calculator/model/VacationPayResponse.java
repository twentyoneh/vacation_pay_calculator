package twentyoneh.vacation_pay_calculator.model;

import lombok.Data;

@Data
public class VacationPayResponse 
{
    private double totalPay; // Итоговая сумма отпускных

    public VacationPayResponse(double totalPay)
    {
        this.totalPay = totalPay;
    }
}
