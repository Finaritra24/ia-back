/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ia.model;
import com.project.ia.genericDAO.DBTable;
/**
 *
 * @author P14A-24-Finaritra
 */
public class Utilisateur extends DBTable{
    private String idUtilisateur;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String contact;
    private String identification;
    private String mdp;

    // Constructeur avec idUtilisateur
    public Utilisateur(String idUtilisateur, String nom, String prenom, String datenaissance, String contact, String identification, String mdp) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.contact = contact;
        this.identification = identification;
        this.mdp = mdp;
    }

    // Constructeur sans idUtilisateur
    public Utilisateur(String nom, String prenom, String datenaissance, String contact, String identification, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.contact = contact;
        this.identification = identification;
        this.mdp = mdp;
    }

    // Constructeur vide
    public Utilisateur() {}

    // Getters/Setters
    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
        return "sutilisateur";
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur='" + idUtilisateur + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datenaissance='" + datenaissance + '\'' +
                ", contact='" + contact + '\'' +
                ", identification='" + identification + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
