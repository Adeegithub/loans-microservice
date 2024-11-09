package com.adeesha.loans_microservice.service;

import com.adeesha.loans_microservice.dto.LoansDto;

public interface ILoanService {
   void createLoan(String mobileNumber);

   LoansDto fetchLoan(String mobileNumber);

   boolean updateLoan(LoansDto loansDto);

   boolean deleteLoan(String mobileNumber);
}
