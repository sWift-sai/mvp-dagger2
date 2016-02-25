package ru.swift.mvpwithdagger2.presenters;

import ru.swift.mvpwithdagger2.views.UserDetailsView;


public interface UserDetailsPresenter extends BaseFragmentPresenter<UserDetailsView> {
    void getUserDetails(int userId);
}
