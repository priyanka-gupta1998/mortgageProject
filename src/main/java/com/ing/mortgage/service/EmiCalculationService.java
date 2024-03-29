package com.ing.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CalculatedEmiDto;
import com.ing.mortgage.dto.EmiDto;
import com.ing.mortgage.util.EmiCalculation;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmiCalculationService implements EmiCalculationServiceImpl {

	@Autowired
	EmiCalculation emiCalculation;
	
	/**
	 * @author Sharath
	 * @param tenure
	 * @param rate of interest
	 * @param loan amount
	 * @apiNote calculate emi for the customer
	 */
	@Override
	public CalculatedEmiDto calculatedEmi(EmiDto emiDto) {
		
		log.info("event for the calculation emi in service is called");
		Double emi = emiCalculation.emiTenureCalculation(emiDto.getRateOfInterest(), emiDto.getLoanAmount(), emiDto.getTenure());
		CalculatedEmiDto emiDtoValue = new CalculatedEmiDto();
		emiDtoValue.setEmiAmount(emi);
		emiDtoValue.setStatusCode(HttpStatus.OK.value());
		return emiDtoValue;
	}

}
