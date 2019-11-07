package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.utils.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {

    private List<Users> list;

    public UsersListAdapter(){
        list = new ArrayList<>();
    }

    public void addData(List<Users> list) {
        this.list.clear();
        this.list.addAll(list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_user_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);

        holder.name.setText(users.getName());
        holder.salary.setText(users.getSalary());
        holder.designation.setText(users.getDesignation());
        holder.date.setText(users.getDate());
        holder.mobile.setText(users.getMobile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, salary, mobile, date, designation;

        public ViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            salary = view.findViewById(R.id.salary);
            designation = view.findViewById(R.id.designation);
            date = view.findViewById(R.id.date);
            mobile = view.findViewById(R.id.mobile);
        }
    }
}
