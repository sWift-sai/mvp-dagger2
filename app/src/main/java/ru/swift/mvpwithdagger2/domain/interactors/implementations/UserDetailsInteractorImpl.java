package ru.swift.mvpwithdagger2.domain.interactors.implementations;


import android.os.Handler;

import javax.inject.Inject;

import ru.swift.mvpwithdagger2.domain.listeners.UserDetailsInteractorListener;
import ru.swift.mvpwithdagger2.domain.interactors.UserDetailsInteractor;
import ru.swift.mvpwithdagger2.models.UserDetails;

public class UserDetailsInteractorImpl implements UserDetailsInteractor {

    @Inject
    public UserDetailsInteractorImpl() {
    }

    @Override
    public void getUserDetails(final UserDetailsInteractorListener listener, int userId) {
        // TODO: Temp. Retrofit call will be implemented here!
        final UserDetails userDetails = new UserDetails();
        userDetails.setId(userId);
        userDetails.setName("User " + userId);
        userDetails.setDescription("Description of user " + userId);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onUserDetailsGettingSuccess(userDetails);
            }
        }, 2000);
    }
}
