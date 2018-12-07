package com.example.education.centredetri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class acceuil extends AppCompatActivity implements View.OnClickListener{

    private Button bt_connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        bt_connection = findViewById(R.id.bt_connection);
        bt_connection.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == bt_connection){
            Intent i = new Intent(v.getContext(), connexion.class);
            startActivityForResult(i, 0);}
    }
}
