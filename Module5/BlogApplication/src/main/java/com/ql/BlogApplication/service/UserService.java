package com.ql.BlogApplication.service;
import com.ql.BlogApplication.dto.ApiResponse;
import com.ql.BlogApplication.repository.UserRepository;
import com.ql.BlogApplication.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

//    ResponseEntity<ApiResponse<List<User>>> findAllUsers(){
//
//        ApiResponse<List<User>> apiResponse=new ApiResponse<List<User>>(HttpStatus.ACCEPTED,"",userRepository.findAll());
//          return ResponseEntity();
//    }

}
