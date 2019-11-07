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

public class LoginActivity extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.name);
    }


    public void onClick(View view) {
        if(view.getId() == R.id.login){
            String _name = name.getText().toString();

            if(_name.isEmpty()){
                showToast("enter name");
                return;
            }

            new Task(getBaseContext()).execute("Reg", _name);
        }
        else if(view.getId() == R.id.cancel){
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            finish();
        }
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class Task extends AsyncTask<String, Void, Object>{

        Context context;
        String name;

        Task(Context context){
            this.context = context;
        }

        @Override
        protected Object doInBackground(String... voids) {
            if(voids[0].equals("Reg")){
                name = voids[1];
                if(Database.getInstance(context).getUser(name) != null){
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

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("Name", name);
                startActivity(intent);
                finish();
            }
            else{
                showToast("Failure");
            }
        }
    }
}
