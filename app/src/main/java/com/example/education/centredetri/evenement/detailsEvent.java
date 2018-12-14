package com.example.education.centredetri.evenement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.education.centredetri.R;

public class detailsEvent extends AppCompatActivity {

    private TextView tv_DateDebut,tv_heureDebut,tv_DateFin,tv_heureFin,tv_nbPart,tv_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_event);


        Bundle b = getIntent().getExtras();
        String DateDebut =(String) b.get("DateDebut");
        String HeureDebut=(String) b.get("HeureDebut");
        String DateFin =(String) b.get("DateFin");
        String HeureFin =(String) b.get("HeureFin");
        Integer nbPart =(Integer) b.get("nbPart");
        String tvDetail =(String) b.get("tvDetail");

        tv_DateDebut = findViewById(R.id.tv_dateDebut);
        tv_heureDebut = findViewById(R.id.tv_heureDebut);
        tv_DateFin = findViewById(R.id.tv_DateFin);
        tv_heureFin = findViewById(R.id.tv_heureFin);
        tv_nbPart = findViewById(R.id.tv_nbPrtc);
        tv_details = findViewById(R.id.tv_detail);


        tv_DateDebut.setText(DateDebut);
        tv_heureDebut.setText(HeureDebut);
        tv_DateFin.setText(DateFin);
        tv_heureFin.setText(HeureFin);
        tv_nbPart.setText(Integer.toString(nbPart));
        tv_details.setText(tvDetail);


    }
}
