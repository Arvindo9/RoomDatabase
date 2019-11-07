package com.example.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdatabase.utils.database.Database;
import com.example.roomdatabase.utils.model.Users;

public class RegistrationActivity extends AppCompatActivity {

    private EditText name;
    private EditText salary;
    private EditText designation;
    private EditText data;
    private EditText mobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.name);
        salary = findViewById(R.id.salary);
        designation = findViewById(R.id.designation);
        data = findViewById(R.id.date);
        mobile = findViewById(R.id.mobile);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.login){
            String _name = name.getText().toString();
            String _salary = salary.getText().toString();
            String _designation = designation.getText().toString();
            String _data = data.getText().toString();
            String _mobile = mobile.getText().toString();

            if(_name.isEmpty()){
                showToast("enter name");
                return;
            }
            if(_salary.isEmpty()){
                showToast("enter salary");
                return;
            }
            if(_designation.isEmpty()){
                showToast("enter designation");
                return;
            }
            if(_data.isEmpty()){
                showToast("enter date");
                return;
            }
            if(_mobile.isEmpty()){
                showToast("enter mobile");
                return;
            }

            Users users = new Users(_name, _salary, _designation, _data, _mobile);

            new Task(getBaseContext(), users).execute("Reg");
/*
            if(Database.getInstance(getBaseContext()).saveUsers(users)){
                showToast("Success");
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                finish();
            }
            */
        }
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class Task extends AsyncTask<String, Void, Object> {

        Context context;
        private Users users;

        Task(Context context, Users users){
            this.context = context;
            this.users = users;
        }

        @Override
        protected Object doInBackground(String... voids) {
            if(voids[0].equals("Reg")){
                if(Database.getInstance(getBaseContext()).saveUsers(users)){
                    return "true";
                }
            }
            return "false";
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            String s = (String) o;
            if(s.equals("true")){
                showToast("Success");
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                finish();
            }
            else{
                showToast("Failure");
            }
        }
    }
}
