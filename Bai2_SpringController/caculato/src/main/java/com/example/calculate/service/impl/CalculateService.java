package com.example.calculate.service.impl;

import com.example.calculate.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Override
    public float plusExpression(float num1, float num2) {
        return num1+num2;
    }

    @Override
    public float minusExpression(float num1, float num2) {
        return num1-num2;
    }

    @Override
    public float multiplicationExpression(float num1, float num2) {
        return num1*num2;
    }

    @Override
    public float divisionExpression(float num1, float num2) {
        return num1/num2;
    }
}
