package bank.Banking.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BankUtil {

    public static ResponseEntity<String> getResponseEntity(String response, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\"" + response + "\"}", httpStatus);
    }
}
