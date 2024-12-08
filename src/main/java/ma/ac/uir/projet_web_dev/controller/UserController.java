package ma.ac.uir.projet_web_dev.controller;


import jakarta.servlet.http.HttpSession;
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
    public String loginUser(@RequestParam String login, @RequestParam String motdepasse, Model model) {
        // Vérification des informations d'identification
        User user = userRepository.findByLoginAndMotdepasse(login, motdepasse);
        model.addAttribute("userId", user.getId());
        if (user != null) {
            // Redirection en fonction du rôle
            if ("Chef de Projet".equalsIgnoreCase(user.getRoleU())) {
                return "chef-projet-dashboard";
            } else if ("Développeur".equalsIgnoreCase(user.getRoleU())) {
                return "developer-dashboard";
            }
        }
        // Ajout d'un message d'erreur en cas d'échec
        model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){
        usServ.save(theUser);
        return "redirect:/users/login";
    }

    @GetMapping("/account")
    public String showAccountDetails(@RequestParam("userId") int id, Model leModel) {
        try {
            // Fetch the user by ID
            User theUser = usServ.findById(id);
            if (theUser != null) {
                leModel.addAttribute("user", theUser);
                return "account-form";
            } else {
                leModel.addAttribute("error", "Utilisateur introuvable.");
                return "error-page"; // Replace with your error template
            }
        } catch (Exception e) {
            leModel.addAttribute("error", "Une erreur est survenue !");
            return "error-page"; // Replace with your error template
        }
    }

    @PostMapping("/update")
    public String updateAccount(@ModelAttribute("user") User user, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null && userId.equals(user.getId())) {
            usServ.save(user); // Save the updated user details
            return "redirect:/users/account?success"; // Redirect with success message
        } else {
            return "redirect:/users/login";
        }
    }







}
