package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabase.utils.database.Database;
import com.example.roomdatabase.utils.model.Users;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UsersListAdapter adapter;
    private RecyclerView recyclerView;
    private TextView name, salary, mobile, date, designation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        designation = findViewById(R.id.designation);
        date = findViewById(R.id.date);
        mobile = findViewById(R.id.mobile);
        recyclerView = findViewById(R.id.listView);

        setupAdapter();

        String userName = getIntent().getStringExtra("Name");

        new Task(getBaseContext()).execute("Single", userName);
        new Task(getBaseContext()).execute("List", userName);
    }

    private void setupAdapter() {
        adapter = new UsersListAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {
    }


    class Task extends AsyncTask<String, Void, Object> {

        Context context;

        Task(Context context){
            this.context = context;
        }

        @Override
        protected Object doInBackground(String... voids) {
            if(voids[0].equals("Single")){
                return Database.getInstance(getBaseContext()).getUser(voids[1]);
            }
            else if(voids[0].equals("List")){
                return Database.getInstance(getBaseContext()).getUsers();
            }
            return "false";
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            if(o != null){
                if(o instanceof Users){
                    Users users = (Users) o;
                    name.setText(users.getName());
                    salary.setText(users.getSalary());
                    designation.setText(users.getDesignation());
                    date.setText(users.getDate());
                    mobile.setText(users.getMobile());
                }
                else if(o instanceof List){
                    List<Users> users = (List<Users>) o;
                    adapter.addData(users);
                }
                else {
                    showToast("Error");
                }
            }
            else{
                showToast("Failure");
            }
        }
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
