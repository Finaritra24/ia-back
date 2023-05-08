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
        ajoutPub("hh","kkk","/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUSEhMVFhUXFRcXFxYWFxsfGBgYFxoXFxcYHSggGholHRsXITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGxAQGy0lICUtLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAOEA4QMBIgACEQEDEQH/xAAYAAEAAgMAAAAAAAAAAAAAAAAAAgQCBQYD/8QAIBAAAgEDAgQEAgIDCgMAAAAAAAECAwQRBRIhMQYHEyJBYXGBkaEUIzNCwQgVI2JzgZGi0UNywdElkrH/xAAaAQADAQEBAQAAAAAAAAAAAAAAAQIDBAUG/8QAGBEAAgMBAAAAAAAAAAAAAAAAARECExQh/9oACAEBAAEFAj//xAAaEAACAQMCBQQCAwAAAAAAAAAAAQIDEQQFIRIxQXGBkSIyUaHh8BMzgZIjJIKS4f/EABgBAQEBAQEAAAAAAAAAAAAAAAABAgME/8QAJhEBAQEAAgICAwAAAAAAAAAAAAECAwQRMRITIjJBcfD/xAAVAQEBAAAAAAAAAAAAAAAAAAAAAf/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AO7VUoAKAEUg7VUoA1paM7VUoA1paYg7UAKDVppypQArxQArQAVgJlVZlWPKfHcVZlYPKXNUnLHeStG1tKc+ysB1GtZStGtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNe3q3r0tKpA1GtZ3J+oKBUtKfHcVZlWPKXNUNLHeSpG1tKfHcVZlWPKXNUNLHeSpG1tKfHcVZlYPKXNUNLHeSpG1tKfHcVZlYPKXNUNLHeSpG1tKfHcVZlYPKX","ADM1");
    }
}
