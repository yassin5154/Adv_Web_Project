package ma.ac.uir.projet_web_dev.service;

import ma.ac.uir.projet_web_dev.dao.ProjectRepository;
import ma.ac.uir.projet_web_dev.dao.UserRepository;
import ma.ac.uir.projet_web_dev.entity.Developer;
import ma.ac.uir.projet_web_dev.entity.Project;
import ma.ac.uir.projet_web_dev.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository theProjectRespository, UserRepository theUserRespository){
        this.projectRepository = theProjectRespository;
        this.userRepository = theUserRespository;

    }

    @Override
    public Project save(Project theProject) {
        return projectRepository.save(theProject);
    }

    @Override
    public List<Project> findProjectsByUserId(int userId) {
        return projectRepository.findByChefDeProjetId(userId);
    }
}
