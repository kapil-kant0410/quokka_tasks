package com.ql.calculator.controller;

import com.ql.calculator.request.CalculatorRequest;
import com.ql.calculator.response.CalculatorResponse;
import com.ql.calculator.services.CalculatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class CalculatorController {

    @Autowired
    CalculatorServices calculatorServices;

    @PostMapping("/calculate")
    public CalculatorResponse calculate(@RequestBody CalculatorRequest request){
          return calculatorServices.calculate(request);
    }

}
