package ru.swift.mvpwithdagger2.presenters;

import ru.swift.mvpwithdagger2.models.User;
import ru.swift.mvpwithdagger2.views.UsersView;


public interface UsersPresenter extends BaseFragmentPresenter<UsersView> {
    void getUsers();

    void onUserItemClicked(User user);
}
