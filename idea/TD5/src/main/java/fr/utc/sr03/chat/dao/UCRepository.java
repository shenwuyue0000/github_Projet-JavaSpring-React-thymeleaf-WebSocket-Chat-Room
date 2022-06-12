package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.UC;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UCRepository extends JpaRepository<UC, Long> {


}
