package com.yudiasmara2355201568.yudiasmara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registers extends AppCompatActivity {

    private EditText etName,etUsername, etEmail, etPassword, etReEnterPassword;
    private Button btnRegister, btnLogin;

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);

        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etReEnterPassword = findViewById(R.id.etReEnterPassword);
        btnRegister = findViewById(R.id.btnSimpan);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://yudiasmara-default-rtdb.firebaseio.com/");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String reenterpassword = etReEnterPassword.getText().toString();
                
                if (!password.equals(reenterpassword)){
                    Toast.makeText(getApplicationContext(), "Password Belum Benar", Toast.LENGTH_SHORT).show();
                } else if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                } else {
                    database = FirebaseDatabase.getInstance().getReference("users");
                    database.child(username).child("name").setValue(name);
                    database.child(username).child("username").setValue(username);
                    database.child(username).child("email").setValue(email);
                    database.child(username).child("password").setValue(password);

                    Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), Login.class);
                    startActivity(register);
                }
            }
        });

    }

    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}