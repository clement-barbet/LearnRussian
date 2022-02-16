package fr.brbt.learnrussian.controllers;

import fr.brbt.learnrussian.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;
    @GetMapping("me")
        public String currentUserNameSimple(HttpServletRequest request, Model model) {
            Principal principal = request.getUserPrincipal();
            String profile = principal.getName();
        model.addAttribute("profile", userPrincipalDetailsService.countEntries());
            return "profile/me";
        }

}
