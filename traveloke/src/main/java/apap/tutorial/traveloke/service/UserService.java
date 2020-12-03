package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel getUserByUsername(String username);
    boolean matchPassword(String newPassword, String oldPassword);
    boolean checkPassword(String password);
}
