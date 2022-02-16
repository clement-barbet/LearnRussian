package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.Revision;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RevisionRepo extends CrudRepository<Revision, Long> {
    List<Revision> findAllByUserID(int userID);
    @Query(value = "SELECT * FROM revision WHERE user_id = :userid ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Revision findRandomByUserID(@Param("userid") int userid);

    @Transactional
    void deleteRevisionByWordIDAndUserID(int wordID, int userID);

}
