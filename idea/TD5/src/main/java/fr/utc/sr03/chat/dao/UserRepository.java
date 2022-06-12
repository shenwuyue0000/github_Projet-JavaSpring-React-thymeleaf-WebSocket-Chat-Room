package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    <S extends User> List<S> findAll(Example<S> example);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findById(long id);

    List<User> findByMailAndPassword(String mail, String password);

    //List<User> findByFirstnameAndLastname(String mail, String password);

    <S extends User> S save(S entity);

    @Transactional
    @Modifying
    @Query("update User u set u.mail = ?3, u.password=?4 where u.firstName = ?1 and u.lastName=?2 ")
    void update(String firstName, String lastName, String mail, String password);


}
