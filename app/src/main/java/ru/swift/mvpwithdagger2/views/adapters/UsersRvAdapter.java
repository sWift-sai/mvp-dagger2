package ru.swift.mvpwithdagger2.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.swift.mvpwithdagger2.R;
import ru.swift.mvpwithdagger2.models.User;



public class UsersRvAdapter extends RecyclerView.Adapter<UsersRvAdapter.UsersViewHolder> {

    private OnUsersRvClickListener mOnUsersRvClickListener;
    private List<User> mUsers;

    public interface OnUsersRvClickListener {
            void onUserItemClicked(User user);
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTvUserName;

        public UsersViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

            mTvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
        }

        void fillItemView(User user) {
            mTvUserName.setText(user.getName());
        }

        @Override
        public void onClick(View v) {
            int itemPos = getLayoutPosition();
            mOnUsersRvClickListener.onUserItemClicked(mUsers.get(itemPos));
        }
    }

    public UsersRvAdapter(OnUsersRvClickListener listener, List<User> users) {
        mOnUsersRvClickListener = listener;
        mUsers = users;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new UsersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        holder.fillItemView(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

}
