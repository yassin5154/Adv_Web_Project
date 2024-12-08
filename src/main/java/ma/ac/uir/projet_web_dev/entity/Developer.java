package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Developer extends User {

    @Column(name="availability", nullable = false)
    @org.hibernate.annotations.ColumnDefault("true")
    private boolean disponibilité = true;


    public boolean isDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(boolean disponibilité) {
        this.disponibilité = disponibilité;
    }

    // Constructors
    public Developer() {
        super();
    }

    public Developer(String nom, String prenom, String login, String motdepasse,String roleU, boolean disponibilité) {
        super(nom, prenom, login, motdepasse, roleU); // Call the constructor of the base class
        this.disponibilité = disponibilité;
    }

    @Override
    public String toString() {
        return super.toString() + ", disponibilité=" + disponibilité + "]";
    }
}
