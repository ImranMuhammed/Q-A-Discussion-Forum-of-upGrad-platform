package com.upgrad.platform.Application;

import com.upgrad.platform.dataBase.DataBase;
import com.upgrad.platform.dto.User;

import java.util.Scanner;

public class Homepage {
    static Scanner scanner=new Scanner(System.in).useDelimiter("\n");
    public void homePage(UpgradApplicationImpl upgrad, WelcomePage welcome, User user){
        DataBase dataBase=DataBase.getInstance();
        int option=0;
        do {
            System.out.println("Please select an Option");
            System.out.println(" 1 . Ask a Question");
            System.out.println(" 2 . Answer a Question");
            System.out.println(" 3 . View and Upvote a question");
            System.out.println(" 4 . View and Upvote an Answer");
            System.out.println(" 5 . User profile");
            System.out.println(" 6 . Logout");
            option=scanner.nextInt();
            String username;
            int questionId;
            switch (option){
                case 1 :
                        System.out.println("Enter a question");
                        String question=scanner.next();
                        upgrad.askQuestion(user,question);
                        break;

                case 2 :
                        upgrad.giveAnswer(user);
                        break;
                case 3 :
                        upgrad.viewAndUpvoteQuestion(user);
                        break;

                case  4 :
                         upgrad.viewAndUpvoteAnswer(user);
                         break;

                case 5 :
                        upgrad.userProfileDetails(user);
                        break;
                case 6 :
                default:
                        System.out.println("Thank you for using Upgrad Question and ANswer platform.");
                        System.out.println("You have been Logged out successfully");
                        welcome.welcomePage(welcome);
                        break;
            }
        }while(option>=1 && option<=7);

    }
}
