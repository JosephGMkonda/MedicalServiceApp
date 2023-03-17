package com.example.medicalserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String [][] packages =
            {

            {"Package 1 : Full Body Checkup","","","","1999"},
            {"Package 2 : Blood Glucose Fasting","","","","2999"},
            {"Package 3 : COVID_19","","","","4999"},
            {"Package 4 : Thyroid","","","","3999"},
            {"Package 5 : Immunity Check","","","","299"}
    };

    private String [] package_details = {
            "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbAlc\n" +
                    "Iron Studies\n" +
                    "Kidney Fuction Test\n" +
                    "LDH Lactate Dehydrogene, Serum\n" +
                    "Lipid Profile\n"+
                    "Liver Function Test\n",
            "Blood Glucose Fasting",
            "Covid-19",
            "Thyroid Profile-Total (T3,T6 & TSH Ultra-sensitive",
            "Complete Homogram\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total-25 hydroxy\n"+
                    "Liver Function Test\n" +
                    "Lipid Profile"

    };


    Button btnBack;
    HashMap<String, String> items;
    ArrayList list;
    SimpleAdapter simpleAdapter;
    Button goToCartBtn;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnBack = findViewById(R.id.buttonBack);
        goToCartBtn = findViewById(R.id.AddToCart);
        listView = findViewById(R.id.listView);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length; i++){
            items = new HashMap<String, String>();
            items.put("Line1",packages[i][0]);
            items.put("Line2",packages[i][1]);
            items.put("Line3",packages[i][2]);
            items.put("Line4",packages[i][3]);
            items.put("Line5","Total Cost"+packages[i][4]);
            list.add(items);


        }
        simpleAdapter = new SimpleAdapter(this,
                list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
                listView.setAdapter(simpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                intent.putExtra("text1",packages[i][0]);
                intent.putExtra("text2",package_details[i]);
                intent.putExtra("text3",packages[i][4]);
                startActivity(intent);

            }
        });
    }
}