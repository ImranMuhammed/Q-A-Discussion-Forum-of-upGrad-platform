package com.upgrad.platform.dto;

public class Questions {

    private String question;
    private boolean upvoteQuestion;
    private int upVoteQuestionCount;
    private User questionOwner;
    private int answersAdded;

    public Questions(String question, boolean upvoteQuestion, int upVoteQuestionCount, User questionOwner) {
        this.question = question;
        this.upvoteQuestion = upvoteQuestion;
        this.upVoteQuestionCount = upVoteQuestionCount;
        this.questionOwner = questionOwner;
        this.answersAdded=0;
    }

    public int getAnswersAdded() {
        return answersAdded;
    }

    public void setAnswersAdded(int answersAdded) {
        this.answersAdded = answersAdded;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isUpvoteQuestion() {
        return upvoteQuestion;
    }

    public void setUpvoteQuestion(boolean upvoteQuestion) {
        this.upvoteQuestion = upvoteQuestion;
    }

    public int getUpVoteQuestionCount() {
        return upVoteQuestionCount;
    }

    public void setUpVoteQuestionCount(int upVoteQuestionCount) {
        this.upVoteQuestionCount = upVoteQuestionCount;
    }

    public User getQuestionOwner() {
        return questionOwner;
    }

    public void setQuestionOwner(User questionOwner) {
        this.questionOwner = questionOwner;
    }
}

