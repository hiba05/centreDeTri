package com.example.education.centredetri.entity;

/**
 * Created by Education on 07/12/2018.
 */

public class Profil {

    private String descprofil;
    private Integer idprofil;
    private String nomprofil;

    public Profil(Integer idprofil,String descprofil,String nomprofil){
        this.descprofil=descprofil;
        this.nomprofil=nomprofil;

    }

    public String getDescprofil() {
        return descprofil;
    }

    public void setDescprofil(String descprofil) {
        this.descprofil = descprofil;
    }

    public Integer getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(Integer idprofil) {
        this.idprofil = idprofil;
    }

    public String getNomprofil() {
        return nomprofil;
    }

    public void setNomprofil(String nomprofil) {
        this.nomprofil = nomprofil;
    }

}
