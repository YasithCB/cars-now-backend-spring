/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {

    private String paymentId;
    private String paymentDate;
    private double rentFee;
    private String harmOrNot;
    private double loseDamagePayment;
    private double reduceLoseDamagePayment;
    private double driverFee;
    private double travelledDistance;
    private double extraKm;
    private double extraKmPrice;
    private double fullPayment;

    private lk.carsnow.spring.dto.ReserveDetailsDTO reserveDetails;

}
