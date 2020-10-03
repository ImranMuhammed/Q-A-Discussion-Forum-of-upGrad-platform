package com.upgrad.platform.Application;

import com.upgrad.platform.dataBase.DataBase;
import com.upgrad.platform.dto.Answers;
import com.upgrad.platform.dto.Questions;
import com.upgrad.platform.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UpgradApplicationImpl implements UpgradApplication {
    DataBase dataBase=DataBase.getInstance();
    Scanner scanner=new Scanner(System.in).useDelimiter("\n");

    public User login(String username, String password){
        User user=getUserByUsername(username);
        if(user==null){
            System.out.println("User with following username is not registered !!!");
            System.out.println("Please Register the user and try again !!!");
            return null;
        }
        else if(!user.getPassword().equals(password)){
            System.out.println("Incorrect Username or Password");
            return null;
        }
        else {
            System.out.println("User is Logged in successfully");
            return user;
        }
    }

    public User register(String emailId,String username,String password){
        User user=getUserByEmailId(emailId);
        if(user!=null){
            System.out.println("user is already registered");
            return null;
        }
        else{
            user=new User(emailId,username,password);
            dataBase.getAllUsersByEmailId().put(emailId,user);
            dataBase.getAllUsersByUsername().put(username,user);
            return user;
        }
    }

    public void askQuestion(User user,String question){
        if(question==null || question.length()==0){
            System.out.println("Question is null");
        }
        else{
            Questions newQuestion=new Questions(question,false,0,user);
            dataBase.getAllQuestions().add(newQuestion);
            user.getQuestionsAskedByUser().add(newQuestion);
            user.setTotalQuestionsAsked(user.getTotalQuestionsAsked()+1);
            System.out.println("Question is posted successfully");
        }

    }

    public void giveAnswer(User user ){
        if(dataBase.isQuestionBankEmpty()){
            System.out.println("No questions available in Database");
            return;
        }
        dataBase.displayAllQuestions();
        System.out.println("Please enter the question number to answer the question");
        int questionId=scanner.nextInt();
        System.out.println("Please enter the answer");
        String answer=scanner.next();
        if(questionId>dataBase.getAllQuestions().size()){
            System.out.println("Invalid Question Id Entered");
            return;
        }
        else if(answer==null || answer.length()==0){
            System.out.println("Empty answer cannot be added");
            return;
        }
        Questions question=dataBase.getAllQuestions().get(questionId-1);
        if(question.getQuestionOwner()==user){
            System.out.println("User cannot answer the question posted by himself");
        }
        else {
            Answers answers=new Answers(question,answer,false,user);
            if (!dataBase.getAllAnswers().containsKey(question)) {
                dataBase.getAllAnswers().put(question, new ArrayList<>());
            }
            dataBase.getAllAnswers().get(question).add(answers);
            user.setTotalQuestionsAnswered(user.getTotalQuestionsAnswered()+1);
            user.getAnswersGivenByUser().add(answers);
            question.setAnswersAdded(question.getAnswersAdded()+1);
            System.out.println("Answer is posted successfully");
        }
    }

    public void viewAndUpvoteQuestion(User user){
        if(dataBase.isQuestionBankEmpty()){
            System.out.println("No questions available in Database");
            return;
        }
        dataBase.displayAllQuestions();
        System.out.println("To upvote any Question please enter question Id OR enter 0 to return to HomePage");
        int questionId=scanner.nextInt();
        if(questionId==0){
            return;
        }
        if(questionId>dataBase.getAllQuestions().size()){
            System.out.println("Invalid Question Id Entered");
            return;
        }
        Questions question=dataBase.getAllQuestions().get(questionId-1);
        if(question.getQuestionOwner()==user){
            System.out.println("User cannot upvote a question posted by himself");
        }
        else if(user.getUpvotedQuestion().contains(question)){
            System.out.println("Question has been already upvoted by the user");
        }
        else{
            user.getUpvotedQuestion().add(question);
            user.setTotalResponseAdded(user.getTotalResponseAdded()+1);
            question.setUpVoteQuestionCount(question.getUpVoteQuestionCount()+1);
            System.out.println("Question is upvoted successfully");
        }

    }

    public  void viewAndUpvoteAnswer(User user){
        if(dataBase.isQuestionBankEmpty()){
            System.out.println("No questions available in Database");
            return;
        }
        dataBase.displayAllQuestions();
        System.out.println("Please enter the question number to view the answers");
        int questionId=scanner.nextInt();
        if(questionId>dataBase.getAllQuestions().size()){
            System.out.println("Invalid question Id is selected");
            return;
        }
        Questions question=dataBase.getAllQuestions().get(questionId-1);

        if(!dataBase.getAllAnswers().containsKey(question)){
            System.out.println("No answers available for the selected question");
            return;
        }
        int answerId=0;
        for(Answers answer:dataBase.getAllAnswers().get(question)){
            System.out.println((answerId++)+" . "+answer.getAnswer());
        }
        System.out.println("To upvote any Answer please enter answer Id OR enter 0 to return to HomePage");
         answerId=scanner.nextInt();
        if(answerId<=0 || answerId>dataBase.getAllAnswers().get(question).size()){
            System.out.println("Invalid answer Id selected");
            return;
        }
        else{
            Answers answers=dataBase.getAllAnswers().get(question).get(answerId-1);
            if(answers.getanswerOwner()==user){
                System.out.println("User cannot upvote the answer given by himself");
                return;
            }
            else if(user.getUpvotedAnswers().contains(answers)){
                System.out.println("The Answer is already upvoted by the user");
                return;
            }
            else {
                user.getUpvotedAnswers().add(answers);
                user.setTotalResponseAdded(user.getTotalResponseAdded()+1);
                answers.setUpvoteAnswerCount(answers.getUpvoteAnswerCount()+1);
                System.out.println("Answer is upvoted successfully");
                return;
            }
        }

    }

    public void userProfileDetails(User user){
        if(user==null){
            System.out.println("User does not exist");
        }
        else{
            System.out.println(user);
        }
    }

    public  User getUserByUsername(String username){
        if(dataBase.getAllUsersByUsername().containsKey(username))
            return dataBase.getAllUsersByUsername().get(username);
        else
            return null;
    }

    public  User getUserByEmailId(String emailId){
        if(dataBase.getAllUsersByEmailId().containsKey(emailId))
            return dataBase.getAllUsersByEmailId().get(emailId);
        else
            return null;
    }


}
