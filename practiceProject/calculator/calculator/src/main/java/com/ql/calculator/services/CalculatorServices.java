package com.ql.calculator.services;

import com.ql.calculator.request.CalculatorRequest;
import com.ql.calculator.response.CalculatorResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service

public class CalculatorServices {

    public CalculatorResponse calculate(CalculatorRequest request) {

        Double input1;
        Double input2;
        Double result;

        try{
            input1=Double.parseDouble(request.getInput1());
            input2=Double.parseDouble(request.getInput2());
        }catch (NumberFormatException e){
            return new CalculatorResponse("0.00", "0.00", request.getOperation(), 0.00,"Please provide valid numbers for operations");
        }catch (NullPointerException e){
            return new CalculatorResponse("0.00", "0.00", request.getOperation(), 0.00,"Please pass valid numbers instead of null");
        }

        switch(request.getOperation()){
            case "addition":{
                result=input1+input2;
                break;
            }
            case "subtraction" :{
                result= input1-input2;
                break;
            }
            case "multiplication" :{
                result= input1*input2;
                break;
            }
            case "division" :{
                if(input2==0){
                    return new CalculatorResponse(request.getInput1(), request.getInput2(), request.getOperation(), 0.00,"Division by zero not allowed");
                }
                result= input1/input2;
                break;
            }
            case "modulus":{
                  result= (((input1%input2)+input2)%input2);
                  break;
            }
            default:{
                return new CalculatorResponse(request.getInput1(), request.getInput2(), request.getOperation(), 0.00,"Please provide valid operator from addition,subtraction,division,multiplication,modulus");
            }
        }

        return new CalculatorResponse(request.getInput1(),request.getInput2(),request.getOperation(),result,"Operation performed successfully");

    }

}
