package com.spring.backoffice.controller;

import com.mongodb.client.MongoClients;
import com.spring.backoffice.model.*;
import com.spring.backoffice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Controller
public class AdminController {

    public AdminController() {
        System.out.println("AdminController()");
    }

    @Autowired
    AdminRepository ar;

    @Autowired
    SignalementCompletRepository scr;

    @Autowired
    SignalementRepository sr;

    @Autowired
    RegionRepository rr;

    @Autowired
    StatRegionRepository srr;

    @Autowired
    StatStatutRepository str;

    @Autowired
    StatutRepository srep;

    @Autowired
    TypeSignalementRepository tsr;

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/accueil")
    public String accueil(Model model) {
        model.addAttribute("signalements", sr.findByIdRegionNull());
        model.addAttribute("signalementComplets", scr.findAll());
        return "admin";
    }

    @RequestMapping(value = "/admin/updateRegion/{id}", method = RequestMethod.POST)
    public String updateRegion(@PathVariable(value = "id") Long idSignalement, @RequestParam("idRegion") Long idRegion, Model model) throws Exception {
        sr.affecterRegion(idSignalement, idRegion);
        model.addAttribute("signalements", sr.findByIdRegionNull());
        model.addAttribute("signalementComplets", scr.findAll());
        return "admin";
    }

    @RequestMapping("/admin/affecter/{id}")
    public String affectation(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("idSignalement", id);
        model.addAttribute("regions", rr.findAll());
        return "affectation";
    }

    @RequestMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        Admin a = new Admin();
        HttpSession session = request.getSession(true);
        session.setAttribute("admin", a);
        return "login";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String loginAdmin(@RequestParam("username") String username, @RequestParam("mdp") String mdp, Model model, HttpServletRequest request) throws Exception {
        // Creation SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(mdp.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }

        Admin admin = new Admin();
        List<Admin> la = new ArrayList<Admin>();
        try {
            la = ar.findByUsernameAndMdp(username, "\\x" + sb.toString());
            if (la.size() == 1) {
                for (Admin ad : la) {
                    admin = ad;
                }
                model.addAttribute("signalements", sr.findByIdRegionNull());
                model.addAttribute("signalementComplets", scr.findAll());
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                return "admin";
            } else {
                model.addAttribute("errorLogin", "errorInformation");
                return "login";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping("/admin/chartRegion")
    public String showChartRegion(Model m) {
        List<StatRegion> ls = srr.findAll();
        m.addAttribute("statRegion", ls);
        return "chartRegion";
    }

    @RequestMapping("/admin/chartStatut")
    public String showChartStatut(Model m) {
        List<StatStatut> lsta = str.findAll();
        m.addAttribute("statStatut", lsta);
        return "chartStatut";
    }

    @RequestMapping(value = "/admin/createStatut", method = RequestMethod.POST)
    public String createStatut(@RequestParam("nomstatut") String nomStatut, Model m) {
        srep.insertStatut(nomStatut);
        List<Statut> listeStatut = srep.findAll();
        m.addAttribute("listeStatut", listeStatut);
        return "crudStatut";
    }

    @RequestMapping(value = "/admin/updateStatut", method = RequestMethod.POST)
    public String updateStatut(@RequestParam("nomstatut") String nomStatut, @RequestParam("idstatut") Long id, Model m) {
        srep.updateStatut(nomStatut, id);
        List<Statut> listeStatut = srep.findAll();
        m.addAttribute("listeStatut", listeStatut);
        return "crudStatut";
    }

    @RequestMapping(value = "/admin/deleteStatut", method = RequestMethod.POST)
    public String deleteStatut(@RequestParam("idstatut") Long id, Model m) {
        srep.deleteStatut(id);
        List<Statut> listeStatut = srep.findAll();
        m.addAttribute("listeStatut", listeStatut);
        return "crudStatut";
    }

    @RequestMapping(value = "/admin/createRegion", method = RequestMethod.POST)
    public String createRegion(@RequestParam("nomregion") String nomregion, Model m) {
        rr.insertRegion(nomregion);
        List<Region> listeRegion = rr.findAll();
        m.addAttribute("listeRegion", listeRegion);
        return "crudRegion";
    }

    @RequestMapping(value = "/admin/updateRegion", method = RequestMethod.POST)
    public String updateRegion(@RequestParam("nomregion") String nomregion, @RequestParam("idregion") Long id, Model m) {
        rr.updateRegion(nomregion, id);
        List<Region> listeRegion = rr.findAll();
        m.addAttribute("listeRegion", listeRegion);
        return "crudRegion";
    }

    @RequestMapping(value = "/admin/deleteRegion", method = RequestMethod.POST)
    public String deleteRegion(@RequestParam("idregion") Long id, Model m) {
        rr.deleteRegion(id);
        List<Region> listeRegion = rr.findAll();
        m.addAttribute("listeRegion", listeRegion);
        return "crudRegion";
    }

    @RequestMapping(value = "/admin/createTypeSignalement", method = RequestMethod.POST)
    public String createTypeSignalement(@RequestParam("typeSignalement") String typeSignalement, Model m) {
        tsr.insertTypeSignalement(typeSignalement);
        List<TypeSignalement> listeTypeSignalement = tsr.findAll();
        m.addAttribute("listeTypeSignalement", listeTypeSignalement);
        return "crudTypeSignalement";
    }

    @RequestMapping(value = "/admin/updateTypeSignalement", method = RequestMethod.POST)
    public String updateTypeSignalement(@RequestParam("typeSignalement") String typeSignalement, @RequestParam("idtypesignalement") Long id, Model m) {
        tsr.updateTypeSignalement(typeSignalement, id);
        List<TypeSignalement> listeTypeSignalement = tsr.findAll();
        m.addAttribute("listeTypeSignalement", listeTypeSignalement);
        return "crudTypeSignalement";
    }

    @RequestMapping(value = "/admin/deleteTypeSignalement", method = RequestMethod.POST)
    public String deleteTypeSignalement(@RequestParam("idtypesignalement") Long id, Model m) {
        tsr.deleteTypeSignalement(id);
        List<TypeSignalement> listeTypeSignalement = tsr.findAll();
        m.addAttribute("listeTypeSignalement", listeTypeSignalement);
        return "crudTypeSignalement";
    }

    @RequestMapping("/admin/crudStatut")
    public String crudStatut(Model m) {
        List<Statut> listeStatut = srep.findAll();
        m.addAttribute("listeStatut", listeStatut);
        return "crudStatut";
    }

    @RequestMapping("/admin/crudRegion")
    public String crudRegion(Model m) {
        List<Region> listeRegion = rr.findAll();
        m.addAttribute("listeRegion", listeRegion);
        return "crudRegion";
    }

    @RequestMapping("/admin/crudTypeSignalement")
    public String crudTypeSignalement(Model m) {
        List<TypeSignalement> listeTypeSignalement = tsr.findAll();
        m.addAttribute("listeTypeSignalement", listeTypeSignalement);
        return "crudTypeSignalement";
    }

    @RequestMapping("/admin/supprimerSignalement/{id}")
    public String supprimerSignalement(@PathVariable(value = "id") Long id, Model model) {
        sr.deleteById(id);
        model.addAttribute("signalements", sr.findByIdRegionNull());
        model.addAttribute("signalementComplets", scr.findAll());
        return "admin";
    }

    @RequestMapping("/admin/seeMore/{idclient}/{idsignalement}")
    public String seeMoreSignalement(@PathVariable(value = "idclient") Long idclient, @PathVariable(value = "idsignalement") Long idsignalement, Model m) {
        Photos photos = new Photos();
        MongoOperations mo = new MongoTemplate(MongoClients.create(), "photoSignalement");
        photos = mo.findOne(new Query(where("idClient").is(idclient.toString()).and("idSignalement").is(idsignalement.toString())), Photos.class);

        m.addAttribute("sc", scr.findByIdclientAndAndId(idclient, idsignalement));
        m.addAttribute("lesPhotos", photos);
        return "seeMoreSignalement";
    }

    @RequestMapping("/admin/rechercheAvance")
    public String gotoSearch(Model model) {
        model.addAttribute("listeSignalements", scr.findAll());
        model.addAttribute("typeSignalements", tsr.findAll());
        model.addAttribute("statuts", srep.findAll());
        return "rechercheAvance";
    }

    @RequestMapping(value = "/admin/rechercheAv")
    public String rechercheAvance(@RequestParam("idtypesignalement") Long idtypesignalement,
                                  @RequestParam("idstatut") Long idstatut,
                                  Model model) throws Exception {
        List<SignalementComplet> lsc = new ArrayList<SignalementComplet>();

        lsc = scr.findByIdTypesignalementAndIdstatut(idtypesignalement,idstatut);
        model.addAttribute("listeSignalements", lsc);
        model.addAttribute("typeSignalements", tsr.findAll());
        model.addAttribute("statuts", srep.findAll());
        return "rechercheAvance";
    }

}
