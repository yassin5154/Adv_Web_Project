package ma.ac.uir.projet_web_dev.service;

import ma.ac.uir.projet_web_dev.entity.Project;

import java.util.List;


public interface ProjectService {
    Project save(Project theProject);
    List<Project> findProjectsByUserId(int userId);
}
