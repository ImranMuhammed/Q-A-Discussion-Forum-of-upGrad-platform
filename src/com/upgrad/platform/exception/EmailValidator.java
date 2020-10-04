package com.upgrad.platform.exception;

import com.upgrad.platform.Application.WelcomePage;

import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean isEmailValid(String emailId) throws EmailNotValidException {
        WelcomePage welcome=WelcomePage.getInstance();
        String validEmailPattern="^[\\w]+@[\\w]+[.][A-Za-z]{2,6}";
        boolean isValid = Pattern.matches(validEmailPattern, emailId);
        if(!isValid) {
            try {
                throw new EmailNotValidException("Email id is not valid. Please enter the email id in the form of abc@xyz.com");
            }catch (EmailNotValidException e){
                System.out.println(e.getMessage());
                welcome.welcomePage();
            }
        }
        return isValid;
    }
}
