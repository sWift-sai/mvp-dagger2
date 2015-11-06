package ru.swift.mvpwithdagger2.domain.listeners;


import java.util.List;

import ru.swift.mvpwithdagger2.models.User;

public interface UsersInteractorListener {

    void onUsersGettingSuccess(List<User> users);

    void onUsersGettingFailure(Throwable error);
}