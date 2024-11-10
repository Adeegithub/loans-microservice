package com.adeesha.loans_microservice.service.impl;

import com.adeesha.loans_microservice.constants.LoansConstants;
import com.adeesha.loans_microservice.dto.LoansDto;
import com.adeesha.loans_microservice.entity.Loans;
import com.adeesha.loans_microservice.exception.LoanAlreadyExistsException;
import com.adeesha.loans_microservice.exception.ResourceNotFoundException;
import com.adeesha.loans_microservice.mapper.LoansMapper;
import com.adeesha.loans_microservice.repository.LoansRepository;
import com.adeesha.loans_microservice.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements ILoanService {

    //Dependency Injection
    @Autowired
    private LoansRepository loansRepository;
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan Already Registered with the Mobile Number: " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber){
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Loan","Mobile Number: ", mobileNumber)
                );
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        return false;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        return false;
    }
}
