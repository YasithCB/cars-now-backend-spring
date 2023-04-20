/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.service.impl;

import lk.carsnow.spring.dto.PaymentDTO;
import lk.carsnow.spring.entity.Payment;
import lk.carsnow.spring.repo.PaymentRepo;
import lk.carsnow.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String generatePaymentIds() {
        return paymentRepo.generatePaymentId();
    }

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (!paymentRepo.existsById(paymentDTO.getPaymentId())) {
            paymentRepo.save(mapper.map(paymentDTO, Payment.class));
        } else {
            throw new RuntimeException(paymentDTO.getPaymentId() + " Payment Already Exists..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> paymentList = paymentRepo.findAll();
        return mapper.map(paymentList, new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }

    @Override
    public double totalIncome() {
        return paymentRepo.totalIncome();
    }

    @Override
    public List<PaymentDTO> getPaymentsBetweenDates(String startDate, String endDate) {
        List<Payment> allPaymentsBetweenDates = paymentRepo.findAllPaymentsBetweenDates(startDate, endDate);
        return mapper.map(allPaymentsBetweenDates,new TypeToken<List<PaymentDTO>>(){}.getType());
    }


    @Override
    public double dailyIncome() {
        return paymentRepo.dailyIncome();
    }

    @Override
    public double weeklyIncome() {
        return paymentRepo.weeklyIncome();
    }

    @Override
    public double monthlyIncome() {
        return paymentRepo.monthlyIncome();
    }

    @Override
    public double yearlyIncome() {
        return paymentRepo.yearlyIncome();
    }

}
