package com.example.ss10_exercise_2_simple_calculator;

public class Calculator {

    public float calculate(float firstOperand, float secondOperand, char operator) throws CatchException {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else throw new ArithmeticException("Can't divide by zero");
            default: throw new CatchException("Invalid Operator");
        }
    }
}
