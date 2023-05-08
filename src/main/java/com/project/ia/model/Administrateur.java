package com.project.ia.model;
import com.project.ia.genericDAO.DBTable;


public class Administrateur extends DBTable {
    private String idAdministrateur;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String contact;
    private String identification;
    private String mdp;

    public String getNameAuto(){
        return "ADM";
    }
    // Constructeur avec idAdministrateur
    public Administrateur(String idAdministrateur, String nom, String prenom){
        this.idAdministrateur = idAdministrateur;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Administrateur(String idAdministrateur, String nom, String prenom, String datenaissance, String contact, String identification, String mdp) {
        this.idAdministrateur = idAdministrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.contact = contact;
        this.identification = identification;
        this.mdp = mdp;
    }

    // Constructeur sans idAdministrateur
    public Administrateur(String nom, String prenom, String datenaissance, String contact, String identification, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.contact = contact;
        this.identification = identification;
        this.mdp = mdp;
    }

    // Constructeur vide
    public Administrateur() {}

    // Getters/Setters
    public String getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(String idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getSeqName() {
        return "sadministrateur";
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Administrateur{" +
                "idAdministrateur='" + idAdministrateur + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datenaissance=" + datenaissance +
                ", contact='" + contact + '\'' +
                ", identification='" + identification + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
