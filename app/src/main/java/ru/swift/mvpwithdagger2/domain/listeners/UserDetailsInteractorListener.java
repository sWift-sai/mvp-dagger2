package ru.swift.mvpwithdagger2.domain.listeners;


import ru.swift.mvpwithdagger2.models.UserDetails;

public interface UserDetailsInteractorListener {

    void onUserDetailsGettingSuccess(UserDetails userDetails);

    void onUserDetailsGettingFailure(Throwable error);
}