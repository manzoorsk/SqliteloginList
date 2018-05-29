package com.mahabooda.sqlitelogin;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mahabooda.sqlitelogin.models.User;

import java.util.ArrayList;
import java.util.List;

//public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {
//
//    private List<User> listUsers;
//
//    public UsersRecyclerAdapter(List<User> listUsers) {
//        this.listUsers = listUsers;
//    }
//
//    @Override
//    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // inflating recycler item view
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_user_recycler, parent, false);
//
//        return new UserViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(UserViewHolder holder, int position) {
//        holder.textViewName.setText(listUsers.get(position).getName());
//        holder.textViewEmail.setText(listUsers.get(position).getEmail());
//        holder.textViewPassword.setText(listUsers.get(position).getPassword());
//    }
//
//    @Override
//    public int getItemCount() {
//        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
//        return listUsers.size();
//    }
//
//
//    /**
//     * ViewHolder class
//     */
//    public class UserViewHolder extends RecyclerView.ViewHolder {
//
//        public AppCompatTextView textViewName;
//        public AppCompatTextView textViewEmail;
//        public AppCompatTextView textViewPassword;
//
//        public UserViewHolder(View view) {
//            super(view);
//            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
//            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
//            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
//        }
//    }
//}

public class UsersRecyclerAdapter extends ArrayAdapter<User> {
    public UsersRecyclerAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user_recycler, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.textViewEmail);
        // Populate the data into the template view using the data object
        tvName.setText(user.getEmail());
        tvHome.setText(user.getName());
        // Return the completed view to render on screen
        return convertView;
    }
}