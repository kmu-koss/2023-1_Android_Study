package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class a3 extends AppCompatActivity {
    private ImageView back_btn;
    private ImageView next_btn;
    private EditText food_edit;
    private Button answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        back_btn = findViewById(R.id.back_btn);
        next_btn = findViewById(R.id.next_btn);
        food_edit = findViewById(R.id.food_edit);
        answer = findViewById(R.id.answer);

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a3.this, a4.class);
                intent.putExtra("TEXT",food_edit.getText().toString());
            }
        });


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a3.this, a4.class);
                startActivity(intent);
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a3.this, a2.class);
                startActivity(intent);
            }
        });
    }
}