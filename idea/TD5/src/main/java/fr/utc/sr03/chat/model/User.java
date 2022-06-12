package fr.utc.sr03.chat.model;

import javax.persistence.*;

@Entity
@Table(name = "sr03_users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // strategy=GenerationType.IDENTITY => obligatoire pour auto increment mysql
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private int admin;



    public User(){}

    public User(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public User(String firstName, String lastName, String mail){
        setFirstName(firstName);
        setLastName(lastName);
        setMail(mail);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isAdmin() { return admin; }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
