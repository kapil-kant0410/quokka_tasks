package com.ql.BlogApplication.exception;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> handleNoHandlerFoundException(NoHandlerFoundException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Requested URL not matched with any api");
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(UserNotFoundException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"User not found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePostNotFoundException(PostNotFoundException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Post not found");
         return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Arguments of request are not valid");
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> handleConstraintViolationException(ConstraintViolationException ex){
           ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Constraints are violets by request");
            return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> handleNullPointerException(NullPointerException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Trying to access null object");
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDetails> handleArrayIndexOutOfBoundException(ArrayIndexOutOfBoundsException ex){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Trying to access invalid index of array");
        return  new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
