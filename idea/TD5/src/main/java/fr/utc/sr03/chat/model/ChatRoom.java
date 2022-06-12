package fr.utc.sr03.chat.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // strategy=GenerationType.IDENTITY => obligatoire pour auto increment mysql
    private long id;

    @Column(name = "tempsdebut")
    private String tempsDebut;

    @Column(name = "tempsfin")
    private String tempsFin;

    @Column(name = "nbusers")
    private int nbUsers;

    @Column(name = "proprietaire")
    private int proprietaire;

    public ChatRoom(){}

    public ChatRoom(String temps_debut, String temps_fin, int nb_users, int proprietaire){
        //setId(id);
        setTempsDebut(temps_debut);
        setTempsFin(temps_fin);
        setNbUsers(nb_users);
        setProprietaire(proprietaire);
    }

    public ChatRoom(int proprietaire){
        setProprietaire(proprietaire);
    }



    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    public String getTempsDebut() { return tempsDebut; }
    public void setTempsDebut(String temps_debut) {
        this.tempsDebut = temps_debut;
    }

    public String getTempsFin() { return tempsFin; }
    public void setTempsFin(String temps_fin) {
        this.tempsFin = temps_fin;
    }

    public int getNbUsers() { return nbUsers; }
    public void setNbUsers(int nb_users) {
        this.nbUsers = nb_users;
    }

    public int getProprietaire() {return proprietaire;}
    public void setProprietaire(int proprietaire) {this.proprietaire=proprietaire;}

}
