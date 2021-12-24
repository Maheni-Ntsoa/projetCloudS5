package com.spring.backoffice.controller;

import com.spring.backoffice.model.Admin;
import com.spring.backoffice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    public AdminController() {
        System.out.println("AdminController()");
    }

    @Autowired
    AdminRepository ar;

    @RequestMapping("/admins")
    public String home(Model model){
        model.addAttribute("admins", ar.findAll());
        return "admins";
    }

    @RequestMapping("/admins/{id}")
    public String testSession(HttpServletRequest request, Model model, @PathVariable(value = "id") Long idAdmin) {
        Admin admin = null;
        try {
            admin = ar.findById(idAdmin)
                    .orElseThrow(() -> new Exception("Admin not found for this id :: " + idAdmin));
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admins";
    }

    @RequestMapping("/")
    public ModelAndView testa() {
        return new ModelAndView("hello");
    }
}
