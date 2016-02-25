package ru.swift.mvpwithdagger2.views.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import ru.swift.mvpwithdagger2.R;
import ru.swift.mvpwithdagger2.di.components.MainActivityComponent;
import ru.swift.mvpwithdagger2.models.User;
import ru.swift.mvpwithdagger2.presenters.implementations.UsersPresenterImpl;
import ru.swift.mvpwithdagger2.views.UsersView;
import ru.swift.mvpwithdagger2.views.adapters.UsersRvAdapter;


public class UsersFragment extends BaseFragment implements UsersView,
        UsersRvAdapter.OnUsersRvClickListener {

    @Inject
    UsersPresenterImpl mPresenter;

    public static final String TAG = "UsersFragment";
    private RecyclerView mRecyclerView;
    private UsersListener mUsersListener;

    public interface UsersListener {
        void onUserClicked(User user);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof UsersListener) {
            mUsersListener = (UsersListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvUsers);
        setProgressAndMainViews(progressBar, mRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(MainActivityComponent.class).inject(this);

        mPresenter.setView(this);
        mPresenter.getUsers();
    }

    @Override
    public void insertUsers(List<User> users) {
        UsersRvAdapter usersRvAdapter = new UsersRvAdapter(this, users);
        mRecyclerView.setAdapter(usersRvAdapter);
    }

    @Override
    public void showUserDetails(User user) {
        if (mUsersListener != null) {
            mUsersListener.onUserClicked(user);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUserItemClicked(User user) {
        mPresenter.onUserItemClicked(user);
    }
}
