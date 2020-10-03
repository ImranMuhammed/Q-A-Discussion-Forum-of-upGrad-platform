package com.upgrad.platform.dto;

public class Answers {
    private String answer;
    private boolean upvoteAnswer;
    private int upvoteAnswerCount;
    private User answerOwner;
    private Questions question;

    public Answers(Questions question ,String answer, boolean upvoteAnswer,  User answerOwner) {
        this.question=question;
        this.answer = answer;
        this.upvoteAnswer = upvoteAnswer;
        this.upvoteAnswerCount = 0;
        this.answerOwner = answerOwner;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isUpvoteAnswer() {
        return upvoteAnswer;
    }

    public void setUpvoteAnswer(boolean upvoteAnswer) {
        this.upvoteAnswer = upvoteAnswer;
    }

    public int getUpvoteAnswerCount() {
        return upvoteAnswerCount;
    }

    public void setUpvoteAnswerCount(int upvoteAnswerCount) {
        this.upvoteAnswerCount = upvoteAnswerCount;
    }

    public User getanswerOwner() {
        return answerOwner;
    }

    public void setanswerOwner(User user) {
        this.answerOwner = answerOwner;
    }
}
