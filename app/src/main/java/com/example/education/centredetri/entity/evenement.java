package com.example.education.centredetri.entity;

/**
 * Created by Education on 08/12/2018.
 */

public class evenement {

    private String codeevent;
    private Compteutilisateur compteutilisateur;
    private String datedebut;
    private String datefin;
    private String descevent;//desc assoc
    private String details;
    private String heuredebut;
    private String heurefin;
    private Integer idevent;
    private String lieu;
    private Integer nbparticipant;
    private String nomassoc;
    private String nomevent;
    private String photo;
    private String qrcode;
    private Boolean valide;





    public evenement(Compteutilisateur compteutilisateur,String datedebut,String datefin,String details,String heureFin,String heuredebut,String lieu,Integer nbparticipant, String nomevent,String photo,String qrCode,Boolean valide,String nomassoc,String descevent ){
        this.compteutilisateur=compteutilisateur;
        this.datedebut=datedebut;
        this.datefin=datefin;
        this.details=details;
        this.heurefin=heureFin;
        this.heuredebut=heuredebut;
        this.lieu=lieu;
        this.nbparticipant=nbparticipant;
        this.nomevent=nomevent;
        this.photo=photo;
        this.qrcode=qrCode;
        this.valide=valide;
        this.nomassoc=nomassoc;
        this.descevent=descevent;
    }


    public evenement(String datedebut,String datefin,String details,String heureFin,String heuredebut,String lieu,Integer nbparticipant, String nomevent,String photo,String qrCode,Boolean valide,String nomassoc,String descevent ){

        this.datedebut=datedebut;
        this.datefin=datefin;
        this.details=details;
        this.heurefin=heureFin;
        this.heuredebut=heuredebut;
        this.lieu=lieu;
        this.nbparticipant=nbparticipant;
        this.nomevent=nomevent;
        this.photo=photo;
        this.qrcode=qrCode;
        this.valide=valide;
        this.nomassoc=nomassoc;
        this.descevent=descevent;
    }


    public String getCodeevent() {
        return codeevent;
    }

    public void setCodeevent(String codeevent) {
        this.codeevent = codeevent;
    }

    public Compteutilisateur getCompteutilisateur() {
        return compteutilisateur;
    }

    public void setCompteutilisateur(Compteutilisateur compteutilisateur) {
        this.compteutilisateur = compteutilisateur;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getDescevent() {
        return descevent;
    }

    public void setDescevent(String descevent) {
        this.descevent = descevent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(String heuredebut) {
        this.heuredebut = heuredebut;
    }

    public String getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(String heurefin) {
        this.heurefin = heurefin;
    }

    public Integer getIdevent() {
        return idevent;
    }

    public void setIdevent(Integer idevent) {
        this.idevent = idevent;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(Integer nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getNomassoc() {
        return nomassoc;
    }

    public void setNomassoc(String nomassoc) {
        this.nomassoc = nomassoc;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }
}
