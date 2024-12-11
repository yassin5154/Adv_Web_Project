package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idP")
    private int id;

    @Column(name = "title")
    private String titre;

    @Column(name = "descriptionP")
    private String description;

    @Column(name = "estimated duration")
    private String dureeestime;

    @Column(name = "state")
    private String etat;

    // Relation ManyToOne avec ChefDeProjet
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id") // Clé étrangère dans la table Project
    private User chefDeProjet;

   // Relation OneToMany avec AffectationEvaluation
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AffectationEvaluation> liste_des_affectations;

    // define constructors
    public Project() {

    }

    public Project(String titre, String description, String dureeestime, String etat, User chefDeProjet) {
        this.titre = titre;
        this.description = description;
        this.dureeestime = dureeestime;
        this.etat = etat;
        this.chefDeProjet = chefDeProjet;
    }

        public Project(int id, String titre, String description, String dureeestime, String etat, User chefDeProjet) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dureeestime = dureeestime;
        this.etat = etat;
        this.chefDeProjet = chefDeProjet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public String getDureeestime() {
        return dureeestime;
    }

    public void setDureeestime(String dureeestime) { this.dureeestime = dureeestime; }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) { this.etat = etat; }

    public ChefProjet getChefDeProjet() { return (ChefProjet) chefDeProjet; }

    public void setChefDeProjet(User chefDeProjet) { this.chefDeProjet = chefDeProjet; }

    public List<AffectationEvaluation> getListe_des_affectations() { return liste_des_affectations; }

    public void setListe_des_affectations(List<AffectationEvaluation> liste_des_affectations) { this.liste_des_affectations = liste_des_affectations; }


    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", durée estimé='" + dureeestime + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }


}
