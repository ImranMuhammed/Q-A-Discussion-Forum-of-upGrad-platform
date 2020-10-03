package com.upgrad.platform.Application;

import com.upgrad.platform.dto.User;

import java.util.Scanner;

public class WelcomePage {
    static Scanner scanner=new Scanner(System.in);
    UpgradApplicationImpl upgrad=new UpgradApplicationImpl();

    public static void main(String[] args) {
        WelcomePage welcome=new WelcomePage();
        welcome.welcomePage( welcome);
    }
    public void welcomePage(WelcomePage welcome){
        int option;
        System.out.println();
        System.out.println("Welcome to the Upgrad discussion platform");
        System.out.println("Please choose your option");
        System.out.println("1. Login");
        System.out.println("2. Register");
        option=scanner.nextInt();
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
                            welcomePage(welcome);
                        }
                        else if(user!=null)
                            login=true;
                        break;

                case 2:
                        System.out.println("PLease enter EmailId");
                        emailId = scanner.next();
                        System.out.println("PLease enter username");
                        username = scanner.next();
                        System.out.println("Please enter password");
                        password = scanner.next();
                        user=upgrad.register(emailId, username, password);
                        if(user==null){
                            System.out.println("User with following email Id Already exist");
                            welcomePage(welcome);
                        }
                        else if(user!=null)
                            register=true;
                        break;
                default:
                        System.out.println("Please select a valid option");
                        welcomePage(welcome);
                        break;
            }
        }while (login==false && register==false);
        Homepage home=new Homepage();
        home.homePage(upgrad,welcome,user);

    }
}
