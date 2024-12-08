package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idS")
    private int id;

    @Column(name="name")
    private String nom;

    @Column(name="level")
    private String niveau;

    @Column(name = "descriptionS")
    private String description;

    // define constructors
    public Skill() {

    }

    public Skill(String nom, String niveau, String description) {
        this.nom = nom;
        this.niveau = niveau;
        this.description = description;
    }

    public Skill(int id, String nom, String niveau, String description) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) { this.nom = nom; }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) { this.niveau = niveau; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }


    public String toString() {
        return "Compétence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ",  niveau='" + niveau + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
