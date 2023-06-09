package com.project.ia;

import org.springframework.http.HttpHeaders;

import java.util.Base64;
import java.util.Map;
import java.util.Vector;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
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
@CrossOrigin
public class IaController {


    //administrateur

    @GetMapping("/listadmin")
    public  Vector<Administrateur>  listAdmin() throws Exception{
        Vector<Administrateur> list=new ServAdmin().listAdmin();
        return list;
    }
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
    HttpServletResponse response){
        // String id=pubData.get("id");
        // String nom=pubData.get("nom");
        // String description=pubData.get("description");
        // String uniqueFilename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        // File destination = new File(System.getProperty("user.dir") + "/image", uniqueFilename);
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));

        try {
             // Transférer le fichier dans l'emplacement de destination
            byte[] imageBytes = file.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            String id="ADM1";
            new ServPublication().ajoutPub(nom,description,base64Image,extension,id);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/deletePub", method = RequestMethod.POST)
    @ResponseBody
    public void deleteProduct(@RequestBody Map<String, String> id, HttpServletResponse response) {
        String identif = id.get("id");
        try {
            Publication p = new Publication();
            p.setIdPublication(identif);
            p.delete(null);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @GetMapping("/listPub")
    public Vector<Publication> listPub() throws Exception{
        Vector<Publication> list=new ServPublication().listPub();
        return list;
    }

}
