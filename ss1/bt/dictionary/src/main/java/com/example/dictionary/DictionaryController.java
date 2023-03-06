package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String viewDictionary(){
        return "/dictionary";
    }

    @PostMapping("/search")
    public String getDictionary(Model model, @RequestParam String eng){
        String[] english = {"Hello","GoodBye"};
        String[] vietnamese = {"Xin Chào","Tạm Biệt"};
        String search = "";
        for(int i = 0; i < english.length; i++){
            if(eng.equals(english[i])){
                search += vietnamese[i];
            }
        }
        model.addAttribute("result",search);
        return "/dictionary";
    }
}