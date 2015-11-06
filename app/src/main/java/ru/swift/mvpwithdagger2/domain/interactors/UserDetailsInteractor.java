package ru.swift.mvpwithdagger2.domain.interactors;

import ru.swift.mvpwithdagger2.domain.listeners.UserDetailsInteractorListener;

public interface UserDetailsInteractor {
    void getUserDetails(UserDetailsInteractorListener listener, int userId);
}
