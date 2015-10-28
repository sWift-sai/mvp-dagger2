package ru.swift.mvpwithdagger2.presenters.implementations;

import javax.inject.Inject;

import ru.swift.mvpwithdagger2.interactors.UserDetailsInteractor;
import ru.swift.mvpwithdagger2.interactors.implementations.UserDetailsInteractorImpl;
import ru.swift.mvpwithdagger2.listeners.UserDetailsInteractorListener;
import ru.swift.mvpwithdagger2.models.UserDetails;
import ru.swift.mvpwithdagger2.presenters.UserDetailsPresenter;
import ru.swift.mvpwithdagger2.views.UserDetailsView;


public class UserDetailsPresenterImpl implements UserDetailsPresenter, UserDetailsInteractorListener {

    private UserDetailsView mView;
    private UserDetailsInteractor mInteractor;

    @Inject
    public UserDetailsPresenterImpl(UserDetailsInteractorImpl interactor) {
        mInteractor = interactor;
    }

    @Override
    public void setView(UserDetailsView view) {
        mView = view;
    }

    @Override
    public void getUserDetails(int userId) {
        mInteractor.getUserDetails(this, userId);
        mView.showProgress();
    }

    @Override
    public void onUserDetailsGettingSuccess(UserDetails userDetails) {
        mView.setUserDetails(userDetails);
        mView.hideProgress();
    }

    @Override
    public void onUserDetailsGettingFailure(Throwable error) {
        mView.showError(error.getMessage());
        mView.hideProgress();
    }
}
