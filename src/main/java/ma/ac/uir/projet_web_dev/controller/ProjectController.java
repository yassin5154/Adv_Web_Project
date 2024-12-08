package ma.ac.uir.projet_web_dev.controller;


import ma.ac.uir.projet_web_dev.dao.ProjectRepository;
import ma.ac.uir.projet_web_dev.dao.UserRepository;
import ma.ac.uir.projet_web_dev.service.ProjectService;
import ma.ac.uir.projet_web_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    private ProjectService pjServ;

    @Autowired
    public ProjectController(ProjectService projectService){ this.pjServ = projectService;}
}
