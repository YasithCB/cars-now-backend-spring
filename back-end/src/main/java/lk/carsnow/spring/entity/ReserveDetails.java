/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@IdClass(lk.carsnow.spring.entity.ReserveCars.class)
@Entity
public class ReserveDetails {

    @Id
    private String reserveId;
    @Id
    private String carId;
    @Id
    private String driverId;

    private String type;
    private String colour;
    private String brand;
    private String driverWantOrNot;
    private String driverName;
    private String driverContact;
    private double loseDamageWaiverPayment;

    @ManyToOne
    @JoinColumn(name = "reserveId",referencedColumnName = "reserveId",updatable = false,insertable = false)
    private Reserve reserve;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private lk.carsnow.spring.entity.Car car;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)

    @JoinColumn(name = "driverId",referencedColumnName = "driverId",insertable = false,updatable = false,nullable = true)
    private Driver driver;

}
