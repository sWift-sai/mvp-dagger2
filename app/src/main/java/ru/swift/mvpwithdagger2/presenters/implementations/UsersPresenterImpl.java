package ru.swift.mvpwithdagger2.presenters.implementations;

import java.util.List;

import javax.inject.Inject;

import ru.swift.mvpwithdagger2.interactors.UsersInteractor;
import ru.swift.mvpwithdagger2.interactors.implementations.UsersInteractorImpl;
import ru.swift.mvpwithdagger2.listeners.UsersInteractorListener;
import ru.swift.mvpwithdagger2.models.User;
import ru.swift.mvpwithdagger2.presenters.UsersPresenter;
import ru.swift.mvpwithdagger2.views.UsersView;


public class UsersPresenterImpl implements UsersPresenter, UsersInteractorListener {

    private UsersView mView;
    private UsersInteractorImpl mInteractor;
    private List<User> mUsers;

    @Inject
    public UsersPresenterImpl(UsersInteractorImpl interactor) {
        mInteractor = interactor;
    }

    @Override
    public void setView(UsersView view) {
        mView = view;
    }

    @Override
    public void getUsers() {
        if (mUsers == null) {
            mView.showProgress();
            mInteractor.getUsers(this);
        } else {
            mView.insertUsers(mUsers);
            mView.hideProgress();
        }
    }

    @Override
    public void onUserItemClicked(User user) {
        mView.showUserDetails(user);
    }

    @Override
    public void onUsersGettingSuccess(List<User> users) {
        mUsers = users;
        mView.insertUsers(users);
        mView.hideProgress();
    }

    @Override
    public void onUsersGettingFailure(Throwable error) {
        mView.showError(error.getMessage());
        mView.hideProgress();
    }
}
