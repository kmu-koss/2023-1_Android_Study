package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class a3 extends AppCompatActivity {
    private ImageView back_btn;
    private ImageView next_btn;
    private EditText food_edit;
    private Button answer_btn;
    boolean answer;
    String shared = "file";
    ArrayList food_list = new ArrayList<>();
    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        back_btn = findViewById(R.id.back_btn);
        next_btn = findViewById(R.id.next_btn);
        food_edit = findViewById(R.id.food_edit);
        answer_btn = findViewById(R.id.answer_btn);
        food_list = getStringArrayPref(getApplicationContext(), SETTINGS_PLAYER_JSON);

        answer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a3.this, a4.class);
                intent.putExtra("TEXT",food_edit.getText().toString());
                String value = food_edit.getText().toString();
                food_list = getStringArrayPref(getApplicationContext(),"list");
                boolean answer = food_list.contains(value);

                if (answer) {
                    Toast.makeText(view.getContext(), "정답입니다!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), "오답입니다!", Toast.LENGTH_SHORT).show();
                }
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
    private ArrayList getStringArrayPref(Context context, String key) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList urls = new ArrayList();

        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);

                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}