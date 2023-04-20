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

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Reserve {

    @Id
    private String reserveId;

    private String reserveDate;
    private String pickUpDate;
    private String pickUpTime;
    private String destination;
    private int duration;
    private String pickUpVenue;
    private String returnVenue;
    private String returnDate;
    private String returnTime;
    private String requestAcceptOrDeny;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private lk.carsnow.spring.entity.Customer customer;

    @OneToMany(mappedBy = "reserve",cascade = CascadeType.ALL)
    private List<lk.carsnow.spring.entity.ReserveDetails> reserveDetails;

}
