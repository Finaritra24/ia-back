package com.project.ia;

import org.springframework.http.HttpHeaders;

import java.io.File;
import java.util.Map;
import java.util.Vector;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.ia.model.Administrateur;
import com.project.ia.model.Publication;
import com.project.ia.service.ServAdmin;
import com.project.ia.service.ServPublication;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin()
public class IaController {


    //administrateur

    @GetMapping("/listadmin")
    public Vector<Administrateur>  listAdmin() throws Exception{
        Vector<Administrateur> list=new ServAdmin().listAdmin();
        return list;
    }

    @CrossOrigin()
    @PostMapping("/loginAdmin")
    public String testLogin(@RequestBody Map<String, String> loginData, HttpServletResponse response) throws Exception{
        String identification = loginData.get("identification");
        String mdp = loginData.get("mdp");
        boolean btest=new ServAdmin().testLoginAdmin(identification, mdp);
        if (btest) {
            String id=new ServAdmin().getIdAdmin(identification, mdp);
            Cookie cookie = new Cookie("userId", id);
            cookie.setMaxAge(60 * 60 * 24); // Durée de vie du cookie (1 jour)
            response.addCookie(cookie);
            HttpHeaders headers = new HttpHeaders();
            headers.add(new HttpHeaders().SET_COOKIE, cookie.toString());
            response.setStatus(HttpServletResponse.SC_OK);
            return "Connexion réussie";
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return "Informations d'identification incorrectes";
    }

    //publication

    @PostMapping(value = "/ajoutPub", consumes = { "multipart/form-data" })
    public void ajouterPub(@RequestParam("nom") String nom,
    @RequestParam("description") String description,
    @RequestParam("file") MultipartFile file,
    @RequestParam("id") String id,
    HttpServletResponse response){
        // String id=pubData.get("id");
        // String nom=pubData.get("nom");
        // String description=pubData.get("description");
        String uniqueFilename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File destination = new File("D:/Matiere/S6/mr Rojo/projet/projet/IA/image", uniqueFilename);
        try {
             // Transférer le fichier dans l'emplacement de destination
             file.transferTo(destination);
            new ServPublication().ajoutPub(nom,description,uniqueFilename,id);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            e.printStackTrace();
        }
    }

    @GetMapping("/listPub")
    public Vector<Publication> listPub() throws Exception{
        Vector<Publication> list=new ServPublication().listPub();
        return list;
    }

}
