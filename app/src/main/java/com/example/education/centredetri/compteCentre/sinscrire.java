package com.example.education.centredetri.compteCentre;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
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
import com.example.education.centredetri.entity.Compteutilisateur;
import com.example.education.centredetri.entity.Profil;
import com.example.education.centredetri.entity.Utilisateur;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sinscrire extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG=sinscrire.class.getSimpleName();
 private static final String UrlCompte ="http://192.168.43.16:18080/ECO/webresources/client.compteutilisateur/Comptecreate";
    private EditText et_nomEntreprise,et_numRegst,et_Representant,et_adresse,et_phone,et_email,et_motDePasse,et_cMotDePasse;
    private TextView tv_valider,tv_erreur;
    private Button bt_inscription;
    private Animation animShake;
    private String nomEntreprise,Representant,adresse,phone,email,motDePasse,cMotDePasse;
    private Integer numRegst;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_sinscrire);
     et_nomEntreprise = findViewById(R.id.et_nomEntreprise);
     et_numRegst = findViewById(R.id.et_numRegst);
     et_Representant = findViewById(R.id.et_Representant);
     et_adresse = findViewById(R.id.et_adresse);
     et_phone = findViewById(R.id.et_phone);
     et_email = findViewById(R.id.et_email);
     et_motDePasse = findViewById(R.id.et_motDePasse);
     et_cMotDePasse = findViewById(R.id.et_cMotDePasse);
     tv_valider = findViewById(R.id.tv_valider);
     tv_erreur = findViewById(R.id.tv_erreur);
     bt_inscription =findViewById(R.id.bt_inscription);

     bt_inscription = findViewById(R.id.bt_inscription);


bt_inscription.setOnClickListener(this);



    /* bt_inscription.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Log.d(TAG, "onClick:inscription ");
         }
     });
     tv_valider.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Log.d(TAG, "onClick: v");
         }
     });*/
     /*animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.transition);*/

 }



    private boolean isEmailAdress(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            et_email.setError("saisir mdp");
            et_email.setError("email invalide");
        }
        return matcher.matches();

    }

    private boolean MotDePasseIdentique() {

        if (!et_motDePasse.getText().toString().equals(et_cMotDePasse.getText().toString())) {
            et_cMotDePasse.setError("saisir mdp");
            et_cMotDePasse.setError("Mot de passe pas identiques");
            return false;
        }
        return true;
    }



    private boolean check(EditText T) {

        if (T.getText().toString().trim().isEmpty()) {
            T.setError("saisir Nom");
            T.setError("Nom invalide");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

if(v==bt_inscription){

    nomEntreprise =  et_nomEntreprise.getText().toString();
    nomEntreprise= nomEntreprise.toLowerCase();

    numRegst =Integer.parseInt(String.valueOf(et_numRegst.getText()));


    Representant =  et_Representant.getText().toString();
    Representant= Representant.toLowerCase();


    adresse = et_adresse.getText().toString();
    adresse= adresse.toLowerCase();

    phone = et_phone.getText().toString();
    phone= phone.toLowerCase();

    email = et_email.getText().toString();
    email= email.toLowerCase();

    motDePasse = et_motDePasse.getText().toString();
    motDePasse= motDePasse.toLowerCase();

    cMotDePasse = et_cMotDePasse.getText().toString();
    cMotDePasse= cMotDePasse.toLowerCase();


    String MotDepasseH = hashage.sha256(motDePasse);

    Profil profil= new Profil(1,"entreprise","centreDeTri");
    Utilisateur utilisateur= new Utilisateur(email,MotDepasseH,profil);
    Compteutilisateur compte= new Compteutilisateur(adresse,nomEntreprise,0,Representant,numRegst,phone,utilisateur);
    new EnvoieAsyncTask(compte).execute(UrlCompte);
}

    }


    public class EnvoieAsyncTask extends AsyncTask<String, Void, String> {
        private Exception exception = null;
        JSONObject jsonObject;
        Compteutilisateur compte;
        ProgressDialog progressDialog;

        public EnvoieAsyncTask(Compteutilisateur compte) {
            this.compte = compte;
            this.jsonObject = send(compte);
            Log.d(TAG, "doInBackground: "+jsonObject);
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(sinscrire.this);
            progressDialog.setTitle("Envoie");
            progressDialog.setMessage("Envoie de données en cours...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Log.d(TAG, "doInBackground: "+jsonObject);
               // Log.w("tag", "alors" + jsonObject);
               return OKHTTP.PostOkHttpRequest(UrlCompte, jsonObject);
            } catch (Exception e) {
                exception = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            progressDialog.dismiss();
            if (exception != null) {

                exception.printStackTrace();
                exception.printStackTrace();
                Log.w("tag", "message" + s);
                tv_erreur.setText( exception.getMessage());
              /*  if (exception.getMessage() == "timeout" ) {
                    tv_erreur.setText("enregistré avec succés");
                    tv_erreur.setTextColor(Color.GREEN);
                } else {
                    // Toast.makeText(context,"Une erreur s'est produite  : "+ exception.getMessage(),Toast.LENGTH_SHORT).show();
                    tv_erreur.setText("Une erreur s'est produite  : " + exception.getMessage());
                    tv_erreur.setTextColor(Color.RED);
                }*/
            } else {
                //Toast.makeText(context,"le message : "+ s,Toast.LENGTH_SHORT).show();
                Log.w("tag", "message" + s);
                tv_erreur.setText(s);
                tv_erreur.setTextColor(Color.GREEN);
            }
        }
    }


    JSONObject send(Compteutilisateur compte) {

        JSONObject jsonObject1 = new JSONObject();

        try {
            jsonObject1.accumulate("adresse", compte.getAdresse());
            jsonObject1.accumulate("idcompte", "");
            jsonObject1.accumulate("nbpoint", 0);

            jsonObject1.accumulate("nomentreprise", compte.getNomentreprise());
        jsonObject1.accumulate("nomprenom", compte.getNomprenom());
        jsonObject1.accumulate("numrgst", compte.getNumrgst());
        jsonObject1.accumulate("numtel", compte.getNumtel());

        JSONObject utilisateur = new JSONObject();
        utilisateur.accumulate("email", compte.getUtilisateur().getEmail());
        utilisateur.accumulate("iduser", "");
        utilisateur.accumulate("mdp", compte.getUtilisateur().getMdp());
        jsonObject1.accumulate("utilisateur",utilisateur);
        JSONObject profil = new JSONObject();
         profil.accumulate("descprofil", compte.getUtilisateur().getProfil().getDescprofil());
            profil.accumulate("idprofil", compte.getUtilisateur().getProfil().getIdprofil());
            profil.accumulate("nomprofil", compte.getUtilisateur().getProfil().getNomprofil());
            jsonObject1.accumulate("profil",profil);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }


}
