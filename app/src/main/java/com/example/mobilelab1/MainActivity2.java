package com.example.mobilelab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    boolean isNew = true;
    String operator = "";
    String oldNumber = "";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if (intent != null) {
            isNew = intent.getBooleanExtra("isNew", true);
            operator = intent.getStringExtra("operator");
            oldNumber = intent.getStringExtra("oldNumber");
            String editTextValue = intent.getStringExtra("editText");
            editText.setText(editTextValue);
        }

    }

}