package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.Sentence2Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Sentence2WordRepo extends CrudRepository<Sentence2Word, Long> {
    List<Sentence2Word> findSentence2WordBySentenceid(int sentenceid);
    List<Sentence2Word> findSentence2WordByWordid(String word);

    @Query(value = "SELECT * FROM sentences_words WHERE word_id = :wordid ORDER BY RANDOM() LIMIT 1" , nativeQuery=true)
    Sentence2Word getRandomSentence2WordByWordID(@Param("wordid") int wordid);


}