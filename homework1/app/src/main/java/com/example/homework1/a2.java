package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



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


        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        food_list.add("치킨");
        food_list.add("피자");
        food_list.add("쌀국수");
        food_list.add("햄버거");
        food_list.add("부대찌개");
        //String value = food_list.get().toString();
        //editor.putString("food", value);
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

                list_data list_data2 = new list_data(R.drawable.pizza, "피자");
                arrayList.add(list_data2);

                list_data list_data3 = new list_data(R.drawable.ricenoodle, "쌀국수");
                arrayList.add(list_data3);

                list_data list_data4 = new list_data(R.drawable.sss, "부대찌개");
                arrayList.add(list_data4);

                list_data list_data5 = new list_data(R.drawable.burger, "햄버거");
                arrayList.add(list_data5);

                list_adapter.notifyDataSetChanged();
            }
        });
    }

}