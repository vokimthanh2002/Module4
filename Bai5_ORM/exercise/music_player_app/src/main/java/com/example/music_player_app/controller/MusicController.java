package com.example.music_player_app.controller;

import com.example.music_player_app.entyti.Music;
import com.example.music_player_app.service.IMusicService;
import com.example.music_player_app.service.impl.MusicService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    IMusicService musicService;
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("listMusic",musicService.getAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("music") Music music, RedirectAttributes rd){
        musicService.create(music);
        rd.addFlashAttribute("message", "Thêm mới music thành công");
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable("id") String id, Model model){
        model.addAttribute("music",musicService.finById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String doEdit(@ModelAttribute("music") Music music){
        musicService.update(music);
        return "redirect:/list";
    }
    @GetMapping("/remove/{id}")
    public String doDelete(@PathVariable("id") String id){
        Music music = musicService.finById(id);
        musicService.delete(musicService.finById(id));
        return "redirect:/list";
    }
    @GetMapping("/search")
    public String searchName(@RequestParam("inputSearch") String inputSearch,Model model){
        model.addAttribute("listMusic",musicService.findByNam(inputSearch));
        return "/list";
    }

}
