package ru.swift.mvpwithdagger2.domain.interactors.implementations;


import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import ru.swift.mvpwithdagger2.domain.interactors.UsersInteractor;
import ru.swift.mvpwithdagger2.domain.listeners.UsersInteractorListener;
import ru.swift.mvpwithdagger2.models.User;

public class UsersInteractorImpl implements UsersInteractor {
    /*
        @Inject
        @ActivityScope
        public UsersInteractorImpl() {
        }
    */
    @Override
    public void getUsers(final UsersInteractorListener listener) {
        // TODO: Temp. Retrofit call will be implemented here!
        final List<User> users = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            User user = new User();
            user.setId(i+1);
            user.setName("User " + String.valueOf(i+1));
            users.add(user);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onUsersGettingSuccess(users);
            }
        }, 2000);

    }
}
