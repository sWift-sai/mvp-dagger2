package ru.swift.mvpwithdagger2.domain.interactors;


import ru.swift.mvpwithdagger2.domain.listeners.UsersInteractorListener;

public interface UsersInteractor {
    void getUsers(UsersInteractorListener listener);
}
