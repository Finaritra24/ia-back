package com.project.ia.service;

import java.util.Vector;

import com.project.ia.model.Administrateur;

public class ServAdmin{
    public static Vector<Administrateur> listAdmin() throws Exception {
        Vector<Administrateur> listPub=new Administrateur().find("SELECT * FROM administrateur", null);
        return listPub;
    }

    public boolean testLoginAdmin(String identification, String mdp) throws Exception{
        Vector<Administrateur> listPub=new Administrateur().find("SELECT * FROM administrateur where identification='"+identification+"' and mdp='"+mdp+"'", null);
        if(listPub.size()>=1){return true;}
        return false;
    }

    public String getIdAdmin(String identification, String mdp) throws Exception{
        Vector<Administrateur> list=new Administrateur().find("SELECT * FROM administrateur where identification='"+identification+"' and mdp='"+mdp+"'", null);
        String a=list.get(0).getIdAdministrateur();
        return a;
    }

    public Administrateur getAdmin(String id) throws Exception{
        Vector<Administrateur> list=new Administrateur().find("SELECT * FROM administrateur where idAdministrateur='"+id+"'", null);
        Administrateur a=list.get(0);
        return a;
    }
    public static void main(String[]args) throws Exception{
        String id=new ServAdmin().getIdAdmin("JD1234", "mdp123");
        System.out.print(id);
    }
}