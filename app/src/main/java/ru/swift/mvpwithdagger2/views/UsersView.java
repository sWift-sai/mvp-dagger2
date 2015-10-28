package ru.swift.mvpwithdagger2.views;

import java.util.List;

import ru.swift.mvpwithdagger2.models.User;


public interface UsersView extends ProgressView {

    void insertUsers(List<User> items);

    void showUserDetails(User medicine);

    void showError(String error);
}
