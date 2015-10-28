package ru.swift.mvpwithdagger2.interactors;

import ru.swift.mvpwithdagger2.listeners.UserDetailsInteractorListener;

public interface UserDetailsInteractor {
    void getUserDetails(UserDetailsInteractorListener listener, int userId);
}
