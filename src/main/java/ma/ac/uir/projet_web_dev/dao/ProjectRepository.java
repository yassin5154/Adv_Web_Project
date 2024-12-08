package ma.ac.uir.projet_web_dev.dao;

import ma.ac.uir.projet_web_dev.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Integer> {
}
