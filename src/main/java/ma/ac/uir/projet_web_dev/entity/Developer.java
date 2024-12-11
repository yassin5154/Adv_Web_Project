package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("DEVELOPER")
public class Developer extends User {

    @Column(name="availability", nullable = false)
    @org.hibernate.annotations.ColumnDefault("true")
    private boolean disponibilité = true;

    // Relation OneToMany avec AffectationEvaluation
    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AffectationEvaluation> liste_des_affectations;

    public boolean isDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(boolean disponibilité) {
        this.disponibilité = disponibilité;
    }

    public List<AffectationEvaluation> getListe_des_affectations() { return liste_des_affectations; }

    public void setListe_des_affectations(List<AffectationEvaluation> liste_des_affectations) { this.liste_des_affectations = liste_des_affectations; }

    // Constructors
    public Developer() {
        super();
    }

    public Developer(String nom, String prenom, String login, String motdepasse,String roleU, boolean disponibilité) {
        super(nom, prenom, login, motdepasse, roleU); // Call the constructor of the base class
        this.disponibilité = disponibilité;
    }

    public Developer(User user) {
        super(user.getId(), user.getNom(), user.getPrenom(), user.getLogin(), user.getMotdepasse(), user.getRoleU());
    }

    @Override
    public String toString() {
        return super.toString() + ", disponibilité=" + disponibilité + "]";
    }
}
