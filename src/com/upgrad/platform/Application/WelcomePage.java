package com.upgrad.platform.Application;

import com.upgrad.platform.dto.User;
import com.upgrad.platform.exception.EmailNotValidException;
import com.upgrad.platform.exception.EmailValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomePage {
    private static WelcomePage welcome=null;
    private WelcomePage(){ }

    public static WelcomePage getInstance(){
        if(welcome==null){
            welcome=new WelcomePage();
        }
        return welcome;
    }
    static Scanner scanner=new Scanner(System.in);
    UpgradApplicationImpl upgrad=UpgradApplicationImpl.getInstance();



    public static void main(String[] args) throws EmailNotValidException{
        WelcomePage welcome=WelcomePage.getInstance();

        welcome.welcomePage();
    }
    public void welcomePage() throws EmailNotValidException{
        int option = 0;
        System.out.println();
        System.out.println("Welcome to the Upgrad discussion platform");
        System.out.println("Please choose your option");
        System.out.println("1. Login");
        System.out.println("2. Register");
        try{
            option=scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid Input. Please provide a valid input");
            scanner.next();
            welcomePage();
        }
        String emailId;
        String username;
        String password;
        boolean login=false;
        boolean register=false;
        User user=null;
         do{
            switch (option) {
                case 1:
                        System.out.println("PLease enter username");
                        username = scanner.next();
                        System.out.println("Please enter password");
                        password = scanner.next();
                        user=upgrad.login(username, password);
                        if(user==null){
                            welcomePage();
                        }
                        else if(user!=null)
                            login=true;
                        break;

                case 2:
                        System.out.println("PLease enter EmailId");
                        emailId = scanner.next();
                        EmailValidator.isEmailValid(emailId);
                        System.out.println("PLease enter username");
                        username = scanner.next();
                        System.out.println("Please enter password");
                        password = scanner.next();
                        user=upgrad.register(emailId, username, password);
                        if(user==null){
                            System.out.println("User with following email Id Already exist");
                            welcomePage();
                        }
                        else if(user!=null)
                            register=true;
                        break;
                default:
                        System.out.println("Please select a valid option");
                        welcomePage();
                        break;
            }
        }while (login==false && register==false);
        Homepage home=new Homepage();
        home.homePage(user);

    }


}
