package com.example.education.centredetri.evenement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.education.centredetri.R;
import com.example.education.centredetri.compteCentre.OKHTTP;
import com.example.education.centredetri.compteCentre.compteCentre;
import com.example.education.centredetri.connexion;
import com.example.education.centredetri.entity.evenement;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListeEvenement extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_settings,iv_ret;
    RecyclerView RV_evenement;
    private ArrayList<evenement> evenements;

    private EvenementAdapter evenementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenement);

        iv_settings=findViewById(R.id.iv_settings);
        iv_ret=findViewById(R.id.iv_icon);

        iv_settings.setOnClickListener(this);
        iv_ret.setOnClickListener(this);

        // myDialog = new Dialog(this);
        RV_evenement = findViewById(R.id.RV_historique);

        RV_evenement.setHasFixedSize(true);
        RV_evenement.setLayoutManager(new LinearLayoutManager(this));

        evenements = new ArrayList<>();
        evenementAdapter = new EvenementAdapter(evenements, getApplicationContext());

        RV_evenement.setAdapter(evenementAdapter);

        String UrlAdresse = "http://192.168.43.16:18080/ECO/webresources/client.evenement";
        new OKHttpAsyncTask().execute(UrlAdresse);
    }

    @Override
    public void onClick(View v) {

        if(v==iv_settings){
            Intent i = new Intent(v.getContext(), compteCentre.class);
            startActivityForResult(i, 0);}
         else if(v == iv_ret) {
        Intent i = new Intent(v.getContext(), connexion.class);
        startActivityForResult(i, 0);}
    }

    public class OKHttpAsyncTask extends AsyncTask<String, Void, String> {
        private Exception exception = null;

        @Override
        protected String doInBackground(String... strings) {
            try {
                return OKHTTP.GetOkHttpRequest(strings[0]);
            } catch (Exception e) {
                exception = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            if (exception != null) {
                exception.printStackTrace();

                Toast.makeText(ListeEvenement.this, "Pas d'evenement à afficher  ", Toast.LENGTH_LONG).show();
            } else {

                evenements.clear();
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    JSONObject Levenement = null;
                    Log.w("tag","les evenements"+s);


                    for (int i = 0; i < jsonArray.length(); i++) {

                        Levenement = jsonArray.getJSONObject(i);
                        String FactChaine = Levenement.toString();
                        Log.w("tag","lA evEnt"+FactChaine);
                        Gson gson = new Gson();
                        evenement evenement = gson.fromJson(FactChaine, evenement.class);

                        evenements.add(evenement);
                        evenementAdapter.notifyDataSetChanged();


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
