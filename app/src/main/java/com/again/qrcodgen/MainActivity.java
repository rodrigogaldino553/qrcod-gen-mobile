package com.again.qrcodgen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_link = findViewById(R.id.edit_link);

    }

    public void sendLink(View view) {
        Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show();
    }


}