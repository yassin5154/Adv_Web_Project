package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

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

    // define constructors
    public Project() {

    }

    public Project(String titre, String description, String dureeestime, String etat) {
        this.titre = titre;
        this.description = description;
        this.dureeestime = dureeestime;
        this.etat = etat;
    }

    public Project(int id, String titre, String description, String dureeestime, String etat) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dureeestime = dureeestime;
        this.etat = etat;
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
