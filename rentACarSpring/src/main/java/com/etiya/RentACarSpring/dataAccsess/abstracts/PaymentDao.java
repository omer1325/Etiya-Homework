package com.etiya.RentACarSpring.dataAccsess.abstracts;

import com.etiya.RentACarSpring.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
