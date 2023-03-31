package com.example.validate_music.controller;

import com.example.validate_music.bean.Music;
import com.example.validate_music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class MusicController {
    @Autowired
    MusicService musicService;
    @GetMapping(value = "")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String createValidate(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult, @RequestParam("img") MultipartFile img){
        if(bindingResult.hasErrors()){
            return "/create";
        }else{
            if (img.isEmpty()){
                music.setUrlMusic("");
            }
            Path path = Paths.get("upload/");
            try{
                InputStream inputStream = img.getInputStream();
                Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                music.setUrlMusic(img.getOriginalFilename().toLowerCase());
            } catch (IOException e) {
                e.printStackTrace();
            }

            musicService.save(music);
            return "/result";
        }
    }
}
