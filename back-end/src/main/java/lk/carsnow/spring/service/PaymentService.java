package lk.carsnow.spring.service;

import lk.carsnow.spring.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    String generatePaymentIds();

    void savePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> getAllPayments();

    double totalIncome();

    List<PaymentDTO> getPaymentsBetweenDates(String startDate, String endDate);

    double dailyIncome();

    double weeklyIncome();

    double monthlyIncome();

    double yearlyIncome();

}
