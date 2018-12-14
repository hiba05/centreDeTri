package com.example.education.centredetri;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.education.centredetri.R;
import com.example.education.centredetri.compteCentre.compteCentre;
import com.example.education.centredetri.compteCentre.sinscrire;
import com.example.education.centredetri.evenement.ListeEvenement;

public class connexion extends AppCompatActivity implements View.OnClickListener{

    private Button bt_connection,bt_valider,bt_confirmer;
    private EditText et_mdp,et_code,et_cmdp;
    private TextView tv_sinscrire,tv_mdp,et_email,tv_close,tv_mp;
    private Dialog myDialog;
    private Animation animShake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        bt_connection= findViewById(R.id.bt_connection);
        tv_mdp= findViewById(R.id.tv_mdp);
        tv_sinscrire = findViewById(R.id.tv_sinscrire);

        tv_sinscrire.setOnClickListener(this);
        bt_connection.setOnClickListener(this);
        tv_mdp.setOnClickListener(this);

        myDialog = new Dialog(this);
        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.transition);

    }


    public void ShowPopup(View v) {

        TextView tv_close;
        myDialog.setContentView(R.layout.popup_mot_depasse);
        tv_close = myDialog.findViewById(R.id.tv_close);
        bt_valider = myDialog.findViewById(R.id.bt_valider);
        et_email = myDialog.findViewById(R.id.et_email);
        tv_mp = myDialog.findViewById(R.id.tv_mp);
        tv_mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup_mdp(v);
            }
        });
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                bt_valider.setVisibility(View.GONE);
            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


    public void ShowPopup_mdp(View v) {
        TextView tv_close;
        myDialog.setContentView(R.layout.popup_confirmer_mot_depasse);
        tv_close = myDialog.findViewById(R.id.tv_close);
        bt_confirmer = myDialog.findViewById(R.id.bt_confirmer);
        et_code = myDialog.findViewById(R.id.et_code);
        et_mdp = myDialog.findViewById(R.id.et_mdp);
        et_cmdp = myDialog.findViewById(R.id.et_cmdp);
        bt_confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt_confirmer.setVisibility(View.GONE);
            }
        });

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    private boolean check(EditText T) {

        if (T.getText().toString().trim().isEmpty()) {
            T.setError("saisir Nom");
            T.setError("Invalide");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

        if(v == tv_sinscrire){
            Intent i = new Intent(v.getContext(), sinscrire.class);
            startActivityForResult(i, 0);}
     else if(v == bt_connection ){
        Intent i = new Intent(v.getContext(), ListeEvenement.class);
        startActivityForResult(i, 0);}

     else if (v == tv_mdp) {
        ShowPopup(v);
        }
    }
}
