package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.ChatRoom;
import fr.utc.sr03.chat.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface ChatRepository extends JpaRepository<ChatRoom, Long> {
    //@Override
    //<S extends ChatRoom> List<S> findAll(Example<S> example);

    @Override
    <S extends ChatRoom> List<S> findAll(Example<S> example);

    List<ChatRoom> findByTempsDebutAndTempsFin(String temps_debut, String temps_fin);

    List<ChatRoom> findById(long id);

    List<ChatRoom> findByNbUsers(int nb_users);


    <S extends ChatRoom> S save(S entity);

    @Transactional
    @Modifying
    @Query("update ChatRoom c set c.nbUsers = ?3 where c.tempsDebut = ?1 and c.tempsFin=?2 ")
    void update(String temps_debut, String temps_fin, int nb_users);


}
