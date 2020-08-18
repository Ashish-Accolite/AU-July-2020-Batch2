package com.accolite.au.Implementation;

import com.accolite.au.Interfaces.CalculatorInterface;

public class CalculatorImplementation implements CalculatorInterface {

	@Override
	public Double add(Double a, Double b) {
		return a+b;
	}

	@Override
	public Double multiply(Double a, Double b) {
		return a*b;
	}

	@Override
	public Double substract(Double a, Double b) {
		return a-b;
	}

	@Override
	public Double divide(Double a, Double b) {
		if(b==0) {
			return Double.valueOf(Integer.MIN_VALUE);
		}
		return a/b;
	}

}