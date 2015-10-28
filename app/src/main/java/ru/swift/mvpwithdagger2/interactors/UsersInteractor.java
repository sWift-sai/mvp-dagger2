package ru.swift.mvpwithdagger2.interactors;


import ru.swift.mvpwithdagger2.listeners.UsersInteractorListener;

public interface UsersInteractor {
    void getUsers(UsersInteractorListener listener);
}
