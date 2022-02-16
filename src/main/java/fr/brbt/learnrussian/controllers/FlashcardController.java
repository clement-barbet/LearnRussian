package fr.brbt.learnrussian.controllers;

import fr.brbt.learnrussian.UserPrincipalDetailsService;
import fr.brbt.learnrussian.dbService;
import fr.brbt.learnrussian.models.Sentence;
import fr.brbt.learnrussian.models.User;
import fr.brbt.learnrussian.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

@Controller
@RequestMapping("flashcard")
public class FlashcardController {
    @Autowired
    dbService dbService;
    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;
    @GetMapping("index")
    public String getIndex() {

        return "flashcard/index";
    }

    @GetMapping("addword")
    public String addPage(HttpServletRequest http, Model model) {


        Principal principal = http.getUserPrincipal();
        User user = userPrincipalDetailsService.getUserByUsername(principal.getName());

        List<Word> wordList = dbService.searchAllWordsByUser(user);

        model.addAttribute("wordlist", wordList);

        return "flashcard/addword";
    }

    @PostMapping("addword")
    public String addWord(HttpServletRequest http, Model model) {

        String url = http.getRequestURI();


        Principal principal = http.getUserPrincipal();

        String username = principal.getName();
        String word_ru = http.getParameter("word");

        User user = userPrincipalDetailsService.getUserByUsername(username);
        Word word = dbService.getWordByRuword(word_ru);


        dbService.saveWordByUser(user,word);
        model.addAttribute("wordAdded", "The world " + word_ru + " has been added succesfully !");

        List<Word> wordList = dbService.searchAllWordsByUser(user);
        model.addAttribute("wordlist", wordList);

        return url;
    }

    @PostMapping("delword")
    public String delWord(HttpServletRequest http, Model model) {
        Principal principal = http.getUserPrincipal();


        String word_ru = http.getParameter("wordDeleted");
        String username = principal.getName();

        User user = userPrincipalDetailsService.getUserByUsername(username);
        Word word = dbService.getWordByRuword(word_ru);

        dbService.deleteWordFromUser(user, word);
        List<Word> wordList = dbService.searchAllWordsByUser(user);
        model.addAttribute("wordlist", wordList);

        return "flashcard/addword";

    }
    

    @GetMapping("random")
    public String random(HttpServletRequest http, Model model) {
        Principal principal = http.getUserPrincipal();
        User user = userPrincipalDetailsService.getUserByUsername(principal.getName());

        Word randomWord = dbService.getRandomWordByUser(user);
        Sentence randomSentence = dbService.getRandomSentenceByWord(randomWord);

        List<Word> randomSentenceWords = dbService.getWordsFromSentence(randomSentence);

        List<Word> userWords = dbService.searchAllWordsByUser(user);
        List<String> usernameList = new ArrayList<>();
        for (Word userWord : userWords) {
            usernameList.add(userWord.getRuword());
        }

        try {
            for (Word randomSentenceWord : randomSentenceWords) {
                if (usernameList.contains(randomSentenceWord.getRuword())) {
                    randomSentenceWords.remove(randomSentenceWord);
                    System.out.println(randomSentenceWord.getRuword() + " DETECTED");
                }
            }
        }
        catch (ConcurrentModificationException e) {
        }


        model.addAttribute("ru_sentence", randomSentence.getPhrase_ru());
        model.addAttribute("en_sentence", randomSentence.getPhrase_en());
        model.addAttribute("words_sentences", randomSentenceWords);

        return "flashcard/random";
    }


}
