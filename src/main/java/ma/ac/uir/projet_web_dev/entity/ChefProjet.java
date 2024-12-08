package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.Entity;

@Entity
public class ChefProjet extends User {

    // Default constructor
    public ChefProjet() {
        super();
    }

    // Constructor with User's attributes
    public ChefProjet(String nom, String prenom, String login, String motdepasse, String roleU) {
        super(nom, prenom, login, motdepasse, roleU); // Call the constructor of the base class
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

