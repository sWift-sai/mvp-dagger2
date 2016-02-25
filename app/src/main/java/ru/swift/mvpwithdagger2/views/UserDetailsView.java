package ru.swift.mvpwithdagger2.views;

import ru.swift.mvpwithdagger2.models.UserDetails;


public interface UserDetailsView extends ProgressView {

    void setUserDetails(UserDetails userDetails);

    void showError(String error);
}
