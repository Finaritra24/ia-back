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
public class Vehicule extends DBTable{
    private String idVehicule;
    private String numero;
    private String idMarque;
    private String idModele;

    // Constructeur avec idVehicule
    public Vehicule(String idVehicule, String numero, String idMarque, String idModele) {
        this.idVehicule = idVehicule;
        this.numero = numero;
        this.idMarque = idMarque;
        this.idModele = idModele;
    }

    // Constructeur sans idVehicule
    public Vehicule(String numero, String idMarque, String idModele) {
        this.numero = numero;
        this.idMarque = idMarque;
        this.idModele = idModele;
    }

    // Constructeur vide
    public Vehicule() {}

    // Getters/Setters
    public String getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(String idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public String getSeqName() {
        return "svehicule";
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule='" + idVehicule + '\'' +
                ", numero='" + numero + '\'' +
                ", idMarque='" + idMarque + '\'' +
                ", idModele='" + idModele + '\'' +
                '}';
    }
}

