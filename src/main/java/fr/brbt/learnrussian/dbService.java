package fr.brbt.learnrussian;

import fr.brbt.learnrussian.db.*;
import fr.brbt.learnrussian.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class dbService {
    @Autowired
    Sentence2WordRepo sentence2wordRepo;
    @Autowired
    SentenceRepo sentenceRepo;
    @Autowired
    TranslationRepo translationRepo;
    @Autowired
    WordRepo wordRepo;
    @Autowired
    RevisionRepo revisionRepo;

    public Sentence getRandomSentence() {
        return sentenceRepo.getRandom();
    }

    public Sentence getRandomSentenceByLevel(String level) {
        return sentenceRepo.getRandomByLevel(level.toUpperCase());
    }

    public Word getWordByRuword(String word) {
        return wordRepo.findWordsByRuword(word);
    }

    public Sentence getRandomSentenceByWord(Word word) {
        int word_id = word.getId();
        int sentence_id = sentence2wordRepo.getRandomSentence2WordByWordID(word_id).getSentence_id();
        return sentenceRepo.findSentenceById(sentence_id);
    }

    public List<Translation> getTranslationsByWord(Word word) {
        return translationRepo.findTranslationsByWordID(word.getId());
    }

    public List<Word> searchWordByRussian(String search) {
        return wordRepo.searchWordsByRussian(search);
    }

    public List<Word> searchWordByEnglish(String search) {
        List <Translation> translations = translationRepo.searchTranslationsByEnglish(search);
        List <Word> words = new ArrayList<>();
        for (Translation translation : translations) {
            words.add(wordRepo.findWordById(translation.getWordID()));
        }

        return words;
    }

    public List<Word> searchAllWordsByUser(User user) {
        List<Revision> revision = revisionRepo.findAllByUserID(user.getId());
        List<Word> wordList = new ArrayList<>();

        for (Revision revision1 : revision) {
            wordList.add(wordRepo.findWordById(revision1.getWordID()));

        }


        return wordList;
    }



    public void deleteWordFromUser(User user, Word word) {
        revisionRepo.deleteRevisionByWordIDAndUserID(word.getId(), user.getId());
    }

    public List<Word> getWordsFromSentence(Sentence sentence){
        int sentence_id = sentence.getId();
        List<Sentence2Word> sentence2WordList = sentence2wordRepo.findSentence2WordBySentenceid(sentence_id);
        List<Word> wordList = new ArrayList<>();
        for (Sentence2Word sentence2Word : sentence2WordList) {
            wordList.add(wordRepo.findWordById(sentence2Word.getWordid()));
        }

        return wordList;

    }
    public Word getRandomWordByUser(User user) {
        return wordRepo.findWordById(revisionRepo.findRandomByUserID(user.getId()).getWordID());
    }

    public void saveWordByUser(User user, Word word) {

        Revision revision = new Revision((int) (revisionRepo.count()+1), user.getId(), word.getId());
        revisionRepo.save(revision);
    }
}