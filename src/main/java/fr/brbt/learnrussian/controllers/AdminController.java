package fr.brbt.learnrussian.controllers;

import fr.brbt.learnrussian.UserPrincipalDetailsService;
import fr.brbt.learnrussian.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;
    @GetMapping("index")
    public String index() {
        return "admin/index";
    }

  @PostMapping("addUser")
    public String submit(HttpServletRequest request) {

        String username = request.getParameter("username");
        userPrincipalDetailsService.addUser(username, "1234", "DEFAULT", "");

        return "/";

    }
}
