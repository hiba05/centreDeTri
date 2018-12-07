package com.example.education.centredetri.entity;

/**
 * Created by Education on 07/12/2018.
 */

public class Compteutilisateur {

    private String adresse;
    private Integer idcompte;
    private String nomentreprise;
    private String nomprenom;
    private Integer numrgst;
    private String numtel;
    private Utilisateur utilisateur;

    public Compteutilisateur(String adresse,String nomentreprise, String nomprenom,Integer numrgst,String numtel,Utilisateur utilisateur){
        this.adresse=adresse;
        this.nomentreprise=nomentreprise;
        this.nomprenom=nomprenom;
        this.numrgst=numrgst;
        this.numtel=numtel;
        this.utilisateur=utilisateur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Integer idcompte) {
        this.idcompte = idcompte;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getNomprenom() {
        return nomprenom;
    }

    public void setNomprenom(String nomprenom) {
        this.nomprenom = nomprenom;
    }

    public Integer getNumrgst() {
        return numrgst;
    }

    public void setNumrgst(Integer numrgst) {
        this.numrgst = numrgst;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }



}
