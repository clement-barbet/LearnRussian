package fr.brbt.learnrussian.controllers;

import fr.brbt.learnrussian.dbService;
import fr.brbt.learnrussian.models.Sentence;
import fr.brbt.learnrussian.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    dbService dbService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirect(HttpServletResponse httpResponse) throws Exception {
        httpResponse.sendRedirect("/index");
    }
    @GetMapping("index")
    public String index(Model model) {

        List<Sentence> sentenceList = new ArrayList<>();
        for(int i=0; i<5;++i) {
            sentenceList.add(dbService.getRandomSentence());
        }

        model.addAttribute("sentences", sentenceList);
        return "index";
    }
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("search")
    public String search(HttpServletRequest request, Model model) {
        String search_request = request.getParameter("search").toLowerCase(Locale.ROOT);
        List<Word> search_result;

        if (Pattern.matches(".*\\p{InCyrillic}.*", search_request)) {
            search_result =  dbService.searchWordByRussian(search_request);
        }
        else {
            search_result = dbService.searchWordByEnglish(search_request);
        }
        model.addAttribute("search_request", search_request);
        model.addAttribute("search_result", search_result);
        return "search";
    }
}
