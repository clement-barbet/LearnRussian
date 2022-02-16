package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.Sentence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceRepo extends CrudRepository<Sentence, Long> {

    // FIND SENTENCE BY ID (UNIQUE RESULT)
    Sentence findSentenceById(int id);

    // FIND SENTENCES BY LEVEL
    List<Sentence> findSentenceByLevel(String level);

    // GET RANDOM PHRASE
    @Query(value="SELECT * FROM sentences ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Sentence getRandom();

    // GET RANDOM PHRASE WITH LEVEL
    @Query(value = "SELECT * FROM sentences WHERE level = :level ORDER BY RANDOM() LIMIT 1" , nativeQuery=true)
    Sentence getRandomByLevel(@Param("level") String level);



}