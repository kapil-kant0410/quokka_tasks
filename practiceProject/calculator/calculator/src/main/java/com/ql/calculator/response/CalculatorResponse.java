package com.ql.calculator.response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorResponse {
     String input1;
     String input2;
     String operation;
     Double output;
     String message;
}
