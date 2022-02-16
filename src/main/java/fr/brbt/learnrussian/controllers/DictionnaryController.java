package fr.brbt.learnrussian.controllers;

import fr.brbt.learnrussian.dbService;
import fr.brbt.learnrussian.models.Sentence;
import fr.brbt.learnrussian.models.Translation;
import fr.brbt.learnrussian.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("dictionnary")


public class DictionnaryController {
    @Autowired
    dbService dbService;

    @GetMapping("")
    public void redirect(HttpServletResponse httpResponse) throws Exception {
        httpResponse.sendRedirect("dictionnary/index");
    }
    @GetMapping("index")
    public String getIndex() {
        return "dictionnary/index";
    }
    @GetMapping("word/{ruword}")
    public String dictionnary(Model model, @PathVariable("ruword") String ruword) {
        Word word = dbService.getWordByRuword(ruword);
        List<Translation> translations = dbService.getTranslationsByWord(word);
        Sentence example = dbService.getRandomSentenceByWord(word);

        model.addAttribute("word", word);
        model.addAttribute("translations", translations);
        model.addAttribute("example", example);
        return "dictionnary/word";
    }
}
