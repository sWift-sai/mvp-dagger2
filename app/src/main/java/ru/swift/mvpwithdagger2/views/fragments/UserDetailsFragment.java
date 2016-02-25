package ru.swift.mvpwithdagger2.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import javax.inject.Inject;

import ru.swift.mvpwithdagger2.R;
import ru.swift.mvpwithdagger2.di.components.MainActivityComponent;
import ru.swift.mvpwithdagger2.models.User;
import ru.swift.mvpwithdagger2.models.UserDetails;
import ru.swift.mvpwithdagger2.presenters.implementations.UserDetailsPresenterImpl;
import ru.swift.mvpwithdagger2.views.UserDetailsView;


public class UserDetailsFragment extends BaseFragment implements UserDetailsView {

    @Inject
    UserDetailsPresenterImpl mPresenter;

    public static final String TAG = "UserDetailsFragment";
    public static final String KEY_USER_ID = "userId";
    private TextView mTvUserName;
    private TextView mTvUserDescription;

    public static UserDetailsFragment newInstance(User user) {
        UserDetailsFragment f = new UserDetailsFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_USER_ID, user.getId());
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);

        mTvUserName = (TextView) view.findViewById(R.id.tvUserName);
        mTvUserDescription = (TextView) view.findViewById(R.id.tvUserDescription);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.svUserDetails);
        setProgressAndMainViews(progressBar, scrollView);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(MainActivityComponent.class).inject(this);
        mPresenter.setView(this);

        int userId = getArguments().getInt(KEY_USER_ID);
        mPresenter.getUserDetails(userId);
    }

    @Override
    public void setUserDetails(UserDetails userDetails) {
        mTvUserName.setText(userDetails.getName());
        mTvUserDescription.setText(userDetails.getDescription());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }
}
