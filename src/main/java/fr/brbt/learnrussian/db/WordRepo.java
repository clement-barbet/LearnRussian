package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepo extends CrudRepository<Word, Long> {
    Word findWordById(int id);
    Word findWordsByRuword(String word);

    @Query(value = "SELECT * FROM words WHERE position(:search in ru_word) > 0 ORDER BY (ru_word = :search) DESC, RANK, RU_WORD" , nativeQuery=true)
    List<Word> searchWordsByRussian(@Param("search") String search);

    @Query(value = "SELECT * FROM words WHERE position(:search in en_word) > 0 ORDER BY (en_word = :search) DESC, RANK, EN_WORD" , nativeQuery=true)
    List<Word> searchWordsByEnglish(@Param("search") String search);


}
