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

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {


    private String customerId;

    private lk.carsnow.spring.dto.UsersDTO users;

    private String customerName;
    private LocalDate registeredDate;
    private String customerAddress;
    private String customerContact;
    private String customerEmail;
    private String customerNicNo;
    private String customerDrivingLicenseNo;
    private String NICImage;
    private String DrivingLicenseImage;

}
