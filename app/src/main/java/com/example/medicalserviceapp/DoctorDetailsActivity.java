package com.example.medicalserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] Doctor_details0 =
            {
                    {"Doctor Name: Joseph Mkonda","Hospital Address: Chintheche","Exp: 5yrs","Mobile Number: 08889457565","1000"},
                    {"Doctor Name: James Maxwell","Hospital Address: Malaza","Exp: 3yrs","Mobile Number: 09919457565","1000"},
                    {"Doctor Name: Philip Banda","Hospital Address: Thudzi","Exp: 15yrs","Mobile Number: 09949457560","1000"},
                    {"Doctor Name: Hazel Limpopo","Hospital Address: Bandawe","Exp: 8yrs","Mobile Number: 08889458545","1000"},
                    {"Doctor Name: Mercy Ducks","Hospital Address: Chifila","Exp: 10yrs","Mobile Number: 08879257665","1000"}
    };

    private String [][] Doctor_details1 =
            {
                    {"Doctor Name: Joseph Mkonda","Hospital Address: Chintheche","Exp: 5yrs","Mobile Number: 08889457565","1000"},
                    {"Doctor Name: James Maxwell","Hospital Address: Malaza","Exp: 3yrs","Mobile Number: 09919457565","1000"},
                    {"Doctor Name: Philip Banda","Hospital Address: Thudzi","Exp: 15yrs","Mobile Number: 09949457560","1000"},
                    {"Doctor Name: Hazel Limpopo","Hospital Address: Bandawe","Exp: 8yrs","Mobile Number: 08889458545","1000"},
                    {"Doctor Name: Mercy Ducks","Hospital Address: Chifila","Exp: 10yrs","Mobile Number: 08879257665","1000"}
            };

    private String [][] Doctor_details2 =
            {
                    {"Doctor Name: Joseph Mkonda","Hospital Address: Chintheche","Exp: 5yrs","Mobile Number: 08889457565","1000"},
                    {"Doctor Name: James Maxwell","Hospital Address: Malaza","Exp: 3yrs","Mobile Number: 09919457565","1000"},
                    {"Doctor Name: Philip Banda","Hospital Address: Thudzi","Exp: 15yrs","Mobile Number: 09949457560","1000"},
                    {"Doctor Name: Hazel Limpopo","Hospital Address: Bandawe","Exp: 8yrs","Mobile Number: 08889458545","1000"},
                    {"Doctor Name: Mercy Ducks","Hospital Address: Chifila","Exp: 10yrs","Mobile Number: 08879257665","1000"}
            };

    private String [][] Doctor_details3 =
            {
                    {"Doctor Name: Joseph Mkonda","Hospital Address: Chintheche","Exp: 5yrs","Mobile Number: 08889457565","1000"},
                    {"Doctor Name: James Maxwell","Hospital Address: Malaza","Exp: 3yrs","Mobile Number: 09919457565","1000"},
                    {"Doctor Name: Philip Banda","Hospital Address: Thudzi","Exp: 15yrs","Mobile Number: 09949457560","1000"},
                    {"Doctor Name: Hazel Limpopo","Hospital Address: Bandawe","Exp: 8yrs","Mobile Number: 08889458545","1000"},
                    {"Doctor Name: Mercy Ducks","Hospital Address: Chifila","Exp: 10yrs","Mobile Number: 08879257665","1000"}
            };

    private String [][] Doctor_details4 =
            {
                    {"Doctor Name: Joseph Mkonda","Hospital Address: Chintheche","Exp: 5yrs","Mobile Number: 08889457565","1000"},
                    {"Doctor Name: James Maxwell","Hospital Address: Malaza","Exp: 3yrs","Mobile Number: 09919457565","1000"},
                    {"Doctor Name: Philip Banda","Hospital Address: Thudzi","Exp: 15yrs","Mobile Number: 09949457560","1000"},
                    {"Doctor Name: Hazel Limpopo","Hospital Address: Bandawe","Exp: 8yrs","Mobile Number: 08889458545","1000"},
                    {"Doctor Name: Mercy Ducks","Hospital Address: Chifila","Exp: 10yrs","Mobile Number: 08879257665","1000"}
            };
    TextView tv;
    Button btn;
    String [][] getDoctor_details = {};
    ArrayList list;
    HashMap<String ,String> item;
    SimpleAdapter simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView_title);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            getDoctor_details = Doctor_details0;
        else
        if(title.compareTo("Dietician")==0)
            getDoctor_details = Doctor_details1;
        else
        if(title.compareTo("Dentist")==0)
            getDoctor_details = Doctor_details2;
        else
        if(title.compareTo("Surgeon")==0)
            getDoctor_details = Doctor_details3;
        else
            getDoctor_details = Doctor_details4;



        btn = findViewById(R.id.buttonBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<getDoctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1",getDoctor_details[i][0]);
            item.put("line2",getDoctor_details[i][1]);
            item.put("line3",getDoctor_details[i][2]);
            item.put("line4",getDoctor_details[i][3]);
            item.put("line5","Cons fees:" + getDoctor_details[i][4]+"/");
            list.add(item);
        }

        simple = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView list = findViewById(R.id.listViewDD);
        list.setAdapter(simple);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                intent.putExtra("text1",title);
                intent.putExtra("text2",getDoctor_details[i][0]);
                intent.putExtra("text3",getDoctor_details[i][1]);
                intent.putExtra("text4",getDoctor_details[i][3]);
                intent.putExtra("text5",getDoctor_details[i][4]);
                startActivity(intent);
            }
        });

    }
}