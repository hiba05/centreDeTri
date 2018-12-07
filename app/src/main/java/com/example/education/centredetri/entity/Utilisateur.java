package com.example.education.centredetri.entity;

/**
 * Created by Education on 07/12/2018.
 */

public class Utilisateur {

    private String email;
    private Integer iduser;
    private String mdp;
    private Profil profil;

    public Utilisateur(String email,String mdp, Profil profil){
        this.email=email;
        this.mdp=mdp;
        this.profil=profil;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
}
