package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idU")
    private int idu;

    @Column(name="first_name")
    private String prenom;

    @Column(name="last_name")
    private String nom;

    @Column(name="loginU")
    private String login;

    @Column(name="password")
    private String mot_de_passe;

    // define constructors
    public User() {

    }

    public User(String nom, String prenom, String login, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    public User(int idu,String nom, String prenom, String login, String mot_de_passe) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    // define getter/setter

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return mot_de_passe;
    }

    public void setMotdepasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }


    public String toString() {
        return "Employee{" +
                "id=" + idu +
                ", firstName='" + prenom + '\'' +
                ", lastName='" + nom + '\'' +
                ", login='" + login + '\'' +
                ", mot de passe='" + mot_de_passe + '\'' +
                '}';
    }
}