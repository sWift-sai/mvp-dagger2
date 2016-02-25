package ru.swift.mvpwithdagger2.di.components;

import dagger.Component;
import ru.swift.mvpwithdagger2.di.ActivityScope;
import ru.swift.mvpwithdagger2.di.modules.MainActivityModule;
import ru.swift.mvpwithdagger2.views.activities.MainActivity;
import ru.swift.mvpwithdagger2.views.fragments.UserDetailsFragment;
import ru.swift.mvpwithdagger2.views.fragments.UsersFragment;


@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(UsersFragment usersFragment);
    void inject(UserDetailsFragment userDetailsfragment);
}
