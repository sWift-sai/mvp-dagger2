package ru.swift.mvpwithdagger2.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ru.swift.mvpwithdagger2.app.MyApp;
import ru.swift.mvpwithdagger2.di.components.AppComponent;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpComponent(MyApp.get(this).getAppComponent());
    }

    protected abstract void setUpComponent(AppComponent appComponent);
}
