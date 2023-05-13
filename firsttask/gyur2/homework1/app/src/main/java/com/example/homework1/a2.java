package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class a2 extends AppCompatActivity {

    private ArrayList<list_data> arrayList;
    private list_adapter list_adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private ImageView back_btn;
    private ImageView next_btn;
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
        setContentView(R.layout.activity_a2);

        back_btn = findViewById(R.id.back_btn);
        next_btn = findViewById(R.id.next_btn);


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a2.this, a3.class);
                startActivity(intent);
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        list_adapter = new list_adapter(arrayList);
        recyclerView.setAdapter(list_adapter);


        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list_data list_data1 = new list_data(R.drawable.chicken, "치킨");
                arrayList.add(list_data1);
                food_list.add("치킨");

                list_data list_data2 = new list_data(R.drawable.pizza, "pizza");
                arrayList.add(list_data2);
                food_list.add("pizza");

                list_data list_data3 = new list_data(R.drawable.ricenoodle, "쌀국수");
                arrayList.add(list_data3);
                food_list.add("쌀국수");

                list_data list_data4 = new list_data(R.drawable.sss, "부대찌개");
                arrayList.add(list_data4);
                food_list.add("부대찌개");

                list_data list_data5 = new list_data(R.drawable.burger, "햄버거");
                arrayList.add(list_data5);
                food_list.add("햄버거");
                setStringArrayPref(getApplicationContext(), "list", food_list);
                list_adapter.notifyDataSetChanged();

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

    private void setStringArrayPref(Context context, String key, ArrayList<String> values) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();

        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }

        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }

        editor.apply();
    }

}