package ma.ac.uir.projet_web_dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idU")
    private int id;

    @Column(name="first_name")
    private String prenom;

    @Column(name="last_name")
    private String nom;

    @Column(name="loginU")
    private String login;

    @Column(name="password")
    private String motdepasse;

    @Column(name="role")
    private String roleU;

    // define constructors
    public User() {

    }

    public User(String nom, String prenom, String login, String motdepasse, String roleU) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motdepasse = motdepasse;
        this.roleU = roleU;
    }

    public User(int id,String nom, String prenom, String login, String motdepasse, String roleU) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motdepasse = motdepasse;
        this.roleU = roleU;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getRoleU() {
        return roleU;
    }

    public void setRoleU(String roleU) {
        this.roleU = roleU;
    }


    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + prenom + '\'' +
                ", lastName='" + nom + '\'' +
                ", login='" + login + '\'' +
                ", mot de passe='" + motdepasse + '\'' +
                ", role='" + roleU + '\'' +
                '}';
    }
}
