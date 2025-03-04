package com.ql.HelloWorld;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
      @GetMapping("hello")
      public String printHelloWorld(){
          return "Hello World";
      }
}
