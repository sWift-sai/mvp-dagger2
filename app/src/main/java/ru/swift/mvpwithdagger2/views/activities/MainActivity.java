package ru.swift.mvpwithdagger2.views.activities;


import android.os.Bundle;

import ru.swift.mvpwithdagger2.R;
import ru.swift.mvpwithdagger2.di.HasComponent;
import ru.swift.mvpwithdagger2.di.components.AppComponent;
import ru.swift.mvpwithdagger2.di.components.DaggerMainActivityComponent;
import ru.swift.mvpwithdagger2.di.components.MainActivityComponent;
import ru.swift.mvpwithdagger2.di.modules.MainActivityModule;
import ru.swift.mvpwithdagger2.models.User;
import ru.swift.mvpwithdagger2.views.fragments.UserDetailsFragment;
import ru.swift.mvpwithdagger2.views.fragments.UsersFragment;



public class MainActivity extends BaseActivity implements UsersFragment.UsersListener,
        HasComponent<MainActivityComponent> {

    private MainActivityComponent mMainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            openUsersFragment();
        }
    }

    @Override
    protected void setUpComponent(AppComponent appComponent) {
        mMainActivityComponent = DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule())
                .build();
        mMainActivityComponent.inject(this);
    }

    @Override
    public MainActivityComponent getComponent() {
        return mMainActivityComponent;
    }

    private void openUsersFragment() {
        UsersFragment usersFragment = new UsersFragment();

        getSupportFragmentManager().beginTransaction()
        .add(R.id.mainFragmentContainer, usersFragment, UsersFragment.TAG)
        .commit();
    }

    @Override
    public void onUserClicked(User user) {
        UserDetailsFragment userDetailsFragment = UserDetailsFragment.newInstance(user);

        getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainFragmentContainer, userDetailsFragment, UserDetailsFragment.TAG)
        .addToBackStack(null)
        .commit();
    }

}
