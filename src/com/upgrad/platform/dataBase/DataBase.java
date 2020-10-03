package com.upgrad.platform.dataBase;

import com.upgrad.platform.dto.Answers;
import com.upgrad.platform.dto.Questions;
import com.upgrad.platform.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {

    private HashMap<String,User> allUsersByUsername;
    private HashMap<String,User> allUsersByEmailId;
    private List<Questions> allQuestions;
    private HashMap<Questions,List<Answers>> allAnswers;

    private DataBase() {
        this.allUsersByUsername = new HashMap<>();
        this.allUsersByEmailId=new HashMap<>();
        this.allQuestions = new ArrayList<>();
        this.allAnswers=new HashMap<>();
    }
    private static DataBase instance;
    public static DataBase getInstance(){
        if(instance==null){
            instance=new DataBase();
        }
        return instance;
    }

    public HashMap<String, User> getAllUsersByUsername() {
        return allUsersByUsername;
    }

    public void setAllUsersByUsername(HashMap<String, User> allUsersByUsername) {
        this.allUsersByUsername = allUsersByUsername;
    }

    public HashMap<String, User> getAllUsersByEmailId() {
        return allUsersByEmailId;
    }

    public void setAllUsersByEmailId(HashMap<String, User> allUsersByEmailId) {
        this.allUsersByEmailId = allUsersByEmailId;
    }

    public List<Questions> getAllQuestions() {
        return allQuestions;
    }

    public HashMap<Questions, List<Answers>> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(HashMap<Questions, List<Answers>> allAnswers) {
        this.allAnswers = allAnswers;
    }

    public boolean isQuestionBankEmpty(){
        if(allQuestions.size()==0 || allQuestions==null){
            return true;
        }
        return false;
    }

    public void displayAllQuestions(){
        System.out.println("Questions\t\t:\t\tNumberOfAnswers\t:\t CountOfUpvotes ");
        for(int i=0;i<getAllQuestions().size();i++){
            Questions question= getAllQuestions().get(i);
            System.out.println((i+1)+" . "+question.getQuestion()+" : "+question.getAnswersAdded()+" : "
                    +question.getUpVoteQuestionCount());
        }
    }
}
