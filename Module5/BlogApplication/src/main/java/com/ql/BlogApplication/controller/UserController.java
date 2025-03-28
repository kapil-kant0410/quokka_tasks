package com.ql.BlogApplication.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;


@RestController
@RequestMapping("api/roles")


public class UserController {

      @GetMapping("/getData/{id}")
      public String getData(@PathVariable Long id){
            String name=null;
              name.length();
          return "hello from backend";
      }

}
