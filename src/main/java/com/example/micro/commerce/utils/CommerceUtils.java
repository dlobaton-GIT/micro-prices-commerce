package com.example.micro.commerce.utils;

import com.example.micro.shared.exceptionhanlder.ServiceException;
import org.springframework.http.HttpStatus;

public class CommerceUtils {
    public static void assertInteger(String name, String value) {
        if(!value.matches("[0-9]+")){
            throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST), "Parameter " + name + " is invalid. Integer format is expected.");
        }
    }

    public static void assertDateFormat(String name, String value) {
        if(!value.matches("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]")){
            throw new ServiceException(String.valueOf(HttpStatus.BAD_REQUEST), "Parameter " + name + " is invalid. Date format 'yyyy-mm-dd hh:mm:ss' is expected.");
        }
    }
}
