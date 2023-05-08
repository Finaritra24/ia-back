package com.project.ia.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import com.project.ia.model.Publication;

public class ServPublication {
    public static String datecurrent() {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return formattedDate;
    }
    public static void ajoutPub(String nom, String descr, String img,String id) throws Exception{
        Publication pub=new Publication(id,nom,datecurrent(),descr,img);
        pub.create(pub.getNameAuto(), null);
    }
    public static Vector<Publication> listPub()throws Exception{
        Vector<Publication> list=new Publication().find("select*from publication",null);
        return list;
    }
    public static void main(String[] args) throws Exception{
        // Vector<Publication> v=listPub();
        // for(Publication p:v){
        //     System.out.println(p);
        // }
        ajoutPub("hh","kkk","1683491231934_tobilanay.PNG","ADM1");
    }
}
