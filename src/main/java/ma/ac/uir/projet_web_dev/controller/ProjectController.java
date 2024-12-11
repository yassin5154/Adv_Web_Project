package ma.ac.uir.projet_web_dev.controller;


import ma.ac.uir.projet_web_dev.entity.*;
import ma.ac.uir.projet_web_dev.service.AffectationEvaluationService;
import ma.ac.uir.projet_web_dev.service.ProjectService;
import ma.ac.uir.projet_web_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService pjServ;
    private UserService usServ;
    private AffectationEvaluationService afServ;


    @Autowired
    public ProjectController(ProjectService projectService, UserService userService, AffectationEvaluationService affectationEvaluationService){
        this.pjServ = projectService;
        this.usServ = userService;
        this.afServ = affectationEvaluationService;
    }

    @GetMapping("/new")
    public String showCreateProjectForm(@RequestParam("userId") int id, Model model) {
        model.addAttribute("project", new Project());
        List<User> developers = usServ.findByRole("Développeur");
        model.addAttribute("developers", developers);
        User theUser = usServ.findById(id);
        if (theUser != null) {
            model.addAttribute("user", theUser);}
        return "new-project";
    }
    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam("userId") int userId, Model model) {
        // Récupérer les projets du chef de projet
        List<Project> projects = pjServ.findProjectsByUserId(userId);

        if (projects == null || projects.isEmpty()) {
            model.addAttribute("message", "Aucun projet trouvé pour cet utilisateur.");
        }

        model.addAttribute("projects", projects);
        model.addAttribute("userId", userId); // Pour la navigation
        return "chef-projet-dashboard";
    }

    @PostMapping("/save")
    public String saveProject(@RequestParam("userId") int userId,
                              @RequestParam("developerIds") List<Integer> developerIds,
                              @ModelAttribute("project") Project project) {
        // Récupérer l'utilisateur connecté (ChefDeProjet)
        User chef = usServ.findById(userId);
        if (chef != null) {
            // Créer un projet et l'enregistrer
            project.setChefDeProjet(chef); // Définir le chef de projet
            Project savedProject = pjServ.save(project);

            // Enregistrer les affectations dans la table AffectationEvaluation
            for (Integer developerId : developerIds) {
                User developer = usServ.findById(developerId);
                if (developer != null) {
                    AffectationEvaluation affectation = new AffectationEvaluation();
                    affectation.setProject(savedProject);
                    affectation.setDeveloper(developer);
                    afServ.save(affectation);
                }
            }
        }
        return "chef-projet-dashboard";
    }


}
