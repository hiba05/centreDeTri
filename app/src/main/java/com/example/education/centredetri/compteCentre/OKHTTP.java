package com.example.education.centredetri.compteCentre;

import android.util.Log;

import org.json.JSONObject;

import java.net.HttpURLConnection;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Education on 07/12/2018.
 */

public class OKHTTP {

    public static String GetOkHttpRequest(String url) throws Exception {

        OkHttpClient client = new OkHttpClient();

        //Création de la requête
        Request request = new Request.Builder().url(url).build();

        //Exécution de la requête
        Response response = client.newCall(request).execute();

        //Analyse du code retour

        if (response.code() != HttpURLConnection.HTTP_OK) {

            throw new Exception("Reponse incorrecte du serveur : " + response.code());

        } else {
            //RÃ©sultat de la requÃªte
            return response.body().string();
        }

    }


    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String PostOkHttpRequest(String url, JSONObject json) throws Exception {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, String.valueOf(json));

        //Création de la requête
        Request request = new Request.Builder().url(url).post(body).build();

        //Exécution de la requête
        Response response = client.newCall(request).execute();

        if (response.code() != HttpURLConnection.HTTP_OK) {

            if (response.code() == 204) {
                throw new Exception("envoyé");
            } else {
                throw new Exception("Reponse du serveur incorrecte : " + response.code()+json);

            }

        } else {
            //RÃ©sultat de la requÃªte
            return response.body().string();
        }
    }
}
