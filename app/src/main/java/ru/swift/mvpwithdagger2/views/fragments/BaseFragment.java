package ru.swift.mvpwithdagger2.views.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import ru.swift.mvpwithdagger2.di.HasComponent;
import ru.swift.mvpwithdagger2.views.ProgressView;


public abstract class BaseFragment extends Fragment implements ProgressView {
    private ProgressBar mProgressBar;
    private View mMainView;

    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }

    // Should be called when creating view
    protected void setProgressAndMainViews(ProgressBar progressBar, View mainView) {
        mProgressBar = progressBar;
        mMainView = mainView;
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mMainView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mMainView.setVisibility(View.VISIBLE);
    }
}
