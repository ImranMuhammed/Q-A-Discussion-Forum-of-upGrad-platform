package com.upgrad.platform.Application;

import com.upgrad.platform.dto.User;

public interface UpgradApplication {

    public User login(String username, String password);

    public User register(String emailId,String username,String password);

    public void askQuestion(User user, String question);

    public void giveAnswer(User user);

    public void viewAndUpvoteQuestion(User user);

    public  void viewAndUpvoteAnswer(User user);

    public void userProfileDetails(User user);
}
