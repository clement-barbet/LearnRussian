package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.Translation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TranslationRepo extends CrudRepository<Translation, Long> {
    List<Translation> findTranslationsByWordID(int word_id);

    @Query(value = "SELECT * FROM translations WHERE position(:search in translation) > 0 ORDER BY (translation = :search) DESC, translation" , nativeQuery=true)
    List<Translation> searchTranslationsByEnglish(@Param("search") String search);
}
