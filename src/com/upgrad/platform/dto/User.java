package com.upgrad.platform.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String emailId;
    private String password;
    private String username;
    private List<Questions> questionsAskedByUser;
    private List<Answers> answersGivenByUser;
    private List<Questions> upvotedQuestion;
    private List<Answers> upvotedAnswers;
    private int totalQuestionsAsked;
    private int totalQuestionsAnswered;
    private int totalResponseAdded=0;


    public User(String emailId, String username, String password) {
        this.emailId = emailId;
        this.password = password;
        this.username = username;
        this.questionsAskedByUser=new ArrayList<>();
        this.answersGivenByUser=new ArrayList<>();
        this.totalQuestionsAnswered=0;
        this.totalQuestionsAsked=0;
        this.totalResponseAdded=0;
        this.upvotedQuestion=new ArrayList<>();
        this.upvotedAnswers=new ArrayList<>();
    }

    public List<Answers> getUpvotedAnswers() {
        return upvotedAnswers;
    }

    public void setUpvotedAnswers(List<Answers> upvotedAnswers) {
        this.upvotedAnswers = upvotedAnswers;
    }

    public List<Questions> getUpvotedQuestion() {
        return upvotedQuestion;
    }

    public void setUpvotedQuestion(List<Questions> upvotedQuestion) {
        this.upvotedQuestion = upvotedQuestion;
    }

    public int getTotalResponseAdded() {
        return totalResponseAdded;
    }

    public void setTotalResponseAdded(int totalResponseAdded) {
        this.totalResponseAdded = totalResponseAdded;
    }

    public int getTotalQuestionsAsked() {
        return totalQuestionsAsked;
    }

    public void setTotalQuestionsAsked(int totalQuestionsAsked) {
        this.totalQuestionsAsked = totalQuestionsAsked;
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    public List<Answers> getAnswersGivenByUser() {
        return answersGivenByUser;
    }

    public void setAnswersGivenByUser(List<Answers> answersGivenByUser) {
        this.answersGivenByUser = answersGivenByUser;
    }

    public List<Questions> getQuestionsAskedByUser() {
        return questionsAskedByUser;
    }

    public void setQuestionsAskedByUser(List<Questions> questionsAskedByUser) {
        this.questionsAskedByUser = questionsAskedByUser;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailId='" + emailId + "\n" +
                ", username='" + username + "\n" +
                ", totalQuestionsAsked=" + totalQuestionsAsked + "\n" +
                ", totalQuestionsAnswered=" + totalQuestionsAnswered + "\n"+
                ", totalUpvotedQuestionsAndAnswers=" + totalResponseAdded +"\n"+
                '}';
    }
}
