package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AffectationEvaluation")
public class AffectationEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idA")
    private int id;

    @Column(name = "rating")
    private String evaluation;

    @Column(name = "feedback")
    private String commentaire;

    // Relation ManyToOne avec Projet
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id") // Clé étrangère dans la table Project
    private Project project;

    // Relation ManyToOne avec Développeur
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id") // Clé étrangère dans la table Developer
    private User developer;

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    // Methode toString
    @Override
    public String toString() {
        return "AffectationEvaluation{" +
                "id=" + id +
                ", evaluation='" + evaluation + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", project=" + project +
                ", developer=" + developer +
                '}';
    }
}
