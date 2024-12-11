package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("CHEF_PROJET")
public class ChefProjet extends User {

    // Relation OneToMany avec Project
    @OneToMany(mappedBy = "chefDeProjet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projets;

    // Default constructor
    public ChefProjet() {
        super();
    }

    // Constructor with User's attributes
    public ChefProjet(String nom, String prenom, String login, String motdepasse, String roleU) {
        super(nom, prenom, login, motdepasse, roleU); // Call the constructor of the base class
    }

    public List<Project> getProjets() {
        return projets;
    }

    public void setProjets(List<Project> projets) {
        this.projets = projets;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

