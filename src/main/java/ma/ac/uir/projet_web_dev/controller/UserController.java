package ma.ac.uir.projet_web_dev.controller;


import ma.ac.uir.projet_web_dev.dao.UserRepository;
import ma.ac.uir.projet_web_dev.entity.User;
import ma.ac.uir.projet_web_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping ("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService usServ;
    @Autowired
    public UserController(UserService userService){ this.usServ = userService;}

    @GetMapping ("/login")
    public String LoginUser(@ModelAttribute User user) {
        return "authentification-form";
    }

    @GetMapping ("/register")
    public String RegisterUser(Model leModel) {
        User theUser = new User();
        leModel.addAttribute("user", theUser);
        return "inscription-form";
    }

    @PostMapping("/loginuser")
    public String loginUser(@RequestParam String login, @RequestParam String mot_de_passe, Model model) {
        // Vérification des informations d'identification
        User user = userRepository.findByLoginAndMotdepasse(login, mot_de_passe);

        if (user != null) {
            // Redirection en fonction du rôle
            if ("Chef de Projet".equalsIgnoreCase(user.getRoleU())) {
                return "chef-projet-dashboard";
            } else if ("Développeur".equalsIgnoreCase(user.getRoleU())) {
                return "redirect:/developpeur-dashboard";
            }
        }
        // Ajout d'un message d'erreur en cas d'échec
        model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
        return "login";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){
        usServ.save(theUser);
        return "redirect:/users/login";
    }

    @GetMapping ("/dashboard/chef-projet")
    public String DashboardChefProjet(@ModelAttribute User user) {
        return "chef-projet-dashboard";
    }



}
