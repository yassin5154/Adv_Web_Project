package ma.ac.uir.projet_web_dev.controller;


import ma.ac.uir.projet_web_dev.entity.User;
import ma.ac.uir.projet_web_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping ("/users")
public class UserController {
    private UserService usServ;
    @Autowired
    public UserController(UserService userService){ this.usServ = userService;}

    @GetMapping ("/login")
    public String LoginUser(@ModelAttribute User user) {
        return "authentification-form";
    }

    /*// Traiter le formulaire de connexion
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        // Vérifier l'utilisateur dans la base de données
        User existingUser = usServ.findByLoginAndMot_de_passe(user.getLogin(), user.getMot_de_passe());
        if (existingUser != null) {
            // Rediriger selon le rôle de l'utilisateur
            if ("Chef de projet".equalsIgnoreCase(existingUser.getRoleU())) {
                return "redirect:/dashboard/chef-projet";
            } else if ("Développeur".equalsIgnoreCase(existingUser.getRoleU())) {
                return "redirect:/dashboard/developpeur";
            } else {
                // Rôle inconnu
                model.addAttribute("error", "Rôle inconnu !");
                return "authentification-form";
            }
        }

        // Si l'utilisateur n'existe pas ou mot de passe incorrect
        model.addAttribute("error", "Login ou mot de passe incorrect.");
        return "authentification-form";
    }*/

    @GetMapping ("/register")
    public String RegisterUser(Model leModel) {
        User theUser = new User();
        leModel.addAttribute("user", theUser);
        return "inscription-form";
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
