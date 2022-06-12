package fr.utc.sr03.chat.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Chats")
public class UC {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // strategy=GenerationType.IDENTITY => obligatoire pour auto increment mysql
    private long id;

    @Column(name = "id_User")
    private String idUser;

    @Column(name = "id_Chat")
    private String idChat;
}
