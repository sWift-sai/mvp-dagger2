package ru.swift.mvpwithdagger2.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.swift.mvpwithdagger2.app.MyApp;


@Module
public class AppModule {
    private final MyApp mApp;

    public AppModule(MyApp app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Application provideApp() {
        return mApp;
    }
}
