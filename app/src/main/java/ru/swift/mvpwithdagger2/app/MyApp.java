package ru.swift.mvpwithdagger2.app;

import android.app.Application;
import android.content.Context;

import ru.swift.mvpwithdagger2.di.components.AppComponent;
import ru.swift.mvpwithdagger2.di.components.DaggerAppComponent;
import ru.swift.mvpwithdagger2.di.modules.AppModule;


public class MyApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();
    }

    public void buildGraphAndInject() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
