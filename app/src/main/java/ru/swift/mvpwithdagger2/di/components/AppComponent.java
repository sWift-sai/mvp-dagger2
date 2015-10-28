package ru.swift.mvpwithdagger2.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.swift.mvpwithdagger2.app.MyApp;
import ru.swift.mvpwithdagger2.di.modules.AppModule;


@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {
    void inject(MyApp app);
}
