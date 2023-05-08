package com.project.ia.model;

import com.project.ia.genericDAO.DBTable;

public class Publication extends DBTable {
    private String idPublication;
    private String idAdministrateur;
    private String nom;
    private String datepub;
    private String descript;
    private String imagePub;
    private String extimg;


    public String getNameAuto(){
        return "PUB";
    }
    // Constructeur avec idPublication
    public Publication(String idPublication, String idAdministrateur, String nom,String datepub, String descript,String imagePub,String extimg) {
        this.idPublication = idPublication;
        this.idAdministrateur = idAdministrateur;
        this.nom=nom;
        this.datepub = datepub;
        this.descript = descript;
        this.imagePub=imagePub;
        this.extimg=extimg;
    }

    // Constructeur sans idPublication
    public Publication(String idAdministrateur,String nom, String datepub, String descript,String imagePub,String extimg) {
        this.idAdministrateur = idAdministrateur;
        this.nom=nom;
        this.datepub = datepub;
        this.descript = descript;
        this.imagePub=imagePub;
        this.extimg=extimg;
    }

    // Constructeur vide
    public Publication() {}

    // Getters/Setters
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(String idPublication) {
        this.idPublication = idPublication;
    }

    public String getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(String idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }

    public String getDatepub() {
        return datepub;
    }

    public void setDatepub(String datepub) {
        this.datepub = datepub;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    
    public String getImagePub() {
        return this.imagePub;
    }

    public void setImagePub(String imagePub) {
        this.imagePub = imagePub;
    }
    public String getSeqName() {
        return "spublication";
    }
	public String getExtimg() {
		return this.extimg;
	}

	public void setExtimg(String extimg) {
		this.extimg = extimg;
	}

    // Méthode toString()
    @Override
    public String toString() {
        return "Publication{" +
                "idPublication='" + idPublication + '\'' +
                ", idAdministrateur='" + idAdministrateur + '\'' +
                ", nom='" + nom + '\'' +
                ", datepub=" + datepub +
                ", descript='" + descript + '\'' +
                ", extimg='" + extimg + '\'' +
                '}';
    }
}

