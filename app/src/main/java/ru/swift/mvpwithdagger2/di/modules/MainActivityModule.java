package ru.swift.mvpwithdagger2.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.swift.mvpwithdagger2.di.ActivityScope;
import ru.swift.mvpwithdagger2.interactors.UserDetailsInteractor;
import ru.swift.mvpwithdagger2.interactors.implementations.UserDetailsInteractorImpl;
import ru.swift.mvpwithdagger2.interactors.implementations.UsersInteractorImpl;
import ru.swift.mvpwithdagger2.presenters.implementations.UserDetailsPresenterImpl;
import ru.swift.mvpwithdagger2.presenters.implementations.UsersPresenterImpl;



@Module
public class MainActivityModule {

    @ActivityScope
    @Provides
    public UsersPresenterImpl provideUsersPresenterImpl(UsersInteractorImpl interactor) {
        return new UsersPresenterImpl(interactor);
    }

    @ActivityScope
    @Provides
    public UsersInteractorImpl provideUsersInteractorImpl() {
        return new UsersInteractorImpl();
    }


    @ActivityScope
    @Provides
    public UserDetailsPresenterImpl provideUserDetailsPresenterImpl(UserDetailsInteractorImpl interactor) {
        return new UserDetailsPresenterImpl(interactor);
    }

    @ActivityScope
    @Provides
    public UserDetailsInteractorImpl provideUserDetailsInteractorImpl() {
        return new UserDetailsInteractorImpl();
    }
}
